package com.thirds.lang.parse;

import java.util.ArrayList;

import com.thirds.lang.token.Token;

public class Statement {

	public enum StatementType {
		PRINT
	}
	
	private StatementType type;
	private ArrayList<Token> tokens;
	
	public Statement(StatementType type, ArrayList<Token> tokens) {
		setType(type);
		setTokens(tokens);
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
}
