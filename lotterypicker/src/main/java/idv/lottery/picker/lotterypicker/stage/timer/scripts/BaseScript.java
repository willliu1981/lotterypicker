package idv.lottery.picker.lotterypicker.stage.timer.scripts;

import idv.lottery.picker.lotterypicker.gameobjects.GameObject;

public abstract class BaseScript implements Script {

	boolean isSpawned;
	boolean isEnded;
	boolean isFinalEnded;
	GameObject thisGameObject;

	public void spawn() {
		this.isSpawned = true;
	}

	@Override
	public void start() {
	}

	public void destroy() {
		this.isEnded = true;
	}

	@Override
	public boolean isSpawned() {
		return this.isSpawned;
	}

	@Override
	public void end() {

	}

	@Override
	public boolean isStarted() {
		return false;
	}

	@Override
	public boolean isEnded() {
		return this.isEnded;
	}

	@Override
	public boolean isFinalEnded() {
		return false;
	}

	@Override
	public void setThisGameObject(GameObject target) {
		this.thisGameObject = target;
	}

	public GameObject getThisGameObject() {
		return thisGameObject;
	}

}
