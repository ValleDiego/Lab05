package it.polito.tdp.anagrammi.model;

public class RightWord {
	
	private String word;
	private boolean isRight;
	
	public RightWord(String word, boolean isRight) {
		super();
		this.word = word;
		this.isRight = isRight;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public boolean isRight() {
		return isRight;
	}

	public void setRight(boolean isRight) {
		this.isRight = isRight;
	}
	
	

}
