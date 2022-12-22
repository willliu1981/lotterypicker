package idv.lottery.picker.lotterypicker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;

import org.junit.jupiter.api.Test;

import idv.lottery.picker.lotterypicker.gameobjects.GameObject;
import idv.lottery.picker.lotterypicker.gameobjects.balls.MainBall;
import idv.lottery.picker.lotterypicker.graphic.Location;
import idv.lottery.picker.lotterypicker.stage.timer.ActionSkd;
import idv.lottery.picker.lotterypicker.stage.timer.BallAction;

/**
 * Hello world!
 *
 */
public class App {
	final static String START = "start";
	public static Timer timer;
	public static ActionSkd task = new ActionSkd();

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

	public static void init() {
		timer = new Timer();
		timer.schedule(task, 1000, 10);
	}

	public static void preparePickerAction(ActionSkd task) {
		BallAction act = null;
		GameObject ball = null;


		for (int i = 1; i <= 49; i++) {
			ball = new MainBall(String.format("no.%d", i), i);
			ball.setLocation(new Location(0, 0));
			act = new BallAction();
			act.setBall(ball);
			task.addAction(act);
			act.spawn();
		}

	}

	@Test
	public void test1() {
		List aa = new ArrayList<>();
		aa.remove(new Object());
		System.out.println("ok");
	}

}
