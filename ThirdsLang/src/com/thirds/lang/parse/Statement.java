package com.thirds.lang.parse;

import java.util.ArrayList;

import com.thirds.lang.Messages;
import com.thirds.lang.token.Token;
import com.thirds.lang.token.Token.TokenType;

public class Statement {

	public enum StatementType {
		PRINT
	}
	
	public enum CPPDependency {
		IOSTREAM;
		
		public String cppString() {
			switch (this) {
			case IOSTREAM:
				return "#include <iostream>";
			default:
				Messages.error("Invalid C++ Dependency: " + name());
				return "";
			}
		}
	}
	
	private StatementType type;
	private ArrayList<Token> tokens;
	private CPPDependency[] dependencies;
	
	public Statement(ArrayList<Token> tokens) {
		//tokens.remove(tokens.size() - 1);
		setTokens(tokens);
		parseStatement();
	}
	
	private void parseStatement() {
		
		if (matchTokens(TokenType.PRINT, TokenType.SEMICOLON)) {
			setType(StatementType.PRINT);
			setDependencies(CPPDependency.IOSTREAM);
			return;
		}
		
		String errorMsg = "Invalid statement:";
		for (Token t : tokens)
			errorMsg += " " + t.getType().toString();
		
		Messages.error(errorMsg);
	}
	
	/**
	 * Is this statement comprised of this set of tokens?
	 */
	private boolean matchTokens(TokenType... types) {
		
		if (tokens.size() != types.length) {
			return false;
		}
		
		for (int i = 0; i < types.length; i++) {
			if (tokens.get(i).getType() != types[i]) {
				// If the statement's token type does not match the provided type
				return false;
			}
		}
		
		// If the code reaches here, all matches were successful
		return true;
	}
	
	public String cppString() {
		return "std::cout << \"Hello, World!\";";
	}

	public StatementType getType() {
		return type;
	}

	public void setType(StatementType type) {
		this.type = type;
	}

	public ArrayList<Token> getTokens() {
		return tokens;
	}

	public void setTokens(ArrayList<Token> tokens) {
		this.tokens = tokens;
	}
	
	public CPPDependency[] getDependencies() {
		return dependencies;
	}
	
	public void setDependencies(CPPDependency... dependencies) {
		this.dependencies = dependencies;
	}
}
