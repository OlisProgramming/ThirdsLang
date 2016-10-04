package com.thirds.lang.parse;

import java.util.ArrayList;

import com.thirds.lang.token.Token;
import com.thirds.lang.token.Token.TokenType;

public class Parser {

	public static ArrayList<Statement> parse(ArrayList<Token> tokens) {
		
		ArrayList<Statement> statements = new ArrayList<>();
		
		ArrayList<Token> currentTokens = new ArrayList<>();
		
		for (Token t : tokens) {
			currentTokens.add(t);
			
			if (t.getType() == TokenType.SEMICOLON) {
				statements.add(new Statement(currentTokens));
				currentTokens = new ArrayList<>();
			}
		}
		
		if (!currentTokens.isEmpty()) {
			System.err.println("Unexpected EOF: maybe add a semicolon at the end of the file");
			new Exception().printStackTrace();
			System.exit(-1);
		}
		
		return statements;
	}
}
