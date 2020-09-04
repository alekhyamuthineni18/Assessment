package javaassesment.multithreading;

import java.io.BufferedWriter;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.concurrent.Callable;

import org.apache.commons.io.FileUtils;

public class App implements Callable {
	File file;

	App(File file) {
		this.file = file;
	}

	@Override
	public Object call() throws Exception {

		String fileContent = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
		String r = fileContent.replaceAll("([A-Z])", "");

		try (BufferedWriter writer = Files.newBufferedWriter(file.toPath())) {
			writer.write(r);
		}
		return file.toPath();
	}
}
