package idv.lottery.picker.lotterypicker.stage.timer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TimerTask;

import org.junit.jupiter.api.Test;

import idv.lottery.picker.lotterypicker.stage.view.MainView;

public class ScriptSkd extends TimerTask {

	List<ActionWrap> wraps = new ArrayList<>();

	public static class ActionWrap {
		Script script;
		boolean isStarted;
		boolean isFinalEnded;

		public ActionWrap(Script script) {
			super();
			this.script = script;
		}

	}

	public ScriptSkd() {
		super();
	}

	public void addAction(Script script) {
		ActionWrap wrap = new ActionWrap(script);
		this.wraps.add(wrap);
	}

	@Override
	public void run() {

		if (!wraps.isEmpty()) {
			for (int i = 0; i < wraps.size(); i++) {
				ActionWrap wrap = wraps.get(i);

				if (wrap.script.isSpawned()) {
					if (!wrap.isStarted) {
						wrap.script.start();
						wrap.isStarted = true;
					}

					if (!wrap.script.isEnded()) {
						wrap.script.update();
					}

					if (wrap.script.isEnded() && !wrap.isFinalEnded) {
						wrap.script.end();
						wrap.isFinalEnded = true;
					}

					if (wrap.isFinalEnded) {
						this.wraps.remove(wrap);
					}
				}
			}
		}

		MainView.stage.repaint();

	}

	@Test
	public void test() {
		Script a1 = new BallScript();
		Script a2 = new BallScript();

		this.addAction(a1);
		this.addAction(a2);

		System.out.println("b " + this.wraps.size());

		System.out.println("f " + this.wraps.size());

	}

}
