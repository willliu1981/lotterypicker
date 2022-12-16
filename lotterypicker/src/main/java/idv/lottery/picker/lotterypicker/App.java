package idv.lottery.picker.lotterypicker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;

import idv.lottery.picker.lotterypicker.stage.ActionSkd;
import idv.lottery.picker.lotterypicker.stage.BaseAction;

/**
 * Hello world!
 *
 */
public class App {
	final static String START = "start";
	static Timer timer;
	static ActionSkd task = new ActionSkd();

	static class TestAction extends BaseAction {
		String name;

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public void start() {
			System.out.println("V3 Start!");
		}

		@Override
		public void update() {
			System.out.printf("This is %s\n", name);
			this.destroy();
		}

		@Override
		public void end() {
			System.out.printf("Destroy by %s\n", name);
		}

	}

	static class CountDownAction extends BaseAction {
		int i = 3;
		List<TestAction> testActs = new ArrayList<>(0);

		public void addTestAction(TestAction act) {
			this.testActs.add(act);
		}

		@Override
		public void start() {
			System.out.println("Show time!");
		}

		@Override
		public void update() {
			System.out.println(i--);
			if (i == 0) {
				testActs.forEach(TestAction::spawn);
				this.destroy();
			}
		}

	}

	public static void main(String[] args) {
		init();
		CountDownAction cntAct = new CountDownAction();
		prepareTestActions(task, cntAct);

		System.out.println("Welcome to Lottery World");
		System.out.printf("Please input %s\n", START);

		Scanner sc = new Scanner(System.in);
		String input = null;

		while (sc.hasNextLine()) {
			input = sc.nextLine();
			if (input.equalsIgnoreCase(START)) {
				System.out.println("It is game time!");

				cntAct.spawn();
			} else {
				System.out.println("Nothing happen");
			}

		}
	}

	static void init() {
		timer = new Timer();
		timer.schedule(task, 1000, 200);
	}

	static void prepareTestActions(ActionSkd task, CountDownAction cntAct) {
		TestAction act = new TestAction();
		act.setName("David");
		cntAct.addTestAction(act);
		task.addAction(act);

		TestAction act2 = new TestAction();
		act2.setName("Mary");
		cntAct.addTestAction(act2);
		task.addAction(act2);

		task.addAction(cntAct);

	}

}
