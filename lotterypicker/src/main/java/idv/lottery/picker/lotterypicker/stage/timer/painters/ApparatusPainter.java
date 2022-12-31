package idv.lottery.picker.lotterypicker.stage.timer.painters;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

import idv.lottery.picker.lotterypicker.gameobjects.GameObject;
import idv.lottery.picker.lotterypicker.stage.surfaces.Rectangle;
import idv.lottery.picker.lotterypicker.stage.surfaces.Shape;

public class ApparatusPainter implements Painter {

	@Override
	public void paint(Graphics g, GameObject go) {
		Shape shape = go.getSurface().getShape();
		g.setColor(shape.getColor());
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(4));

		if (shape instanceof Rectangle) {
			Rectangle rect = (Rectangle) shape;
			int x = (int) (go.getLocation().getX()
					+ shape.getLocation().getX());
			int y = (int) (go.getLocation().getY()
					+ shape.getLocation().getY());
			int w = (int) (rect.getHeight());
			int h = (int) (rect.getLength());
			g.drawRect(x * 2 + 400, y * 2 + 400, w * 2, h * 2);
		}

	}

}
