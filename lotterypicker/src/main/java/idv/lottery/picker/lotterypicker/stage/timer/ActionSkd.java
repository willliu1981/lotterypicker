package idv.lottery.picker.lotterypicker.stage.timer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TimerTask;

import org.junit.jupiter.api.Test;

import idv.lottery.picker.lotterypicker.stage.view.MainView;

public class ActionSkd extends TimerTask {

	List<ActionWrap> wraps = new ArrayList<>();

	public static class ActionWrap {
		Action act;
		boolean isStarted;
		boolean isFinalEnded;

		public ActionWrap(Action act) {
			super();
			this.act = act;
		}

	}

	public ActionSkd() {
		super();
	}

	public void addAction(Action act) {
		ActionWrap wrap = new ActionWrap(act);
		this.wraps.add(wrap);
	}

	@Override
	public void run() {

		if (!wraps.isEmpty()) {
			for (int i = 0; i < wraps.size(); i++) {
				ActionWrap wrap = wraps.get(i);

				if (wrap.act.isSpawned()) {
					if (!wrap.isStarted) {
						wrap.act.start();
						wrap.isStarted = true;
					}

					if (!wrap.act.isEnded()) {
						wrap.act.update();
					}

					if (wrap.act.isEnded() && !wrap.isFinalEnded) {
						wrap.act.end();
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
		Action a1 = new BallAction();
		Action a2 = new BallAction();

		this.addAction(a1);
		this.addAction(a2);

		System.out.println("b " + this.wraps.size());

		System.out.println("f " + this.wraps.size());

	}

}
