package idv.lottery.picker.lotterypicker.stage.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import idv.lottery.picker.lotterypicker.App;
import idv.lottery.picker.lotterypicker.gameobjects.Scene;
import idv.lottery.picker.lotterypicker.stage.timer.painters.Painters;

public class MainView extends JFrame {

	private JPanel contentPane;
	public static JPanel paneStage;

	static private JList list;
	static private DefaultListModel model = new DefaultListModel();
	static private JButton btnStart;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
					App.init();
					App.resetScene();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(2200, 10, 1000, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		paneStage = new JPanel() {

			@Override
			public void paint(Graphics g) {
				super.paint(g);
				Painters.paint(g, Scene.getScene());
			}

		};
		panel.add(paneStage, BorderLayout.CENTER);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.NORTH);

		btnStart = new JButton("START");

		btnStart.setFont(new Font("新細明體", Font.PLAIN, 18));
		panel_2.add(btnStart);

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new BorderLayout(0, 0));

		list = new JList(model);
		list.setFont(new Font("新細明體", Font.BOLD, 24));
		panel_1.add(list);

		JLabel lblNewLabel = new JLabel("order");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 28));
		panel_1.add(lblNewLabel, BorderLayout.NORTH);
	}

	public static void add_Qualfiy_For_Next_Round(String ballName) {
		model.addElement(ballName);

	}

	public static DefaultListModel getModel() {
		return model;
	}

	public static JButton getBtnStart() {
		return btnStart;
	}

}
