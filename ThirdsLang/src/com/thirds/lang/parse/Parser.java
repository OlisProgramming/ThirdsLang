package com.thirds.lang.parse;

import java.util.ArrayList;

import com.thirds.lang.parse.Statement.CPPDependency;
import com.thirds.lang.parse.Statement.StatementType;
import com.thirds.lang.token.Token;

public class Parser {

	public static ArrayList<Statement> parse(ArrayList<Token> tokens) {
		
		ArrayList<Statement> statements = new ArrayList<>();
		
		for (Token t : tokens) {
			switch (t.getType()) {
			case PRINT:
				statements.add(new Statement(StatementType.PRINT, tokens, CPPDependency.IOSTREAM));
				break;
			default:
				System.err.println("Unrecognised token type");
				new Exception().printStackTrace();
				System.exit(-1);
			}
		}
		
		return statements;
	}
}
