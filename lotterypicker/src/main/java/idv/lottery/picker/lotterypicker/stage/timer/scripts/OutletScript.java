package idv.lottery.picker.lotterypicker.stage.timer.scripts;

import idv.lottery.picker.lotterypicker.graphic.Graphics;
import idv.lottery.picker.lotterypicker.graphic.Location;

public class OutletScript extends PickerScript {

	double circlePoint;

	Location po = new Location();

	@Override
	public void spawn() {
		super.spawn();

	}

	@Override
	public void update() {
		Location next = Graphics.nextLocation(po, circlePoint, 100);

		this.getThisGameObject().getLocation().setX(next.getX());
		this.getThisGameObject().getLocation().setY(next.getY());

		if (circlePoint > 360) {
			circlePoint = 0;
		}
		circlePoint += 1;
	}

}
