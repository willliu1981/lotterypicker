package idv.lottery.picker.lotterypicker.stage;

import idv.lottery.picker.lotterypicker.balls.Ball;
import idv.lottery.picker.lotterypicker.graphic.Graphics;

public class BallAction extends PickerAction {
	Ball ball;
	double direction;
	double velocity;

	@Override
	public void spawn() {
		super.spawn();

		this.direction = Math.random() * 360;
		this.velocity = Math.random() * 100;

	}

	@Override
	public void update() {
		ball.setLocation(Graphics.nextLocation(ball.getLocation(), direction, velocity));
		System.out.printf("ball=%s, p=%s\n", ball.getName(), ball.getLocation());
	}

	public Ball getBall() {
		return ball;
	}

	public void setBall(Ball ball) {
		this.ball = ball;
	}

	public double getDirection() {
		return direction;
	}

	public void setDirection(double direction) {
		this.direction = direction;
	}

	public double getVelocity() {
		return velocity;
	}

	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

}
