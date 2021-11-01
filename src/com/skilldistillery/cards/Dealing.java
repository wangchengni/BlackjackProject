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
//		System.out.println(DealerHand.get(0));
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
				// user choose stand, means dealer turn,loop until win or bust
				stand += 1;
//				System.out.println(stand);

				System.out.println("Now dealer's turn,\nDealer's  first card is: "+DealerHand.get(0));
				System.out.println("Dealer's second card is: "+DealerHand.get(1));
				// if dealers value <17. dealer must get one, else
				if (DealerhandTotal < 17) {
					//this is dealer first check
					howMany = 1;
					for (int i = 0; i < howMany && (deck != null) && (deck.CheckDeckSize() > 0) && i < 52
							&& (howMany < deck.CheckDeckSize()); i++) {
						Card DealerdealtCard = deck.dealCard();
						DealerHand.add(DealerdealtCard);
						DealerhandTotal += DealerdealtCard.getVlaue();
						System.out.println("Dealer's third  card is: " + DealerHand.get(stand + 1));
						//next is dealer second check
						if (DealerhandTotal < 17) {
							
							while(DealerhandTotal < 17) {
							stand += 1;
							howMany = 1;
							for (i = 0; i < howMany && (deck != null) && (deck.CheckDeckSize() > 0) && i < 52
									&& (howMany < deck.CheckDeckSize()); i++) {
								DealerdealtCard = deck.dealCard();
								DealerHand.add(DealerdealtCard);
								DealerhandTotal += DealerdealtCard.getVlaue();
								System.out.println("Dealer's forth  card is: " + DealerHand.get(stand + 1));
							}
							}
							//the next is dealer >17, dealer stay no mater what ,then compare
							if(DealerhandTotal<UserhandTotal||DealerhandTotal>21) {
								System.out.println("You win!!");
//								break;
							}else if(DealerhandTotal>UserhandTotal) {
								System.out.println("Dealer win!!");
							}
							else if (DealerhandTotal == UserhandTotal) {
								System.out.println("hoo, push, get your money back!!");
							}
//							else {
//								System.out.println("You win!!");
//							}
						} else if (DealerhandTotal == UserhandTotal) {
							System.out.println("hoo, push, get your money back!!");
						} else if(DealerhandTotal<UserhandTotal||DealerhandTotal>21) {
							System.out.println("hoo, Second round you win!!");
							
						}
						  else {
//							if (DealerhandTotal > UserhandTotal && DealerhandTotal <= 21) {
								System.out.println("WOO, Second Round Dealer win!!");

							}
						}
				}else if(DealerhandTotal<UserhandTotal||DealerhandTotal>21) {
					System.out.println("Woo, First round, you win!!");
					
				} else if (DealerhandTotal>UserhandTotal && DealerhandTotal<=21) {
					System.out.println("Woo, First round, Dealer win!!");
				}else if(DealerhandTotal == UserhandTotal) {
					System.out.println("hoo, push, get your money back!!");
				}
				
			}
				
			

			else if (userChoice.equalsIgnoreCase("hit")) {
				// user choose hit, means user turn, loop until win or bust
				hit += 1;
//				System.out.println(hit);
				howMany = 1;
				for (int i = 0; i < howMany && (deck != null) && (deck.CheckDeckSize() > 0) && i < 52
						&& (howMany < deck.CheckDeckSize()); i++) {
					Card DealerdealtCard = deck.dealCard();
					Card UserdealtCard = deck.dealCard();
					userHand.add(UserdealtCard);
					UserhandTotal += UserdealtCard.getVlaue();
					System.out.println("Your third card is : " + userHand.get(hit + 1));
					System.out.println(UserhandTotal);
					
					
					
					if (UserhandTotal < 21) {
						System.out.println("Please choose Stand or Hit: ");
						userChoice = kb.nextLine();
						if (userChoice.equalsIgnoreCase("stand")) {
							//dealer turn
							System.out.println("Now it is Dealer's turn ");
							System.out.println("Dealer gonna show his first card: ");
							System.out.println("Dealer's first card is: "+DealerHand.get(0));
							System.out.println("Dealer's Second card is: "+DealerHand.get(1));
							
							if(DealerhandTotal>=17) {
								if(DealerhandTotal>UserhandTotal && DealerhandTotal<=21 ) {
									System.out.println("You lose, Dealer win!!");
								}else if(DealerhandTotal<UserhandTotal) {
									System.out.println("You Win, Dealer lose!!");
								}else if(DealerhandTotal==UserhandTotal) {
									System.out.println("Push, Get your money back!!");
									
								}
							}else if(DealerhandTotal<17) {
								while(DealerhandTotal < 17) {
									hit += 1;
									howMany = 1;
									for (i = 0; i < howMany && (deck != null) && (deck.CheckDeckSize() > 0) && i < 52
											&& (howMany < deck.CheckDeckSize()); i++) {
										DealerdealtCard = deck.dealCard();
										DealerHand.add(DealerdealtCard);
										DealerhandTotal += DealerdealtCard.getVlaue();
										System.out.println("Dealer's third  card is: " + DealerHand.get(hit));
							}
							
						}if(DealerhandTotal<UserhandTotal||DealerhandTotal>21) {
							System.out.println("You win!!");
//							break;
						}else if(DealerhandTotal>UserhandTotal && DealerhandTotal<=21 ) {
							System.out.println("Dealer win!!");
						}
						else if (DealerhandTotal == UserhandTotal) {
							System.out.println("hoo, push, get your money back!!");
						}
					}
				}
					else if (userChoice.equalsIgnoreCase("hit")) {
							hit += 1;
							howMany = 1;
							for (i = 0; i < howMany && (deck != null) && (deck.CheckDeckSize() > 0) && i < 52
									&& (howMany < deck.CheckDeckSize()); i++) {
								Card UserdealtCard2 = deck.dealCard();
								userHand.add(UserdealtCard2);
								UserhandTotal += UserdealtCard.getVlaue();
								System.out.println("Your forth card is : " + userHand.get(hit + 1));
								System.out.println(UserhandTotal);
								if (UserhandTotal < 21) {
									System.out.println("Please choose Stand or Hit: ");
									userChoice = kb.nextLine();
									if (userChoice.equalsIgnoreCase("stand")) {
									hit += 1;
									howMany = 1;
									for (i = 0; i < howMany && (deck != null) && (deck.CheckDeckSize() > 0) && i < 52
											&& (howMany < deck.CheckDeckSize()); i++) {
										Card UserdealtCard3 = deck.dealCard();
										userHand.add(UserdealtCard3);
										UserhandTotal += UserdealtCard.getVlaue();
										System.out.println("Your fifth card is : " + userHand.get(hit + 1));
										System.out.println(UserhandTotal);
									}if(UserhandTotal>21) { 
										System.out.println("You Bust, Dealer Win!!");
									}else if(UserhandTotal < 21) {
											System.out.println("Please choose Stand or Hit: ");
											userChoice = kb.nextLine();
											if (userChoice.equalsIgnoreCase("stand")) {
											hit += 1;
											howMany = 1;
											for (i = 0; i < howMany && (deck != null) && (deck.CheckDeckSize() > 0) && i < 52
													&& (howMany < deck.CheckDeckSize()); i++) {
												Card UserdealtCard3 = deck.dealCard();
												userHand.add(UserdealtCard3);
												UserhandTotal += UserdealtCard.getVlaue();
												System.out.println("Your sixth card is : " + userHand.get(hit + 1));
												System.out.println(UserhandTotal);
											}
											
										}
									}
									
								}
								}
								else if(UserhandTotal == 21 && DealerhandTotal<17) {
									while(DealerhandTotal < 17) {
										hit += 1;
										howMany = 1;
										for (i = 0; i < howMany && (deck != null) && (deck.CheckDeckSize() > 0) && i < 52
												&& (howMany < deck.CheckDeckSize()); i++) {
											DealerdealtCard = deck.dealCard();
											DealerHand.add(DealerdealtCard);
											DealerhandTotal += DealerdealtCard.getVlaue();
											System.out.println("Dealer's third  card is: " + DealerHand.get(hit));
								} 
								
							}if(DealerhandTotal<UserhandTotal||DealerhandTotal>21) {
								System.out.println("You win!!");
//								break;
							}else if(DealerhandTotal>UserhandTotal && DealerhandTotal<=21 ) {
								System.out.println("Dealer win!!");
							}
							else if (DealerhandTotal == UserhandTotal) {
								System.out.println("hoo, push, get your money back!!");
							}
								}
								else if (UserhandTotal == 21 && DealerhandTotal==21){
									System.out.println("Push get your money back!!");
								}
								else if (UserhandTotal == 21 && DealerhandTotal>17 && DealerhandTotal!=21) {

									System.out.println("WOO It is Black Jack , you Win!!");
								} else {
									System.out.println("You Bust, Dealer Win!!");
								}
							}
						}  
				}
					else if(UserhandTotal==21 && UserhandTotal==DealerhandTotal) {
						System.out.println("Push, get your moneny back!!");
						
					} else if(UserhandTotal==21 && DealerhandTotal!= 21) {
						System.out.println("You win, Delaer lose!!");
						
					} 
					else {

						System.out.println("You Bust, Dealer Win!!");
					}
				}

			}
		}
	}
		
	

//			System.out.println(DealerhandTotal);
//			System.out.println(UserhandTotal);

	public void run() {
		 
		// have the user to show their hand
//		System.out.println("Player totalof hand"+ handTotal);
//		 
	} 
}
