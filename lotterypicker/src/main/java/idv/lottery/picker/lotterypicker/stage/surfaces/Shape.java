package idv.lottery.picker.lotterypicker.stage.surfaces;

import java.awt.Color;

import idv.lottery.picker.lotterypicker.graphic.Location;

public class Shape {
	boolean isFilled;
	Location location;
	Color color;

	public Shape(Location location) {
		super();
		this.location = location;
	}

	public boolean isFilled() {
		return isFilled;
	}

	public void setFilled(boolean isFilled) {
		this.isFilled = isFilled;
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
