package com.thirds.lang.compile;

import java.util.ArrayList;

import com.thirds.lang.parse.Parser;
import com.thirds.lang.parse.Statement;
import com.thirds.lang.parse.Statement.CPPDependency;
import com.thirds.lang.token.Token;
import com.thirds.lang.token.Tokeniser;

public class Compiler {

	public static String TAB = "    ";  // Replace with '\t' if desired
	
	public static String compile(String content) {
		
		ArrayList<Token> tokens = Tokeniser.tokenise(content);
		ArrayList<Statement> statements = Parser.parse(tokens);
		ArrayList<CPPDependency> dependencies = new ArrayList<>();
		
		String output = "";
		
		for (Statement s : statements) {
			output += TAB + s.cppString() + "\n";
			for (CPPDependency dep : s.getDependencies())
				dependencies.add(dep);
		}
		
		String dependencyString = "";
		for (CPPDependency dep : dependencies)
			dependencyString += dep.cppString() + "\n";
		
		return dependencyString + "\nint main() {\n" + output + "}\n";
	}
}
