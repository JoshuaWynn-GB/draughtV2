import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Board
{


  public static void main(String[] args)
  {

    JFrame GUI = new JFrame();
    GUI.setTitle("Draughts");
    GUI.setSize(800, 800);
    GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();

    panel.setLayout(new GridLayout(8, 8));
    Square[][] squareArray = new Square[8][8];
    for (int row=0; row<8;row++)
    {
      for(int col=0; col<8;col++)
      {
        if ((row%2)==0)
        {
          squareArray[row][col] = new Square(row,col);
          panel.add(squareArray[row][col].GetBlack());
          col++;
          squareArray[row][col] = new Square(row,col);
          panel.add(squareArray[row][col].GetWhite());
        }
        else
        {
          squareArray[row][col] = new Square(row,col);
          panel.add(squareArray[row][col].GetWhite());
          col++;
          squareArray[row][col] = new Square(row,col);
          panel.add(squareArray[row][col].GetBlack());
        }

      }
    }






    GUI.setContentPane(panel);
    GUI.setVisible(true);
}


}
