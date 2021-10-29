package com.skilldistillery.cards;

public enum Suit {

	HEARTS("\u2660\uFE0F"), SPADES("\u2665\uFE0F"), CLUBS("\u2666\uFE0F"), DIAMONDS("\u2663\uFE0F");
	
	private String name;
	private Suit(String names) {
		name = names;
	}
	@Override
	public String toString() {
		return name;
	}
	public String getName() {
		return name;
	}
}
