package idv.lottery.picker.lotterypicker.stage.surfaces;

import java.awt.Color;

import idv.lottery.picker.lotterypicker.graphic.Location;

public abstract class Shape {
	boolean isFilled;
	Location location;
	double length;
	Color color;

	public Shape(Location location, double length) {
		super();
		this.location = location;
		this.length = length;
	}

	public boolean isFilled() {
		return isFilled;
	}

	public void setFilled(boolean isFilled) {
		this.isFilled = isFilled;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Color getColor() {
		if (this.color == null) {
			this.color = Color.black;
		}
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
