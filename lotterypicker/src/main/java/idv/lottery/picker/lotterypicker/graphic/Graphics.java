package idv.lottery.picker.lotterypicker.graphic;

import java.awt.Point;

public class Graphics {
	/**
	 * 
	 * @param p0 原點
	 * @param d  方向
	 * @param v  速度
	 * @return 下一個目標位置
	 */

	static public Point nextLocation(Point p0, double d, double v) {
		int px1 = (int) (p0.getX() + v * Math.cos(d));
		int py1 = (int) (p0.getY() + v * Math.sin(d));

		Point p1 = new Point(px1, py1);
		return p1;
	}
}
