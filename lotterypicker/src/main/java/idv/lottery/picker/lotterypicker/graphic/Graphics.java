package idv.lottery.picker.lotterypicker.graphic;

import java.awt.Point;
import java.awt.Rectangle;

import idv.lottery.picker.lotterypicker.gameobjects.GameObject;

public class Graphics {
	/**
	 * 
	 * @param p0 原點
	 * @param d  方向
	 * @param v  速度
	 * @return 下一個目標位置
	 */

	static public Location nextLocation(Location p0, double d, double v) {
		double px1 = p0.getX() + v * Math.cos(Math.toRadians(d));
		double py1 = p0.getY() + v * Math.sin(Math.toRadians(d));

		Location p1 = new Location(px1, py1);
		return p1;
	}

	static public boolean wallCollide(GameObject result, Ray ray, Rectangle wall) {

		int i = 1;
		Location p = null;
		double currDirection = 0;
		double currMixDistance = 0;
		Location collidedPoint = null;
		double nextDst = getDistance(ray.p0, ray.p1);
		double cldDst = 0;
		boolean isCollided = false;
		while (i <= 4) {
			switch (i) {
			case 1:// wall top
				p = collidePoint(ray.p0, ray.p1, new Location(wall.width * -1, wall.height * -1),
						new Location(wall.width, wall.height * -1));
				if (p != null) {
					if (inQuadrant(ray.getDirection(), 4) || inQuadrant(ray.getDirection(), 1)) {
						cldDst = getDistance(ray.p0, p);
						if (cldDst < nextDst && (currMixDistance == 0 || cldDst <= currMixDistance)) {
							currMixDistance = cldDst;
							collidedPoint = p;
							currDirection = ray.getDirection() * -1;
							isCollided = true;
						}
					}
				}
				break;
			case 2:// wall right
				p = collidePoint(ray.p0, ray.p1, new Location(wall.width, wall.height * -1),
						new Location(wall.width, wall.height));
				if (p != null) {
					if (inQuadrant(ray.getDirection(), 1) || inQuadrant(ray.getDirection(), 2)) {
						cldDst = getDistance(ray.p0, p);
						if (cldDst < nextDst && (currMixDistance == 0 || cldDst <= currMixDistance)) {
							currMixDistance = cldDst;
							collidedPoint = p;
							currDirection = 180 - ray.getDirection();
							isCollided = true;
						}
					}
				}
				break;
			case 3:// wall bottom
				p = collidePoint(ray.p0, ray.p1, new Location(wall.width * -1, wall.height),
						new Location(wall.width, wall.height));
				if (p != null) {
					if (inQuadrant(ray.getDirection(), 2) || inQuadrant(ray.getDirection(), 3)) {
						cldDst = getDistance(ray.p0, p);
						if (cldDst < nextDst && (currMixDistance == 0 || cldDst <= currMixDistance)) {
							currMixDistance = cldDst;
							collidedPoint = p;
							currDirection = ray.getDirection() * -1;
							isCollided = true;
						}
					}
				}
				break;
			case 4:// wall left
				p = collidePoint(ray.p0, ray.p1, new Location(wall.width * -1, wall.height * -1),
						new Location(wall.width * -1, wall.height));
				if (p != null) {
					if (inQuadrant(ray.getDirection(), 3) || inQuadrant(ray.getDirection(), 4)) {
						cldDst = getDistance(ray.p0, p);
						//// System.out.printf("4)nextDst=%s, cldDst=%s\n", nextDst, cldDst);
						if (cldDst < nextDst && (currMixDistance == 0 || cldDst <= currMixDistance)) {
							currMixDistance = cldDst;
							collidedPoint = p;
							currDirection = 180 - ray.getDirection();
							isCollided = true;
						}
					}
				}
				break;

			}

			i++;
		}

		if (isCollided) {
			result.setLocation(collidedPoint);
			result.setDirection(currDirection);
			return true;
		} else {
			return false;
		}

	}

	static public Location collidePoint(Location p1, Location p2, Location p3, Location p4) {
		double A1 = p1.y - p2.y;
		double B1 = p2.x - p1.x;
		double C1 = A1 * p1.x + B1 * p1.y;

		double A2 = p3.y - p4.y;
		double B2 = p4.x - p3.x;
		double C2 = A2 * p3.x + B2 * p3.y;

		double det_k = A1 * B2 - A2 * B1;

		if (Math.abs(det_k) < 0.00001) {
			return null;
		}

		double a = B2 / det_k;
		double b = -1 * B1 / det_k;
		double c = -1 * A2 / det_k;
		double d = A1 / det_k;

		double x = a * C1 + b * C2;
		double y = c * C1 + d * C2;

		Location p = new Location(x,y);

		return p;
	}

	public static double getDistance(Location p0, Location p1) {
		double w = p0.getX() - p1.getX();
		double h = p0.getY() - p1.getY();
		return Math.pow(w * w + h * h, 0.5);
	}

	public static boolean inQuadrant(double d, int q) {
		if (d < 0) {
			d += 360;
		}

		switch (q) {
		case 1:
			if (d > 270 && d < 360) {
				return true;
			}
			break;
		case 2:
			if (d >= 0 && d <= 90) {
				return true;
			}
			break;
		case 3:
			if (d >= 90 && d <= 180) {
				return true;
			}
			break;
		case 4:
			if (d >= 180 && d <= 270) {
				return true;
			}
			break;
		}

		return false;
	}

}
