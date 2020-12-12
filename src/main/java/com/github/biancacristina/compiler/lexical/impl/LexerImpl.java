package com.github.biancacristina.compiler.lexical.impl;

import com.github.biancacristina.compiler.lexical.Lexer;
import com.github.biancacristina.compiler.lexical.exception.LexerException;
import com.github.biancacristina.compiler.automaton.Automaton;
import com.github.biancacristina.compiler.common.SymbolTable;
import com.github.biancacristina.compiler.common.Token;

public class LexerImpl implements Lexer {
	private static LexerImpl instance;

	private Automaton automaton;
	private String text;
	private int startLexem = 0, endLexem = 0;
	private int rowCounter = 1, colCounter = 1;
	private SymbolTable symbolTable = new SymbolTable();
	private Token endOfFileToken = new Token("eof", "");
	
	private LexerImpl(){}

	public void setAutomaton(Automaton automaton) {
		this.automaton = automaton;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void build(Automaton automaton, String text) {
		this.setAutomaton(automaton);
		this.setText(text);
	}
	
	public boolean hasToken() {
		return !this.finishedString();
	}
	
	public Token getNextToken() {
		if(this.finishedString()) {
			return this.endOfFileToken;
		}
		while(this.automaton.hasNextState(this.lookAhead())) {
			String charStr = this.lookAhead();
			
			this.automaton.makeTransition(charStr);
			this.updateCounters(charStr);
			this.endLexem++;
		}
		
		if(this.automaton.isAtFinalState()) {
			
			Integer index = null;
			if(this.automaton.getCurrentState().getTokenType().equals("id")) {
				index = symbolTable.getIndex(this.text.substring(this.startLexem, this.endLexem));
			}
			
			System.out.println("Tabela: " + symbolTable.getTable().toString() + "\n");
			
			Token resultToken = new Token(
					this.automaton.getCurrentState().getTokenType(),
					index == null ? this.text.substring(this.startLexem, this.endLexem) : index.toString()
			);
			
			this.startLexem = this.endLexem;
			this.automaton.reset();
			this.adjustForBlankCharacters();
			return resultToken;
		}
		
		// found an error
		this.throwException();
		return null;
	}
	
	private boolean finishedString() {
		return this.startLexem == this.endLexem 
				&& this.startLexem == this.text.length();
	}
	
	private String lookAhead() {
		if(this.endLexem == this.text.length()) {
			return "\0";
		}
		return String.valueOf(this.text.charAt(this.endLexem));
	}
	
	private void updateCounters(String charStr) {
		this.colCounter++;
		if(charStr.equals("\n")) {
			this.rowCounter ++;
			this.colCounter = 1;
		}
	}

	private void adjustForBlankCharacters() {
		while(this.startLexem == this.endLexem 
			&& this.isBlankCharacter(this.lookAhead().charAt(0))) {
			this.startLexem++;
			this.endLexem++;
		}
	}
	private boolean isBlankCharacter(char c) {
		return c == ' ' || c == '\n';
	}

	private void throwException() {
		throw new LexerException("ERROR at row " + this.rowCounter + " column " + this.colCounter);
	}

	public static LexerImpl getInstance() {
		if(LexerImpl.instance != null){
			return LexerImpl.instance;
		}
		LexerImpl.instance = new LexerImpl();
		return LexerImpl.instance;
	}
}