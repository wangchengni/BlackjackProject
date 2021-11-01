package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

//	Card [] deck = new Card[52];
	private List<Card> deck = new ArrayList<>();
	
	public Deck() {
		
		for(Suit s : Suit.values()) {
			for(Rank r: Rank.values()) {
				Card card = new Card(r,s);
				deck.add(card);
			}
		}
	}
	public int CheckDeckSize() {
		return deck.size();
	}
	public Card dealCard() { 
		
		return deck.remove(0);
	}
	public void shuffle() {
		Collections.shuffle(deck);
	}
	public void dealCard(Hand hand) {
		hand.addCard(deck.remove(0));
	}
}
