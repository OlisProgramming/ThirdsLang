package com.thirds.lang.token;

public class Token {
	
	public enum TokenType {
		PRINT
	}
	
	private String contents;
	private TokenType type;
	
	public Token(String contents, TokenType type) {
		setContents(contents);
		setType(type);
	}
	
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public TokenType getType() {
		return type;
	}
	public void setType(TokenType type) {
		this.type = type;
	}
}
