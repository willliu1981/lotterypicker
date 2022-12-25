package idv.lottery.picker.lotterypicker.stage.timer.scripts;

import java.awt.Color;
import java.awt.Rectangle;

import idv.lottery.picker.lotterypicker.gameobjects.GameObject;
import idv.lottery.picker.lotterypicker.gameobjects.balls.DefaultBall;
import idv.lottery.picker.lotterypicker.graphic.Graphics;
import idv.lottery.picker.lotterypicker.graphic.Location;
import idv.lottery.picker.lotterypicker.graphic.Ray;
import idv.lottery.picker.lotterypicker.stage.view.MainView;

public class BallScript extends PickerScript {
	static Rectangle wallRect = new Rectangle(-200, -200, 400, 400);
	static Rectangle outletRect = new Rectangle(-20, -20, 40, 40);
	double velocity;
	int i;

	@Override
	public void spawn() {
		super.spawn();

		thisGameObject.setLocation(new Location(0, 0));
		thisGameObject.setDirection(Math.random() * 360);
		this.velocity = Math.random() * 10 + 2;
		thisGameObject.setColer(new Color((int) (Math.random() * Math.pow(2, 31))));

	}

	@Override
	public void update() {
		Location next = Graphics.nextLocation(thisGameObject.getLocation(), thisGameObject.getDirection(),
				this.velocity);
		Ray ray = new Ray(thisGameObject, this.velocity);
		GameObject result = new DefaultBall();
		boolean isCollided = Graphics.wallCollide(result, ray, wallRect);
		if (isCollided) {
			thisGameObject.setLocation(result.getLocation());
			thisGameObject.setDirection(result.getDirection());
		} else {
			thisGameObject.setLocation(next);
		}

		if (i > 200 && Graphics.outletCollide(ray, outletRect)) {
			this.destroy();
			MainView.add_Qualfiy_For_Next_Round(this.getThisGameObject().getName());
		}
		i++;

	}

}
