package com.thirds.lang.parse;

import java.util.ArrayList;

import com.thirds.lang.token.Token;

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
				System.err.println("Invalid C++ Dependency");
				new Exception().printStackTrace();
				System.exit(-1);
				return "";
			}
		}
	}
	
	private StatementType type;
	private ArrayList<Token> tokens;
	private CPPDependency[] dependencies;
	
	public Statement(StatementType type, ArrayList<Token> tokens, CPPDependency... dependencies) {
		setType(type);
		setTokens(tokens);
		setDependencies(dependencies);
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
	
	public void setDependencies(CPPDependency[] dependencies) {
		this.dependencies = dependencies;
	}
}
