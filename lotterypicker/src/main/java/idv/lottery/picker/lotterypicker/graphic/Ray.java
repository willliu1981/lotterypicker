package idv.lottery.picker.lotterypicker.graphic;

import java.awt.Point;

import idv.lottery.picker.lotterypicker.gameobjects.GameObject;

public class Ray {
	Point p0;
	Point p1;
	Double direction;

	public Ray(GameObject ball, double length) {
		this.p0 = ball.getLocation();
		this.p1 = Graphics.nextLocation(p0, ball.getDirection(), length);
		this.direction = ball.getDirection();
	}

	public Point getP0() {
		return p0;
	}

	public Point getP1() {
		return p1;
	}

	public Double getDirection() {
		return direction;
	}

}
