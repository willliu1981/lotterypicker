package idv.lottery.picker.lotterypicker.stage.timer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TimerTask;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import idv.lottery.picker.lotterypicker.stage.timer.scripts.BallScript;
import idv.lottery.picker.lotterypicker.stage.timer.scripts.BaseScript;
import idv.lottery.picker.lotterypicker.stage.timer.scripts.Script;
import idv.lottery.picker.lotterypicker.stage.view.MainView;

public class ScriptSkd extends TimerTask {

	List<ScriptWrap> wraps = new ArrayList<>();

	public static class ScriptWrap {
		BaseScript script;
		boolean isStarted;
		boolean isFinalEnded;

		public ScriptWrap(BaseScript script) {
			super();
			this.script = script;
		}

	}

	public ScriptSkd() {
		super();
	}

	public List<BaseScript> findScripts(String gameObjectName) {
		List<BaseScript> result = this.wraps.stream()
				.filter(w -> w.script.getClass().getSimpleName().equals(gameObjectName)).map(w2 -> w2.script)
				.collect(Collectors.toList());
		return result;
	}

	public void addScript(BaseScript script) {
		ScriptWrap wrap = new ScriptWrap(script);
		this.wraps.add(wrap);
	}

	@Override
	public void run() {

		if (!wraps.isEmpty()) {
			for (int i = 0; i < wraps.size(); i++) {
				ScriptWrap wrap = wraps.get(i);
				//// System.out.println("skd " + wrap.script+" : "+i);
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

		MainView.paneStage.repaint();

	}

	public void clearScript() {
		this.wraps.clear();
	}

	@Test
	public void test() {
		BaseScript a1 = new BallScript();
		BaseScript a2 = new BallScript();

		this.addScript(a1);
		this.addScript(a2);

		System.out.println("b " + this.wraps.size());

		System.out.println("f " + this.wraps.size());

	}

}
