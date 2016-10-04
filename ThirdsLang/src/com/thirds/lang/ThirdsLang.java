package com.thirds.lang;

import java.io.IOException;
import com.thirds.lang.compile.Compiler;

public class ThirdsLang {
	
	public static String MAIN_FILE_NAME = "main.thirds";

	public static void main(String[] args) throws IOException {
		
		String content = IO.readFile(MAIN_FILE_NAME);
		String cppCode = Compiler.compile(content);
		IO.writeFile("main.cpp", cppCode);
		
		System.out.println("Compilation completed successfully!");
	}
}
