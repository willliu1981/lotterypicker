package idv.lottery.picker.lotterypicker.stage.timer.painters;

import java.awt.Graphics;

import idv.lottery.picker.lotterypicker.gameobjects.GameObject;
import idv.lottery.picker.lotterypicker.stage.surfaces.Rectangle;
import idv.lottery.picker.lotterypicker.stage.surfaces.Shape;

public class ApparatusPainter implements Painter {

	@Override
	public void paint(Graphics g, GameObject go) {
		Shape shape = go.getSurface().getShape();
		g.setColor(shape.getColor());

		if (shape instanceof Rectangle) {
			Rectangle rect = (Rectangle) shape;
			int x = (int) (go.getLocation().getX()
					+ shape.getLocation().getX());
			int y = (int) (go.getLocation().getY()
					+ shape.getLocation().getY());
			int w = (int) (rect.getHeight());
			int h = (int) (rect.getLength());
			System.out.printf("ap name=%s, x=%d, y=%d, w=%d, h=%d\n",
					go.getName(), x, y, w, h);
			g.drawRect(x + 400, y + 400, w, h);
		}

	}

}
