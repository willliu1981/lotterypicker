package idv.lottery.picker.lotterypicker.stage;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class ActionSkd extends TimerTask {

	List<Action> actions = new ArrayList<>();
	boolean isStarted;
	boolean isEnded;
	boolean isFinalEnded;

	public ActionSkd() {
		super();
	}

	public void addAction(Action act) {
		this.actions.add(act);
	}

	@Override
	public void run() {

		Action act = null;
		if (!actions.isEmpty()) {
			for (int i = 0; i < actions.size(); i++) {
				act = actions.get(i);

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

	}

}
