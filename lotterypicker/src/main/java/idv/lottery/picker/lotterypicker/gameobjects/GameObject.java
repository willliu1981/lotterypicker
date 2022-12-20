package idv.lottery.picker.lotterypicker.gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import idv.lottery.picker.lotterypicker.stage.timer.Painter;

public class GameObject {

	protected String Name;
	protected Point location;
	protected Color coler;
	protected Double direction;
	protected List<GameObject> gameObjects;
	protected GameObject parentGO;

	public GameObject() {
		super();
		if (!(this instanceof Scene)) {
			this.parentGO = Scene.getScene();
			this.attach(Scene.getScene());
		}
	}

	public void attach(GameObject newParent) {
		////System.out.println("type=" + this.getClass().getName());
		this.parentGO.removeGameObject(this);
		newParent.addGameObject(this);
		this.parentGO = newParent;
		////System.out.println("?1=" + this.parentGO.getGOList().size());
		////System.out.println("?2=" + this.parentGO.getClass().getName());
	}

	private List<GameObject> getGOList() {
		if (this.gameObjects == null) {
			return this.gameObjects= new ArrayList<>();
		}
		return this.gameObjects;
	}

	public void paintForEach(Graphics g, Painter painter) {
		////System.out.printf("name1=%s, ?=%d\n ", this.getName(), this.getGOList().size());
		this.getGOList().forEach(
				x -> System.out.printf("name(foreach)=%s, list size=%d\n ", x.getName(), this.getGOList().size()));
		this.getGOList().forEach(x -> painter.paint(g, x));
	}

	public void addGameObject(GameObject element) {
		this.getGOList().add(element);
		System.out.println("?3=" + this.getClass().getName());
		System.out.println("?3 size=" + this.getGOList().size());
	}

	public void removeGameObject(GameObject element) {
		this.getGOList().remove(element);
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Color getColer() {
		return coler;
	}

	public void setColer(Color coler) {
		this.coler = coler;
	}

	public Double getDirection() {
		return direction;
	}

	public void setDirection(Double direction) {
		this.direction = direction;
	}

}