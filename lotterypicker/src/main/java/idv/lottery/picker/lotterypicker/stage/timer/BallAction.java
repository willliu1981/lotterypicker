package idv.lottery.picker.lotterypicker.stage.timer;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import idv.lottery.picker.lotterypicker.gameobjects.GameObject;
import idv.lottery.picker.lotterypicker.gameobjects.balls.DefaultBall;
import idv.lottery.picker.lotterypicker.graphic.Graphics;
import idv.lottery.picker.lotterypicker.graphic.Location;
import idv.lottery.picker.lotterypicker.graphic.Ray;

public class BallAction extends PickerAction {
	Rectangle wallRect = new Rectangle(200, 200);
	GameObject ball;
	double velocity;

	@Override
	public void spawn() {
		super.spawn();

		ball.setLocation(new Location(0, 0));
		ball.setDirection(Math.random() * 360);
		this.velocity = Math.random() * 2 + 1;
		ball.setColer(new Color((int) (Math.random() * Math.pow(2, 31))));

	}

	@Override
	public void update() {
		Location next = Graphics.nextLocation(ball.getLocation(), ball.getDirection(), this.velocity);
		Ray ray = new Ray(ball, this.velocity);
		GameObject result = new DefaultBall();
		boolean isCollided = Graphics.wallCollide(result, ray, wallRect);
		if (isCollided) {
			ball.setLocation(result.getLocation());
			ball.setDirection(result.getDirection());
		} else {
			ball.setLocation(next);
		}

	}

	public GameObject getBall() {
		return ball;
	}

	public void setBall(GameObject ball) {
		this.ball = ball;
	}

}
