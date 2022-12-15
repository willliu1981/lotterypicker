package idv.lottery.picker.lotterypicker;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import idv.lottery.picker.lotterypicker.stage.Action;
import idv.lottery.picker.lotterypicker.stage.ActionSkd;

/**
 * Hello world!
 *
 */
public class App {
	final static String START = "start";
	static Timer timer;
	static TestAction act = new TestAction();

	static class TestAction implements Action {
		int i;
		boolean isSpawned;
		boolean isEnded;

		public void spawn() {
			this.isSpawned = true;
		}

		@Override
		public void start() {
			System.out.println("Start!");
		}

		@Override
		public void update() {
			System.out.printf("Show time! (%d times)\n", i++);
			if (i >= 10) {
				isEnded = true;
			}
		}

		@Override
		public void end() {
			System.out.println("See you next time!");
		}

		@Override
		public boolean isEnded() {
			return isEnded;
		}

		@Override
		public boolean isSpawned() {
			return isSpawned;
		}

	}

	public static void main(String[] args) {
		init();

		System.out.println("Welcome to Lottery World");
		System.out.printf("Please input %s\n", START);

		Scanner sc = new Scanner(System.in);
		String input = null;

		while (sc.hasNextLine()) {
			input = sc.nextLine();
			if (input.equalsIgnoreCase(START)) {
				System.out.println("It is game time!");
				act.spawn();
			} else {
				System.out.println("Nothing happen");
			}

		}
	}

	static void init() {

		TimerTask task = new ActionSkd(act);
		timer = new Timer();
		timer.schedule(task, 1000, 200);
	}
}
