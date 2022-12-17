package idv.lottery.picker.lotterypicker.balls;

import java.awt.Color;
import java.awt.Point;

public class DefaultBall extends Ball {

	private DefaultBall(String name, Integer number) {
		super(name, number);
		this.coler = Color.white;
		this.direction = 0.0;
		this.location = new Point(0, 0);
	}

	public DefaultBall() {
		this("default ball", -1);
	}

}
