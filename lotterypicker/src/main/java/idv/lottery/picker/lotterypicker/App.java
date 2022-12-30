package idv.lottery.picker.lotterypicker;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;

import org.junit.jupiter.api.Test;

import idv.lottery.picker.lotterypicker.gameobjects.GameObject;
import idv.lottery.picker.lotterypicker.gameobjects.Scene;
import idv.lottery.picker.lotterypicker.gameobjects.Scenes;
import idv.lottery.picker.lotterypicker.gameobjects.apparatuses.Outlet;
import idv.lottery.picker.lotterypicker.gameobjects.balls.MainBall;
import idv.lottery.picker.lotterypicker.gameobjects.publicgo.ControlGameObject;
import idv.lottery.picker.lotterypicker.graphic.Location;
import idv.lottery.picker.lotterypicker.stage.surfaces.Rectangle;
import idv.lottery.picker.lotterypicker.stage.surfaces.Shape;
import idv.lottery.picker.lotterypicker.stage.surfaces.Surface;
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
		run();
	}

	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
					App.init();
					App.resetScene();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
		GameObject outlet = new Outlet();
		Surface surface = new Surface();
		Shape shape = new Rectangle(new Location(-10, -10), 20);
		shape.setColor(Color.red);
		shape.setFilled(false);
		surface.setShape(shape);
		outlet.setSurface(surface);
		outlet.setLocation(new Location(50, 100));
		outlet.setName("OUTLET");
		createGameObjectInStage(task, null, outlet, true, null);

		GameObject ball = null;
		BallScript ballScript = null;

		for (int i = 1; i <= 49; i++) {
			ball = new MainBall(String.format("no.%d", i), i);
			ball.setLocation(new Location(0, 0));
			ballScript = new BallScript();
			BallScript.setOutlet(outlet);

			createGameObjectInStage(task, ballScript, ball, true, false);
		}

	}

	private static void createGameObjectInStage(ScriptSkd task,
			BaseScript script, GameObject go, boolean isBelongToScene,
			Boolean isSpawn) {
		if (script != null) {
			script.setThisGameObject(go);
			if (isSpawn) {
				script.spawn();
			}
			task.addScript(script);
		}
		if (isBelongToScene) {
			Scenes.createGameObjectInScene(go);
		}

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
