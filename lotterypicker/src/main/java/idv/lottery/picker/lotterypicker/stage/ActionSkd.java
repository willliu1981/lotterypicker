package idv.lottery.picker.lotterypicker.stage;

import java.util.TimerTask;

public class ActionSkd extends TimerTask {

	Action act;
	boolean isStarted;
	boolean isEnded;
	boolean isFinalEnded;

	public ActionSkd(Action act) {
		super();
		this.act = act;
	}

	@Override
	public void run() {
		if (act.isSpawned()) {

			if (!isStarted) {
				act.start();
				isStarted = true;
			}

			if (!act.isEnded()) {
				act.update();
			}

			if (act.isEnded() && !isFinalEnded) {
				act.end();
				isFinalEnded = true;
			}
		}
	}

}
