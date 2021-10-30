package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected List<Card> hand = new ArrayList<>();

	public Hand( ) {
		 
	}
	public void addCard(Card card) {
		 hand.add(card);
	}
	public void clear() {
		hand.remove(hand.size());
	}
	
	public int getHandValue() {
//		for()
		return 0;
	}
	@Override
	public String toString() {
		return "Hand [hand=" + hand + "]";
	}
	
}
