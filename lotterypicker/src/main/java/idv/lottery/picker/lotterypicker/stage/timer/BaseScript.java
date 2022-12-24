package idv.lottery.picker.lotterypicker.stage.timer;

public abstract class BaseScript implements Script {

	boolean isSpawned;
	boolean isEnded;
	boolean isFinalEnded;

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

}
