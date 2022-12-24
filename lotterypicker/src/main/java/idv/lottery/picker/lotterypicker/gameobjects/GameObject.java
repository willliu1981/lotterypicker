package idv.lottery.picker.lotterypicker.gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import idv.lottery.picker.lotterypicker.graphic.Location;
import idv.lottery.picker.lotterypicker.stage.surfaces.Surface;
import idv.lottery.picker.lotterypicker.stage.timer.painters.Painter;

public class GameObject {

	protected String Name;
	protected Location location;
	protected Color coler;
	protected Double direction;
	protected List<GameObject> gameObjects;
	protected GameObject parentGO;
	protected Surface surface;

	public GameObject() {
		super();
	}

	public GameObject(GameObject parentGO) {
		super();

		this.parentGO = parentGO;
	}

	private GameObject getParentGO() {
		if (this.parentGO == null) {
			this.parentGO = Scene.getScene();
			this.attachTo(Scene.getScene());
		}
		return this.parentGO;
	}

	public void attachTo(GameObject newParent) {
		if (!(this instanceof Scene)) {
			this.getParentGO().removeGameObject(this);
			newParent.addGameObject(this);
			this.parentGO = newParent;
		}
	}

	private List<GameObject> getGOList() {
		if (this.gameObjects == null) {
			return this.gameObjects = new ArrayList<>();
		}
		return this.gameObjects;
	}

	public void paintForEach(Graphics g, Painter painter) {
		this.getGOList().forEach(x -> painter.paint(g, x));
	}

	public void addGameObject(GameObject element) {
		this.getGOList().add(element);
	}

	public void removeGameObject(GameObject element) {
		this.getGOList().remove(element);
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
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

	public Surface getSurface() {
		return surface;
	}

	public void setSurface(Surface surface) {
		this.surface = surface;
	}

}