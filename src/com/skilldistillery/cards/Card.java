package com.skilldistillery.cards;

import java.util.Objects;

public class Card {

	private final Rank ranks;
	private final Suit suits;
	
	public Card(Rank rank, Suit suit) {
		ranks = rank;
		suits = suit;
	}
	public int getVlaue() {
		return ranks.getValue();
		
	}
	public Rank getRanks() {
		return ranks;
	}
	public Suit getSuits() {
		return suits;
	}

	@Override
	public String toString() {
		return "Card " + ranks + " of " + suits ;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ranks, suits);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return ranks == other.ranks && suits == other.suits;
	}
	 
	
	
}
