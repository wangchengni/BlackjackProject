package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

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
			
			int howMany = kb.nextInt();
			int round1 = 2;
			List<Card> userHand = new ArrayList<>();
			System.out.println("This is the Starting round, you will get two card showed on the table!");
			for(int i =0; 
					i<round1 &&(deck !=null)&&
					(deck.CheckDeckSize()>0)&&
					i<52&&
					(round1 <deck.CheckDeckSize());i++) {
				//user adds the dealt card into their running total
				Card dealtCard = deck.dealCard();
				userHand.add(dealtCard);
			}
			
			
			
//			System.out.println("How many ");
//			
//			List<Card> userHand = new ArrayList<>();
//			int handTotal = 0;
//			
//			//del the requested number of cards to the user
//			for(int J =0; 
//					J<howMany &&(deck !=null)&&
//					(deck.CheckDeckSize()>0)&&
//					J<52&&
//					(howMany <deck.CheckDeckSize());J++) {
//				//user adds the dealt card into their running total
//				Card dealtCard2 = deck.dealCard();
////				System.out.println(dealtCard);
//				
//			
//			
//			//user stuffs the dealt card into their hand
//			userHand.add(dealtCard2);
//			//the user adds up the cards,based on their ran
//			handTotal += dealtCard2.getVlaue();
//			}
			//have the user to show their hand
//			System.out.println("Player totalof hand"+ handTotal);
			for(Card card: userHand) {
				System.out.println(card);
			}
			}
		



	}

