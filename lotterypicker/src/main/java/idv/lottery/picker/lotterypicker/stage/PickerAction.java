package idv.lottery.picker.lotterypicker.stage;

import idv.lottery.picker.lotterypicker.balls.Ball;

public class PickerAction extends BaseAction {

	Ball ball;

	public Ball getBall() {
		return ball;
	}

	public void setBall(Ball ball) {
		this.ball = ball;
	}

	@Override
	public void update() {
		System.out.println("no=" + ball.getName());
		this.destroy();
	}

}
