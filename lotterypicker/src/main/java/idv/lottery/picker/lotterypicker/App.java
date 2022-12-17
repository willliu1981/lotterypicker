package idv.lottery.picker.lotterypicker;

import java.awt.Point;
import java.util.Scanner;
import java.util.Timer;

import idv.lottery.picker.lotterypicker.balls.Ball;
import idv.lottery.picker.lotterypicker.balls.MainBall;
import idv.lottery.picker.lotterypicker.stage.ActionSkd;
import idv.lottery.picker.lotterypicker.stage.BallAction;

/**
 * Hello world!
 *
 */
public class App {
	final static String START = "start";
	static Timer timer;
	static ActionSkd task = new ActionSkd();

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
				preparePickerAction(task);
			} else {
				System.out.println("Nothing happen");
			}

		}
	}

	static void init() {
		timer = new Timer();
		timer.schedule(task, 1000, 200);
	}

	static void preparePickerAction(ActionSkd task) {
		BallAction act = null;
		Ball ball = null;
		for (int i = 1; i <= 1; i++) {
			ball = new MainBall(String.format("no.%d", i), i);
			ball.setLocation(new Point(0,0));
			act = new BallAction();
			act.setBall(ball);
			task.addAction(act);
			act.spawn();
		}

	}

}
