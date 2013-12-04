//Sam Allen
//CS 110
//Assignment 10
//Jackie Horton

/* The War class will create the contents of the game by setting up
   the GUI interface and filling it with rules based on the Card and
   Deck Classes. */

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class War extends JFrame 
{

   //initialize all of the needed attributes.
   private JButton draw;
   private JLabel pic1, pic2, scoreDisplay1, scoreDisplay2;
   private ImageIcon front1, back1, front2, back2;
   private static int SCORE1, SCORE2;
   private Card[] hand1, hand2;
   private Deck deck = new Deck();
   private Card C;
   private Card[] full = new Card[52];
   private int index1 = 0;
   private int index2 = 0;
   private int i = 0;
   private ArrayList<Card> cards1;         
   private ArrayList<Card> cards2;


   
   public War(String s) 
   {
   
      //create a deck of 52 shuffled cards.
      while (deck.getCards()!= 0 )
	   {
		   C = deck.randomCard();
		   full[i] = C;
         i++;
	   }
      
      /*set up two arrays, half the size of the original deck to hold
        the hands of the players. */
      Card[] hand1 = new Card[26];
      Card[] hand2 = new Card[26];
      //divide the deck into two equally sized hands that are arrays
      System.arraycopy(full, 0, hand1, 0, 25);
      System.arraycopy(full, 26, hand2, 0, 25);
      
      /* Convert the arrays into ArrayLists so that they can be
         dynamically altered in size and contents. */ 
      cards1 = new ArrayList<Card>(Arrays.asList(hand1));         
      cards2 = new ArrayList<Card>(Arrays.asList(hand2));
      
      //begin constructing the GUI.      
      setLayout(new BorderLayout());
      //create a Jbutton object for drawing cards.
      draw = new JButton("Draw");
      //connect the button to the ActionListener.
      draw.addActionListener(new ButtonListener());
      //place button on interface.
      add(draw, BorderLayout.SOUTH);
      
      //create the card images to be displayed on the screen.
      //front1 and back 1 represent the card of player1
      front1 = new ImageIcon("aceh.jpg");
      back1 = new ImageIcon("back.jpg");

      //front2 and back2 represent the card of player2
      front2 = new ImageIcon("aces.jpg");
      back2 = new ImageIcon("back.jpg");

      //place the image icons on the GUI
      pic1 = new JLabel(back1);
      pic2 = new JLabel(back2);
      
      /* begin scoring the players. Their score represents the amount
         of cards in their hand.*/
      SCORE1 = 26;
      SCORE2 = 26;
      //display their initial scores on the screen
      scoreDisplay1 = new JLabel("Player 1: " + Integer.toString(SCORE1));
      scoreDisplay2 = new JLabel("Player 2: " + Integer.toString(SCORE2));
      
      //display all images and scores on the GUI together.
      add(pic1, BorderLayout.NORTH);
      add(pic2, BorderLayout.CENTER);
      add(scoreDisplay1, BorderLayout.WEST);
      add(scoreDisplay2, BorderLayout.EAST);
      
      

   }
   
/* The ButtonListener class responds to the button that is being pressed
   in the War class. when the button is pressed, it begins a round of
   the game and continues as called until the game is over. */   
class ButtonListener implements ActionListener
   {

   public void actionPerformed(ActionEvent e)
      {
      //create if statement that flips the card between front and back.
      if (pic1.getIcon() == front1 && pic2.getIcon() == front2)
         {
         /* if it is currently displaying the front of the card, flip to
            the back */
         pic1.setIcon(back1);
         pic2.setIcon(back2);
         
        }
      else
         {
         /* if it is currently displaying the back of the card, flip to
            the front */
         front1 = new ImageIcon(((Card)cards1.get(index1)).toString());
         front2 = new ImageIcon(((Card)cards2.get(index2)).toString());
         
         pic1.setIcon(front1);
         pic2.setIcon(front2);
         
         //once flipped to the front, compare the ranks of the cards.
         if (((Card)cards1.get(index1)).getRank() > ((Card)cards2.get(index2)).getRank())
         {
            /* if player1's card has a higher rank than player2's card
               then remove player2's card from his/her array and add it
               to the array of player1 and adjust the score acordingly.*/
            cards1.add(cards2.get(index2));
            cards2.remove(cards2.get(index2));
            SCORE1 = SCORE1 +1;
            SCORE2 = SCORE2 -1;
              
         }
         else if (((Card)cards1.get(index1)).getRank() < ((Card)cards2.get(index2)).getRank())
         {
            /* if player2's card has a higher rank than player1's card
               then remove player1's card from his/her array and add it
               to the array of player2 and adjust the score acordingly.*/
            cards2.add(cards1.get(index1));
            cards1.remove(cards1.get(index1));
            SCORE1 = SCORE1 -1;
            SCORE2 = SCORE2 +1;
            
         }
      } 
      
      //display the adjusted score.
      scoreDisplay1.setText("Player 1: " + Integer.toString(SCORE1));
      scoreDisplay2.setText("Player 2: " + Integer.toString(SCORE2));
      /* check to see if one of the players has won. if so, display
         a message informing them of their victory and then close the
         program. */
      if (SCORE1 == 52)
         {JOptionPane.showMessageDialog(null,"Player 1 Has Won");
         System.exit(0);}
      else if (SCORE2 == 52)
         {JOptionPane.showMessageDialog(null,"Player 2 Has Won");
         System.exit(0);}
      
      /* if there is still no winner. increment the index and move to
         the next card/round.*/
      index1++;
      index2++;
      
      /* if the index has incremented beyonf the size of the array list.
         then start from the first card for that list. */
      if (index1 >= (cards1.size()))
         index1 = 0; 
      if (index2 >= (cards2.size()))
         index2 = 0;
      /* remove all null cells from the array list resize it and prevent
         NullPointerException */   
      cards1.removeAll(Collections.singleton(null));
      cards2.removeAll(Collections.singleton(null));


      }
     
   }
 }
 
