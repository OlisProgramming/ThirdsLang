package com.thirds.lang.token;

import java.util.ArrayList;

import com.thirds.lang.Messages;
import com.thirds.lang.token.Token.TokenType;

public class Tokeniser {

	public static char[] DELIMITERS = { ' ', '\t', '\n', ';', '\0' };
	
	public static ArrayList<Token> tokenise(String code) {
		
		ArrayList<Token> tokens = new ArrayList<>();
		
		String currentToken = "";
		
		code += '\0';  // EOF marker
		for (char c : code.toCharArray()) {
			
			boolean cIsDelimiter = false;
			for (char delimiter : DELIMITERS)
				if (c == delimiter)
					cIsDelimiter = true;
			
			if (!cIsDelimiter) {
				currentToken += c;
			} else {
				switch (currentToken) {
				case "":
					break;
				case "print":
					tokens.add(new Token(currentToken, TokenType.PRINT));
					break;
				default:
					Messages.error("Invalid token: '" + currentToken + "'");
				}
				currentToken = "";
				
				// Add delimiter token
				
				switch (c) {
				case ';':
					tokens.add(new Token(";", TokenType.SEMICOLON));
				}
			}
		}
		
		return tokens;
	}
}
