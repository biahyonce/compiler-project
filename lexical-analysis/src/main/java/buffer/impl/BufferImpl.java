package buffer.impl;

import buffer.BufferInterface;
import structure.*;
import exception.BufferException;

public class BufferImpl implements BufferInterface {
	private Automaton automaton;
	private String text;
	private int startLexem = 0, endLexem = 0;
	private int rowCounter = 1, colCounter = 1;
	
	public BufferImpl(Automaton automaton, String text) {
		this.automaton = automaton;
		this.text = text;
	}
	
	public boolean hasToken() {
		return !this.finishedString();
	}
	
	public Token getNextToken() {
		while(this.automaton.hasNextState(this.lookAhead())) {
			String charStr = this.lookAhead();
			
			this.automaton.makeTransition(charStr);
			this.updateCounters(charStr);
			this.endLexem++;
		}
		
		if(this.automaton.isAtFinalState()) {
			Token resultToken = new Token(
					this.automaton.getCurrentState().getTokenType(),
					this.text.substring(this.startLexem, this.endLexem)
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
		throw new BufferException("ERROR at row " + this.rowCounter + " column " + this.colCounter);
	}
}
