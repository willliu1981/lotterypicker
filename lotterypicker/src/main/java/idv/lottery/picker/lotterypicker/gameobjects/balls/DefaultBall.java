package idv.lottery.picker.lotterypicker.gameobjects.balls;

import java.awt.Color;

import idv.lottery.picker.lotterypicker.graphic.Location;

public class DefaultBall extends Ball {

	private DefaultBall(String name, Integer number) {
		super(name, number);
		this.coler = Color.white;
		this.direction = 0.0;
		this.location = new Location(0, 0);
	}

	public DefaultBall() {
		this("default ball", -1);
	}

}
