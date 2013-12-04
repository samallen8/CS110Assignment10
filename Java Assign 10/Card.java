//Sam Allen
//CS 110
//Assignment 10
//Jackie Horton

/* The card class creates a card and returns the name of the card with its
corresponding jpeg name to be used in the game of War. */

public class Card
{
	private int rank, suit;
   
   //Create arrays for suits and ranks to be combined
	private static String[] suits = { "h", "s", "d", "c" };
	private static String[] ranks  = { "ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king" };

   /*
      Construct a new new Card.
      @param suit is the card's suit.
      @param rank is the card's rank.
    */
	Card(int suit, int rank)
	{
		this.rank=rank;
		this.suit=suit;
	}
   /* toString method
      @return returns the information on the card in string format
   */
	public String toString()
	{
		  return ranks[rank] + suits[suit] + ".jpg";
	}
   /* getRank method
      @return returns the rank of the card when called.
   */
	public int getRank() {
		 return rank;
	}
   /* getSuit method
      @return returns the Suit of the card when called.
   */
	public int getSuit() {
		return suit;
	}

}
