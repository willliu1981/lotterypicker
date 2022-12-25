package idv.lottery.picker.lotterypicker.stage.timer.scripts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

import idv.lottery.picker.lotterypicker.App;

public class GameControlScript extends BaseScript {

	DefaultListModel resultModel;
	JButton btnStart;
	boolean isStarted;
	boolean isActivated;

	@Override
	public void spawn() {
		super.spawn();

		btnStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!isActivated) {
					isStarted = true;
					btnStart.setText("RESTART");
				}else {
					btnStart.setText("START");
					restart();
				}
				

			}

		});

	}

	@Override
	public void update() {
		if (isStarted && !isActivated) {
			isActivated = true;
			List<BaseScript> find = App.findScript("BallScript");
			find.stream().forEach(x ->x.spawn());
		}

	}

	public void setModel(DefaultListModel model) {
		this.resultModel = model;
	}

	public void setStart(JButton start) {
		this.btnStart = start;
	}
	
	private void restart() {
		isStarted=false;
		isActivated=false;
		App.resetScene();
		
	}

}
