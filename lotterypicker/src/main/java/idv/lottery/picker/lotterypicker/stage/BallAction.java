package idv.lottery.picker.lotterypicker.stage;

import java.awt.Point;
import java.awt.Rectangle;

import idv.lottery.picker.lotterypicker.balls.Ball;
import idv.lottery.picker.lotterypicker.balls.DefaultBall;
import idv.lottery.picker.lotterypicker.graphic.Graphics;
import idv.lottery.picker.lotterypicker.graphic.Ray;

public class BallAction extends PickerAction {
	Rectangle wallRect = new Rectangle(200, 200);
	Ball ball;
	double velocity;

	@Override
	public void spawn() {
		super.spawn();

		ball.setLocation(new Point(0, 0));
		ball.setDirection(Math.random() * 360);
		this.velocity = Math.random() * 20 + 20;

	}

	@Override
	public void update() {
		Point next = Graphics.nextLocation(ball.getLocation(), ball.getDirection(), this.velocity);
		System.out.printf("after:ball=%s, p=%s, dir=%s\n", ball.getName(), ball.getLocation(), ball.getDirection());
		System.out.println("next=" + next);
		Ray ray = new Ray(ball, this.velocity);
		Ball result = new DefaultBall();
		boolean isCollided = Graphics.collide(result, ray, wallRect);
		if (isCollided) {
			System.out.println("flag!!!");
			ball.setLocation(result.getLocation());
			ball.setDirection(result.getDirection());
		} else {
			ball.setLocation(next);
		}

	}

	public Ball getBall() {
		return ball;
	}

	public void setBall(Ball ball) {
		this.ball = ball;
	}

}
