package idv.lottery.picker.lotterypicker;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import idv.lottery.picker.lotterypicker.gameobjects.GameObject;

/**
 * Unit test for simple App.
 */
public class AppTest {
	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void shouldAnswerWithTrue() {
		assertTrue(true);
	}

	static Optional<List<GameObject>> optGameObjects = Optional.empty();

	public static void main(String s[]) {
		/*
		 * Optional<GameObject> opt = java.util.Optional.empty();
		 * 
		 * GameObject orElseGet = opt.orElseGet((opt =
		 * Optional.of(createNewGO()))::get); System.out.println(orElseGet.getName());
		 * System.out.println(opt.get().getName());
		 * 
		 * // opt.get().setName("go2"); opt.empty();
		 * 
		 * GameObject orElseGet2 = opt.orElseGet((opt =
		 * Optional.of(createNewGO()))::get); System.out.println(orElseGet2.getName());
		 */
		//System.out.println(optGameObjects.get());

		List<GameObject> goList = getGOList();
		GameObject g1 = new GameObject();
		g1.setName("g1");
		goList.add(g1);
		System.out.println(goList);
		
		List<GameObject> goList2 = getGOList();
		System.out.println(goList2);

	}

	private static List<GameObject> getGOList() {
		return optGameObjects.orElseGet((optGameObjects = Optional.of(new ArrayList<>()))::get);
	}

	public static GameObject createNewGO() {
		GameObject go = new GameObject();
		go.setName("go1");
		return go;
	}
}
