package idv.lottery.picker.lotterypicker.stage.timer.scripts;

import idv.lottery.picker.lotterypicker.gameobjects.GameObject;

public interface Script   {
	boolean isSpawned();
	void start();
	void update();
	void end();
	boolean isStarted();
	boolean isEnded();
	boolean isFinalEnded();
	void setThisGameObject(GameObject go);
	GameObject getThisGameObject();
}
