package com.thirds.lang.token;

public class Token {
	
	public enum TokenType {
		SEMICOLON, PARENTH_LEFT, PARENTH_RIGHT,
		IDENTIFIER
	}
	
	private String contents;
	
	private int line;
	private int column;
	private String fname;
	
	private TokenType type;
	
	public Token(String contents, TokenType type, int line, int column, String fname) {
		setContents(contents);
		setType(type);
		this.line = line;
		this.column = column;
		this.fname = fname;
	}
	
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	public int getLine() {
		return line;
	}
	public int getColumn() {
		return column;
	}
	public String getFname() {
		return fname;
	}
	
	public TokenType getType() {
		return type;
	}
	public void setType(TokenType type) {
		this.type = type;
	}
}
