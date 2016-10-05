package com.thirds.lang.token;

import java.util.ArrayList;
import java.util.regex.Pattern;

import com.thirds.lang.Messages;
import com.thirds.lang.token.Token.TokenType;

public class Tokeniser {

	public static final char[] DELIMITERS = { ' ', '\t', '\n', ';', '(', ')', '\0' };
	/**
	 * Identifiers must contain only alphanumeric characters and underscores,
	 * and the first digit must NOT be a digit.
	 */
	public static final Pattern identifierPattern = Pattern.compile("[a-zA-Z_][a-zA-Z0-9_]*");
	
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
				if (currentToken == "") {
					// Do nothing
				} else if (identifierPattern.matcher(currentToken).matches()) {
					// Token is an identifier
					tokens.add(new Token(currentToken, TokenType.IDENTIFIER, line, column, fname));
				} else {
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
					break;
				case '(':
					tokens.add(new Token(";", TokenType.PARENTH_LEFT, line, column, fname));
					break;
				case ')':
					tokens.add(new Token(";", TokenType.PARENTH_RIGHT, line, column, fname));
					break;
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
