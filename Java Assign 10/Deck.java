//Sam Allen
//CS 110
//Assignment 10
//Jackie Horton

/* The Deck class creates a deck of cards that is then shuffled to be 
   used in the game of War. */

import java.util.Random;

public class Deck {
	
   //initiate params
   private Card[] cards, hand1, hand2;
	int i;
   /*
      Construct a new new deck of 52 cards in a given order by creating an
      array.
    */
	public Deck()
	{
      //limit deck to 52 cards
		i=52;
      //create deck array.
		cards = new Card[53];
      //begin matching suits and ranks to create cards.
		int x=0;
		for (int a=0; a<=3; a++)
		{
			for (int b=0; b<=12; b++)
			 {
			   cards[x] = new Card(a,b);
			   x++;
			 }
		}
	}
   
   /*
      Scramble the deck by using the Random object to randomly pick a card
      and then removes it from the original deck array so as not to be
      reused
      @return returns the random card.
    */
	public Card randomCard()
	{
      //random object.
		Random rand = new Random();
		int index=0;
      
      //randomly pick card from deck array.
		index = rand.nextInt( i );
      
      //place card in array.
		Card spot = cards[index];
		cards[index]=cards[i];
		cards[i] = null;
		i--;
		return spot;
	} 
   
   /*getCards method 
      @return returns the number of cards in the deck.
   */
	public int getCards()
	{
		return i;
	}
   
} 

