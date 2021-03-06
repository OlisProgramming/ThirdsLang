package com.thirds.lang;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

import com.thirds.lang.compile.Compiler;

public class ThirdsLang {
	
	public static String MAIN_FILE_NAME = "main.thirds";

	public static void main(String[] args) throws IOException {
		
		Instant start = Instant.now();
		
		String content = IO.readFile(MAIN_FILE_NAME);
		String cppCode = Compiler.compile(content, MAIN_FILE_NAME);
		IO.writeFile("main.cpp", cppCode);
		
		Instant end = Instant.now();
		Duration timeElapsed = Duration.between(start, end);
		
		Messages.info("Compilation completed successfully in " + timeElapsed.toMillis() + "ms");
	}
}
