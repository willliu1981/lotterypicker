package idv.lottery.picker.lotterypicker.stage.timer;

import java.awt.Graphics;

import idv.lottery.picker.lotterypicker.gameobjects.GameObject;

public class BallPainter implements Painter {

	@Override
	public void paint(Graphics g, GameObject go) {
		g.drawOval(go.getLocation().x * 2 + 400, go.getLocation().y * 2 + 400, 10, 10);
	}

}
