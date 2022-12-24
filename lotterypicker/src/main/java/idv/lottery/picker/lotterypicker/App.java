package idv.lottery.picker.lotterypicker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;

import org.junit.jupiter.api.Test;

import idv.lottery.picker.lotterypicker.gameobjects.GameObject;
import idv.lottery.picker.lotterypicker.gameobjects.Scene;
import idv.lottery.picker.lotterypicker.gameobjects.Scenes;
import idv.lottery.picker.lotterypicker.gameobjects.balls.MainBall;
import idv.lottery.picker.lotterypicker.gameobjects.publicgo.ControlGameObject;
import idv.lottery.picker.lotterypicker.graphic.Location;
import idv.lottery.picker.lotterypicker.stage.timer.ScriptSkd;
import idv.lottery.picker.lotterypicker.stage.timer.scripts.BallScript;
import idv.lottery.picker.lotterypicker.stage.timer.scripts.BaseScript;
import idv.lottery.picker.lotterypicker.stage.timer.scripts.GameControlScript;
import idv.lottery.picker.lotterypicker.stage.view.MainView;

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
		controlScript.setModel(MainView.getModel());
		controlScript.setStart(MainView.getBtnStart());

		createGameObjectInStage(task, controlScript, controlGO, true, true);
	}

	public static void preparePickerSctipt(ScriptSkd task) {
		GameObject ball = null;
		BallScript script = null;

		for (int i = 1; i <= 49; i++) {
			ball = new MainBall(String.format("no.%d", i), i);
			ball.setLocation(new Location(0, 0));
			script = new BallScript();

			createGameObjectInStage(task, script, ball, true, false);
		}

	}

	private static void createGameObjectInStage(ScriptSkd task, BaseScript script, GameObject go,
			boolean isBelongToScene, boolean isSpawn) {
		script.setThisGameObject(go);
		if (isBelongToScene) {
			Scenes.createGameObjectInScene(go);
		}
		if (isSpawn) {
			script.spawn();
		}
		task.addScript(script);

	}

	static public List<BaseScript> findScript(String gameObjectName) {
		return task.findScripts(gameObjectName);
	}

	public static void resetScene() {
		task.clearScript();
		MainView.getBtnStart().setText("START");
		Arrays.stream(MainView.getBtnStart().getActionListeners())
				.forEach(x -> MainView.getBtnStart().removeActionListener(x));
		MainView.getModel().clear();

		Scene.reset();
		App.preparePickerSctipt(App.task);
		App.preparePublicSctipt(App.task);

	}

	@Test
	public void test1() {
		List aa = new ArrayList<>();
		aa.remove(new Object());
		System.out.println("ok");
	}

}
