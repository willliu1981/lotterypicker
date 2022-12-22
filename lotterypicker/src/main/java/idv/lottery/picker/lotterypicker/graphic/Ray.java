package idv.lottery.picker.lotterypicker.graphic;

import idv.lottery.picker.lotterypicker.gameobjects.GameObject;

public class Ray {
	Location p0;
	Location p1;
	Double direction;

	public Ray(GameObject ball, double length) {
		this.p0 = ball.getLocation();
		this.p1 = Graphics.nextLocation(p0, ball.getDirection(), length);
		this.direction = ball.getDirection();
	}

	public Location getP0() {
		return p0;
	}

	public Location getP1() {
		return p1;
	}

	public Double getDirection() {
		return direction;
	}

	@Override
	public String toString() {
		return "Ray [p0=" + p0 + ", p1=" + p1 + ", direction=" + direction + "]";
	}

}
