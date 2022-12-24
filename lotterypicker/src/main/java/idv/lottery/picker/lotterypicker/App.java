package idv.lottery.picker.lotterypicker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;

import org.junit.jupiter.api.Test;

import idv.lottery.picker.lotterypicker.gameobjects.GameObject;
import idv.lottery.picker.lotterypicker.gameobjects.Scenes;
import idv.lottery.picker.lotterypicker.gameobjects.balls.MainBall;
import idv.lottery.picker.lotterypicker.graphic.Location;
import idv.lottery.picker.lotterypicker.stage.timer.ScriptSkd;
import idv.lottery.picker.lotterypicker.stage.timer.scripts.BallScript;

/**
 * Hello world!
 *
 */
public class App {
	final static String START = "start";
	public static Timer timer;
	public static ScriptSkd task = new ScriptSkd();

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

	public static void preparePickerAction(ScriptSkd task) {
		BallScript script = null;
		GameObject ball = null;

		for (int i = 1; i <= 49; i++) {
			ball = new MainBall(String.format("no.%d", i), i);
			ball.setLocation(new Location(0, 0));
			Scenes.createGameObjectInScene(ball);
			script = new BallScript();
			script.setThisGameObject(ball);
			task.addAction(script);
			script.spawn();
		}

	}

	@Test
	public void test1() {
		List aa = new ArrayList<>();
		aa.remove(new Object());
		System.out.println("ok");
	}

}
