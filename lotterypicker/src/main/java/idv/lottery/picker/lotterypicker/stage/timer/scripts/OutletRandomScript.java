package idv.lottery.picker.lotterypicker.stage.timer.scripts;

import java.awt.Rectangle;

import idv.lottery.picker.lotterypicker.gameobjects.GameObject;
import idv.lottery.picker.lotterypicker.gameobjects.balls.DefaultBall;
import idv.lottery.picker.lotterypicker.graphic.Graphics;
import idv.lottery.picker.lotterypicker.graphic.Location;
import idv.lottery.picker.lotterypicker.graphic.Ray;

public class OutletRandomScript extends PickerScript {
	static Rectangle wallCollisionRect = new Rectangle(-200, -200, 400, 400);
	double velocity;

	Location po = new Location();

	@Override
	public void spawn() {
		super.spawn();
		thisGameObject.setLocation(new Location(0, 0));
		thisGameObject.setDirection(Math.random() * 360);
		this.velocity = Math.random() * 2 + 1;
	}

	@Override
	public void update() {
		Location next = Graphics.nextLocation(thisGameObject.getLocation(),
				thisGameObject.getDirection(), this.velocity);

		Ray ray = new Ray(thisGameObject, this.velocity);
		GameObject result = new DefaultBall();
		boolean isCollided = Graphics.wallCollide(result, ray,
				wallCollisionRect);
		if (isCollided) {
			thisGameObject.setLocation(result.getLocation());
			thisGameObject.setDirection(result.getDirection());
		} else {
			thisGameObject.setLocation(next);
		}
	}

}
