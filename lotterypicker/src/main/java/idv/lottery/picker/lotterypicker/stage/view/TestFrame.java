package idv.lottery.picker.lotterypicker.stage.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TestFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFrame frame = new TestFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panel = new JPanel() {

			@Override
			public void paint(Graphics g) {
				super.paint(g);
				Graphics2D g2D = (Graphics2D) g;
				File file = new File("c:/test/pics/googlelogo.png");
				try {
					final BufferedImage bi = ImageIO.read(file);
					Polygon pg = new Polygon();
					Rectangle rect = new Rectangle(100, 100, 300, 300);
					java.awt.geom.Ellipse2D.Double double1 = new Ellipse2D.Double(100, 100, 150, 250);
					TexturePaint tp = new TexturePaint(bi, rect);

					g2D.rotate(Math.toRadians(60), 222 / 2, 222 / 2);
					g2D.translate((111) / 2, (111) / 2);
					g2D.setPaint(tp);
					pg.addPoint(100, 100);
					pg.addPoint(200, 50);
					pg.addPoint(300, 180);
					pg.addPoint(200, 222);
					pg.addPoint(66, 155);
					//g2D.shear(0.7, 0);
					g2D.fill(pg);
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		};

		contentPane.add(panel);
	}

}
