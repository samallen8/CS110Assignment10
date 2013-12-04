//Sam Allen
//CS 110
//Assignment 10
//Jackie Horton

/* The WarGame class impliments the attributes of the War class by 
   materializing the frame. */

import javax.swing.*;

public class WarGame 
{
	public static void main(String [] args) 
{
      //initialize the frame and give it a title.
		JFrame frame = new War("War Game");
      //when closed, the program should terminate.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      /*make the size of the frame large enough to display all of the 
        contents within. */
      frame.setSize(500,600);
      //validate
      frame.validate();
      //make frame visible to user.
      frame.setVisible(true);

	}
}