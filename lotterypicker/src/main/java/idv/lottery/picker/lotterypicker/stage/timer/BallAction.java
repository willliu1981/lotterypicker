package idv.lottery.picker.lotterypicker.stage.timer;

import java.awt.Color;
import java.awt.Rectangle;

import idv.lottery.picker.lotterypicker.gameobjects.GameObject;
import idv.lottery.picker.lotterypicker.gameobjects.balls.DefaultBall;
import idv.lottery.picker.lotterypicker.graphic.Graphics;
import idv.lottery.picker.lotterypicker.graphic.Location;
import idv.lottery.picker.lotterypicker.graphic.Ray;
import idv.lottery.picker.lotterypicker.stage.view.MainView;

public class BallAction extends PickerAction {
	static Rectangle wallRect = new Rectangle(-200, -200, 400, 400);
	static Rectangle outletRect = new Rectangle(-10, -10, 20, 20);
	GameObject ball;
	double velocity;
	int i;

	@Override
	public void spawn() {
		super.spawn();

		ball.setLocation(new Location(0, 0));
		ball.setDirection(Math.random() * 360);
		this.velocity = Math.random() * 10 + 2;
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

		if (i > 200 && Graphics.outletCollide(ray, outletRect)) {
			this.destroy();
			MainView.add_Qualfiy_For_Next_Round(this.getBall().getName());
		}
		i++;

	}

	public GameObject getBall() {
		return ball;
	}

	public void setBall(GameObject ball) {
		this.ball = ball;
	}

}