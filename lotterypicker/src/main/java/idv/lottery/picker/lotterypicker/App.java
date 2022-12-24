package idv.lottery.picker.lotterypicker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;

import org.junit.jupiter.api.Test;

import idv.lottery.picker.lotterypicker.gameobjects.GameObject;
import idv.lottery.picker.lotterypicker.gameobjects.Scenes;
import idv.lottery.picker.lotterypicker.gameobjects.balls.MainBall;
import idv.lottery.picker.lotterypicker.gameobjects.publicgo.ControlGameObject;
import idv.lottery.picker.lotterypicker.graphic.Location;
import idv.lottery.picker.lotterypicker.stage.timer.ScriptSkd;
import idv.lottery.picker.lotterypicker.stage.timer.scripts.BallScript;
import idv.lottery.picker.lotterypicker.stage.timer.scripts.BaseScript;
import idv.lottery.picker.lotterypicker.stage.timer.scripts.GameControlScript;

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

				preparePickerSctipt(task);
			} else {
				System.out.println("Nothing happen");
			}

		}
	}

	public static void init() {
		timer = new Timer();
		timer.schedule(task, 1000, 10);
	}

	public static void preparePublicSctipt(ScriptSkd task) {
		GameObject controlGO = new ControlGameObject();
		GameControlScript controlScript = new GameControlScript();

		createGameObjectInStage(task, controlScript, controlGO, true, true);
	}

	public static void preparePickerSctipt(ScriptSkd task) {
		GameObject ball = null;
		BallScript script = null;

		for (int i = 1; i <= 49; i++) {
			ball = new MainBall(String.format("no.%d", i), i);
			ball.setLocation(new Location(0, 0));
			script = new BallScript();

			createGameObjectInStage(task, script, ball, true, true);
		}

	}

	private static void createGameObjectInStage(ScriptSkd task, BaseScript script, GameObject go, boolean isBelongToScene,
			boolean isSpawn) {
		script.setThisGameObject(go);
		if (isBelongToScene) {
			Scenes.createGameObjectInScene(go);
		}
		if (isSpawn) {
			script.spawn();
		}
		task.addScript(script);

	}

	@Test
	public void test1() {
		List aa = new ArrayList<>();
		aa.remove(new Object());
		System.out.println("ok");
	}

}
