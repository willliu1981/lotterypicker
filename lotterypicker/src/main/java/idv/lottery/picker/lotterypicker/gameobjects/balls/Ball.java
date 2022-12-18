package idv.lottery.picker.lotterypicker.gameobjects.balls;

import idv.lottery.picker.lotterypicker.gameobjects.GameObject;

public abstract class Ball extends GameObject {
	Integer number;

	public Ball(String name, Integer number) {
		super();
		Name = name;
		this.number = number;
	}

	public Integer getNumber() {
		return number;
	}

}
