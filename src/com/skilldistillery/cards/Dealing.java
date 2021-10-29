package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dealing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Dealing del = new Dealing();
		del.run();
	}
	
	public void run() {
		//get a deck of cards/instantize a new deck
		Deck deck = new Deck();
		//shuffle the deck/call the deck shuffle method
		deck.shuffle();
		//ask the user "how many cards you want"
		Scanner kb = new Scanner(System.in);
		System.out.println("How many ");
		int howMany = kb.nextInt();
		
		List<Card> userHand = new ArrayList<>();
		int handTotal = 0;
		
		//del the requested number of cards to the user
		for(int i =0; 
				i<howMany &&(deck !=null)&&
				(deck.CheckDeckSize()>0)&&
				i<52&&
				(howMany <deck.CheckDeckSize());i++) {
			//user adds the dealt card into their running total
			Card dealtCard = deck.dealCard();
			
		
		
		//user stuffs the dealt card into their hand
		userHand.add(dealtCard);
		//the user adds up the cards,based on their ran
		handTotal += dealtCard.getVlaue();
		}
		//have the user to show their hand
		System.out.println("Player totalof hand"+ handTotal);
		for(Card card: userHand) {
			System.out.println(card);
		}
		}
	}


