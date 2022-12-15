package idv.lottery.picker.lotterypicker;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	final static String START="start";
	
	public static void main(String[] args) {
		System.out.println("Welcome to Lottery World");
		System.out.printf("Please input %s\n",START);

		Scanner sc = new Scanner(System.in);
		String input = null;

		while (sc.hasNextLine()) {
			input = sc.nextLine();
			if(input.equalsIgnoreCase(START)) {
				System.out.println("Show time");
			}else {
				System.out.println("Nothing happen");
			}
			
		}
	}

	static void init() {

	}
}
