package javaassesment.multithreading;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RemoveCapitals {

	public void removeCapitalLettersFromFile(String path) throws URISyntaxException, IOException {

		ExecutorService executorService = Executors.newFixedThreadPool(5);

		File[] files = getFiles(path);
		for (File file : files) {
			executorService.submit(new App(file));
		}
		executorService.shutdown();
	}

	public File[] getFiles(String path) {
		File file = new File(path);
		return file.listFiles();

	}
}
