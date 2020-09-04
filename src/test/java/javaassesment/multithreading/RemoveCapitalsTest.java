package javaassesment.multithreading;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import javaassesment.multithreading.App;
import javaassesment.multithreading.RemoveCapitals;

/**
 * Unit test for simple App.
 */
public class RemoveCapitalsTest {

	private RemoveCapitals removeCapitals = new RemoveCapitals();

	@Test
	public void testApp() throws IOException, ExecutionException, InterruptedException {
		String folderPath = "src/test/resources";
		Path path = Paths.get(folderPath + "/Sample.txt");
		Files.write(path, "Test Data".getBytes());

		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future<Path> obj = executorService.submit(new App(new File(path.toUri())));
		obj.get();
		executorService.shutdown();
		String expectedOutput = "est ata";
		String fileContent = FileUtils.readFileToString(new File(path.toUri()), StandardCharsets.UTF_8);
		assertEquals(fileContent, expectedOutput);
	}

	@Test
	public void testGetFiles() {
		String folderPath = "src/test/resources";

		File[] files = removeCapitals.getFiles(folderPath);
		assertEquals(1, files.length);
	}
}
