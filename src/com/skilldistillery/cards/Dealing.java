package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dealing {
	static Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Dealing del = new Dealing();
		del.FirstRound();
	}

	public void FirstRound() {
		Deck deck = new Deck();
		deck.shuffle();
		int howMany = 2;
		List<Card> userHand = new ArrayList<>();
		List<Card> DealerHand = new ArrayList<>();
		int UserhandTotal = 0;
		int DealerhandTotal = 0;
		for (int i = 0; i < howMany && (deck != null) && (deck.CheckDeckSize() > 0) && i < 52
				&& (howMany < deck.CheckDeckSize()); i++) {
			Card UserdealtCard = deck.dealCard();
			userHand.add(UserdealtCard);
			UserhandTotal += UserdealtCard.getVlaue();
		}
		for (int i = 0; i < howMany && (deck != null) && (deck.CheckDeckSize() > 0) && i < 52
				&& (howMany < deck.CheckDeckSize()); i++) {
			Card DealerdealtCard = deck.dealCard();
			DealerHand.add(DealerdealtCard);
			DealerhandTotal += DealerdealtCard.getVlaue();

		}
//			System.out.println(DealerHand.get(0));
		System.out.println("Dealer's show card is : " + DealerHand.get(1)); // dealer keep one card unshown
		// player must show all the cards
		System.out.println("Your first card is : " + userHand.get(0));
		System.out.println("Your Second card is : " + userHand.get(1));
		if (DealerhandTotal == 21 && UserhandTotal != 21) {
			System.out.println("Dealer win, you lose, Game Over!!");

		} else if (DealerhandTotal != 21 && UserhandTotal == 21) {
			System.out.println("You win, get all the money!!");
		} else if (DealerhandTotal == 21 && UserhandTotal == 21) {
			System.out.println("woo it's push, get your money back");
		} else {
			System.out.println("Please choose Stand or Hit: ");
			String userChoice = kb.nextLine();
			int stand = 0;
			int hit = 0;
			if (userChoice.equalsIgnoreCase("stand")) {
				stand += 1;
				System.out.println(stand);
			} else if (userChoice.equalsIgnoreCase("hit")) {
				hit += 0;
				System.out.println(hit);
			}
			if (stand != 0) {
				howMany = 1;
				for (int i = 0; i < howMany && (deck != null) && (deck.CheckDeckSize() > 0) && i < 52
						&& (howMany < deck.CheckDeckSize()); i++) {
					Card UserdealtCard = deck.dealCard();
					userHand.add(UserdealtCard);
					UserhandTotal += UserdealtCard.getVlaue();
					System.out.println("Your third card is : " + userHand.get(stand + 1));
					System.out.println(UserhandTotal);
					if (UserhandTotal < 21) {
						System.out.println("Please choose Stand or Hit: ");
						userChoice = kb.nextLine();

						if (userChoice.equalsIgnoreCase("stand")) {
							stand += 1;
							howMany = 1;
							for (i = 0; i < howMany && (deck != null) && (deck.CheckDeckSize() > 0) && i < 52
									&& (howMany < deck.CheckDeckSize()); i++) {
								Card UserdealtCard2 = deck.dealCard();
								userHand.add(UserdealtCard2);
								UserhandTotal += UserdealtCard.getVlaue();
								System.out.println("Your forth card is : " + userHand.get(stand + 1));
								System.out.println(UserhandTotal);
								if (UserhandTotal < 21) {
									stand += 1;
									howMany = 1;
									for (i = 0; i < howMany && (deck != null) && (deck.CheckDeckSize() > 0) && i < 52
											&& (howMany < deck.CheckDeckSize()); i++) {
										Card UserdealtCard3 = deck.dealCard();
										userHand.add(UserdealtCard3);
										UserhandTotal += UserdealtCard.getVlaue();
										System.out.println("Your forth card is : " + userHand.get(stand + 1));
										System.out.println(UserhandTotal);
									}
								} else if (UserhandTotal == 21) {

									System.out.println("WOO It is Black Jack , you Win!!");
								} else {
									System.out.println("You Bust, Dealer Win!!");
								}
							}
						}

					} else {

						System.out.println("You Bust, Dealer Win!!");
					}
				}

			}
		}
	}
//			System.out.println(DealerhandTotal);
//			System.out.println(UserhandTotal);

	public void run() {
		// get a deck of cards/instantize a new deck
		Deck deck = new Deck();
		// shuffle the deck/call the deck shuffle method
		deck.shuffle();
		// ask the user "how many cards you want"
		Scanner kb = new Scanner(System.in);
//		System.out.println("How many ");
//		int howMany = kb.nextInt();
		int howMany = 2;

		List<Card> userHand = new ArrayList<>();
		int handTotal = 0;

		// del the requested number of cards to the user
		for (int i = 0; i < howMany && (deck != null) && (deck.CheckDeckSize() > 0) && i < 52
				&& (howMany < deck.CheckDeckSize()); i++) {
			// user adds the dealt card into their running total
			Card dealtCard = deck.dealCard();
//			System.out.println(dealtCard);

			// user stuffs the dealt card into their hand
			userHand.add(dealtCard);
			// the user adds up the cards,based on their ran
			handTotal += dealtCard.getVlaue();
		}
		// have the user to show their hand
//		System.out.println("Player totalof hand"+ handTotal);
		for (Card card : userHand) {
			System.out.println(card);
		}
		System.out.println(userHand.get(0));
		System.out.println(userHand.get(1));

//		 
	}
}
