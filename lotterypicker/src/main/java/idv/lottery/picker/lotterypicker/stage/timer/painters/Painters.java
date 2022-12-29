package idv.lottery.picker.lotterypicker.stage.timer.painters;

import java.awt.Graphics;

import idv.lottery.picker.lotterypicker.gameobjects.GameObject;
import idv.lottery.picker.lotterypicker.gameobjects.apparatuses.Outlet;
import idv.lottery.picker.lotterypicker.gameobjects.balls.MainBall;

public class Painters {

	public static void paint(Graphics g, GameObject go) {
		if (go instanceof MainBall) {
			BallPainter bp = new BallPainter();
			bp.paint(g, go);
		} else if (go instanceof Outlet) {
			ApparatusPainter ap=new ApparatusPainter();
			ap.paint(g, go);
		}

		go.paintForEach(g, (gfx, ele) -> {
			Painters.paint(gfx, ele);
		});
	}

}
