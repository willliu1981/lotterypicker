package idv.lottery.picker.lotterypicker.stage.timer;

import java.awt.Graphics;

import idv.lottery.picker.lotterypicker.gameobjects.GameObject;
import idv.lottery.picker.lotterypicker.gameobjects.balls.MainBall;

public class Painters {

	public static void paint(Graphics g, GameObject go) {

		////System.out.println("instanceof " + go.getName());
		if (go instanceof MainBall) {
			BallPainter bp = new BallPainter();
			bp.paint(g, go);
		}

		go.paintForEach(g, (gfx, ele) -> {
			Painters.paint(gfx, ele);
		});
	}

}
