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
	static Rectangle wallCollisionRect = new Rectangle(-200, -200, 400, 400);
	static GameObject outlet;
	double velocity;
	int i;

	@Override
	public void spawn() {
		super.spawn();

		thisGameObject.setLocation(new Location(0, 0));
		thisGameObject.setDirection(Math.random() * 360);
		this.velocity = Math.random() * 20 + 4;
		thisGameObject
				.setColer(new Color((int) (Math.random() * Math.pow(2, 31))));

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

		Rectangle outletCollisionRect = getOutletRect();
		if (i > 200 && Graphics.outletCollide(ray, outletCollisionRect)) {
			this.destroy();
			MainView.add_Qualfiy_For_Next_Round(
					this.getThisGameObject().getName());
		}
		i++;

	}

	public static void setOutlet(GameObject outlet) {
		BallScript.outlet = outlet;
	}

	private Rectangle getOutletRect() {
		Rectangle outletCollisionRect = new Rectangle();
		Location outletLocation = outlet.getLocation();
		Location outletSurfaceLocation = outlet.getSurface().getShape()
				.getLocation();
		double length = outlet.getSurface().getShape().getLength();
		outletCollisionRect.x = (int) (outletLocation.getX()
				+ outletSurfaceLocation.getX());
		outletCollisionRect.y = (int) (outletLocation.getY()
				+ outletSurfaceLocation.getY());
		outletCollisionRect.width = (int) length;
		outletCollisionRect.height = (int) length;
		return outletCollisionRect;
	}

}
