package idv.lottery.picker.lotterypicker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import idv.lottery.picker.lotterypicker.gameobjects.GameObject;
import idv.lottery.picker.lotterypicker.tools.MyOptional;

/**
 * Unit test for simple App.
 */
public class AppTest {

	static Optional<List<GameObject>> optGameObjects = Optional.empty();

	public static void main(String s[]) {

		List<GameObject> goList = getGOList();
		GameObject g1 = new GameObject();
		g1.setName("G1");
		goList.add(g1);
		System.out.println(goList.get(0).getName());

		List<GameObject> goList2 = getGOList();
		System.out.println(goList2.get(0).getName());

		List<GameObject> goList3 = Collections.emptyList();
		//goList3.add(g1);
		//ameObject gameObject = goList3.get(0);
		System.out.println(goList3 == null);

		Optional<List<GameObject>> golst = Optional.empty();
		List<GameObject> orElseGet = golst.orElseGet(ArrayList::new);
		System.out.println(orElseGet.hashCode());

	}

	private static List<GameObject> getGOList() {

		optGameObjects.orElse(getGOList());

		return optGameObjects.orElseGet(
				(optGameObjects = Optional.of(new ArrayList<>()))::get);
	}

	@Test
	public void test() {
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "apple");
		map.put(2, "banana");
		map.put(3, "kiwi");

		List<String> list = map.values().stream().collect(Collectors.toList());

		list.forEach(System.out::println);

	}
	
	@Test
	public void test2() {
		Consumer<String> stringConsumer = (s) -> System.out
				.println("The value stored in Optional object - " + s);
		Runnable runnable = () -> System.out
				.println("No value stored in the Optional object");

		String test = "hello-educative";
		Optional<String> stringOptional = Optional.of(test);

		MyOptional<String> myOptional = new MyOptional<String>(stringOptional);

		System.out.println("When a value is present - ");
		myOptional.ifPresentOrElse(stringConsumer, runnable);

		System.out.println("----------");
		test = null;

		System.out.println("When no value is present - ");

		stringOptional = Optional.of(test);
		myOptional = new MyOptional<String>(stringOptional);
		myOptional.ifPresentOrElse(stringConsumer, runnable);
	}

}
