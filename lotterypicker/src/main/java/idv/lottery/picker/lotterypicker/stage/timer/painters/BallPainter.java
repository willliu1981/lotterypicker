package idv.lottery.picker.lotterypicker.stage.timer.painters;

import java.awt.Graphics;

import idv.lottery.picker.lotterypicker.gameobjects.GameObject;

public class BallPainter implements Painter {

	@Override
	public void paint(Graphics g, GameObject go) {
		g.setColor(go.getColer());
		g.fillOval((int) (go.getLocation().getX() * 2 + 400), (int) (go.getLocation().getY() * 2 + 400), 10, 10);
	}

}
