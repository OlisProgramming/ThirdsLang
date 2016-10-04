package com.thirds.lang.token;

import java.util.ArrayList;

import com.thirds.lang.Messages;
import com.thirds.lang.token.Token.TokenType;

public class Tokeniser {

	public static char[] DELIMITERS = { ' ', '\t', '\n', ';', '\0' };
	
	public static ArrayList<Token> tokenise(String code, String fname) {
		
		ArrayList<Token> tokens = new ArrayList<>();
		
		String currentToken = "";
		
		code += '\0';  // EOF marker
		char[] codeChars = code.toCharArray();
		
		int line = 1;
		int column = 1;
		
		for (int i = 0; i < codeChars.length; i++) {
			
			char c = codeChars[i];
			
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
					tokens.add(new Token(currentToken, TokenType.PRINT, line, column, fname));
					break;
				default:
					Messages.error("Invalid token at line " +
							Integer.toString(line) + ", column " +
							Integer.toString(column) + " of file " +
							fname + ": " + currentToken);
				}
				currentToken = "";
				
				// Add delimiter token
				
				switch (c) {
				case ';':
					tokens.add(new Token(";", TokenType.SEMICOLON, line, column, fname));
				}
			}
			
			if (c == '\n') {
				line++;
				column = 1;
			} else {
				column++;
			}
		}
		
		return tokens;
	}
}
