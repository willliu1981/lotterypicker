package idv.lottery.picker.lotterypicker.stage;

public abstract class BaseAction implements Action {
	
	boolean isSpawned;
	boolean isEnded;

	public void spawn() {
		this.isSpawned=true;
	}
	
	public void destroy() {
		this.isEnded=true;
	}
	
	@Override
	public boolean isSpawned() {
		return this.isSpawned;
	}

	@Override
	public void end() {
		
	}

	@Override
	public boolean isEnded() {
		return this.isEnded;
	}

}
