package idv.lottery.picker.lotterypicker.stage.timer;

public interface Script   {
	boolean isSpawned();
	void start();
	void update();
	void end();
	boolean isStarted();
	boolean isEnded();
	boolean isFinalEnded();
}
