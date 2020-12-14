package com.github.biancacristina.compiler.common;

public class Token {
	private String label, attribute;
	private int row, col;
	
	public Token(
			String label,
			String attribute,
			int row,
			int col
	) {
		this.label = label;
		this.attribute = attribute;
		this.row = row;
		this.col = col;
	}
	
	public String getLabel() {
		return this.label;
	}
	public String getAttribute() {
		return this.attribute;
	}
	public String toString() {
		return " ---------TOKEN < " + this.label + " , " + this.attribute + " > ---------";
	}
	public String getErrorInfo() {
		return "----- row: " + this.row + ", col: " + this.col + " -----";
	}
}
