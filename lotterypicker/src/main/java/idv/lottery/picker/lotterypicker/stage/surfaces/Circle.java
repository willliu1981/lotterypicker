package idv.lottery.picker.lotterypicker.stage.surfaces;

import idv.lottery.picker.lotterypicker.graphic.Location;

public class Circle extends Shape {
	double height;

	public Circle(Location location, double length) {
		super(location, length);
	}

	public double getHeight() {
		return this.height == 0 ? this.length : height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

}
