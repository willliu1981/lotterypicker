package idv.lottery.picker.lotterypicker.stage;

public interface Action   {
	boolean isSpawned();
	void start();
	void update();
	void end();
	boolean isEnded();
}