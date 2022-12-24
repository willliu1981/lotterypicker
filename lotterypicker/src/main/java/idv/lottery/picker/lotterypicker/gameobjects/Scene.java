package idv.lottery.picker.lotterypicker.gameobjects;

public class Scene extends GameObject {
	private static Scene scene = new Scene();

	private Scene() {
		this.setName("SCENE");
	}

	public static Scene getScene() {
		return scene;
	}

	public static void reset() {
		scene = new Scene();
	};

}
