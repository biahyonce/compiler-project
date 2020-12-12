package com.github.biancacristina.compiler.common;

public class Token {
	private String label, attribute;
	
	public Token(String label, String attribute) {
		this.label = label;
		this.attribute = attribute;
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
}
