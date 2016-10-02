package com.thirds.lang.compile;

import java.util.ArrayList;

import com.thirds.lang.parse.Parser;
import com.thirds.lang.parse.Statement;
import com.thirds.lang.token.Token;
import com.thirds.lang.token.Tokeniser;

public class Compiler {

	public static String TAB = "    ";  // Replace with '\t' if desired
	
	public static String compile(String content) {
		
		ArrayList<Token> tokens = Tokeniser.tokenise(content);
		ArrayList<Statement> statements = Parser.parse(tokens);
		
		String output = "";
		
		for (Statement s : statements) {
			output += TAB + s.cppString() + "\n";
		}
		
		return "#include <iostream>\n\nint main() {\n" + output + "}\n";
	}
}
