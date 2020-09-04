package javaassesment.multithreading;

import java.io.IOException;
import java.net.URISyntaxException;

public class Test {

	public static void main(String[] args) throws IOException, URISyntaxException {

		RemoveCapitals removeCapitals = new RemoveCapitals();
		removeCapitals.removeCapitalLettersFromFile("src/main/resources/testfiles");
	}
}