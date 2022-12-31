package idv.lottery.picker.lotterypicker.gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import idv.lottery.picker.lotterypicker.graphic.Location;
import idv.lottery.picker.lotterypicker.stage.surfaces.Surface;
import idv.lottery.picker.lotterypicker.stage.timer.painters.Painter;
import idv.lottery.picker.lotterypicker.stage.timer.scripts.BaseScript;
import idv.lottery.picker.lotterypicker.tools.MyOptional;

public class GameObject {

	protected String name;
	protected Location location;
	protected Color coler;
	protected Double direction;
	protected MyOptional<List<GameObject>> optGameObjects = new MyOptional<>(
			Optional.empty());
	protected MyOptional<List<BaseScript>> optScropts = new MyOptional<>(
			Optional.empty());
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
		if (this instanceof Scene) {
			return Scene.mockScene;
		}

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

	private List<GameObject> getGameObjectList() {
		optGameObjects.ifPresentOrElse(null,
				() -> optGameObjects = new MyOptional<>(
						Optional.of(new ArrayList<>())));

		return optGameObjects.get();
	}

	public void addScript(BaseScript script) {
		this.getScriptList().add(script);
	}

	private List<BaseScript> getScriptList() {
		optScropts.ifPresentOrElse(null, () -> optScropts = new MyOptional<>(
				Optional.of(new ArrayList<>())));
		return optScropts.get();
	}

	public void paintForEach(Graphics g, Painter painter) {
		this.getGameObjectList().forEach(x -> painter.paint(g, x));
	}

	public void addGameObject(GameObject element) {
		this.getGameObjectList().add(element);
	}

	public void removeGameObject(GameObject element) {
		this.getGameObjectList().remove(element);
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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