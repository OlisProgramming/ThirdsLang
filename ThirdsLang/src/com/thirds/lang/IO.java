package com.thirds.lang;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IO {

	public static String readFile(String fname) {
		
		File in = new File(fname);
		Scanner scanner;
		try {
			scanner = new Scanner(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(-1);
			return null;
		}
		scanner.useDelimiter("\\Z");
		String content = scanner.next();
		scanner.close();
		return content;
	}
	
	public static void writeFile(String fname, String contents) {
		
		File out = new File(fname);
		PrintWriter outStream;
		try {
			out.createNewFile();
			outStream = new PrintWriter(out);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
			return;
		}
		outStream.println(contents);
		outStream.close();
	}
}
