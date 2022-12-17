package idv.lottery.picker.lotterypicker.balls;

import java.awt.Color;
import java.awt.Point;

public abstract class Ball {
	String Name;
	Integer number;
	Point location;
	Color coler;

	public Ball(String name, Integer number) {
		super();
		Name = name;
		this.number = number;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public String getName() {
		return Name;
	}

	public Integer getNumber() {
		return number;
	}

	public Color getColer() {
		return coler;
	}

	public void setColer(Color coler) {
		this.coler = coler;
	}

}
