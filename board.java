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

    //Create the grid
    for (int row=0; row<8;row++)
    {
      for(int col=0; col<8;col++)
      {
        if ((row%2)==0)
        {
          if (row==6)
          {
            squareArray[row][col] = new Square(row,col,"WHITE");
            panel.add(squareArray[row][col].GetBlack());
            col++;
            squareArray[row][col] = new Square(row,col,"WHITE");
            panel.add(squareArray[row][col].GetWhite());
          }
          else if ((row==0)||(row==2))
          {
            squareArray[row][col] = new Square(row,col,"RED");
            panel.add(squareArray[row][col].GetBlack());
            col++;
            squareArray[row][col] = new Square(row,col,"RED");
            panel.add(squareArray[row][col].GetWhite());
          }
          else
          {
            squareArray[row][col] = new Square(row,col,"NONE");
            panel.add(squareArray[row][col].GetBlack());
            col++;
            squareArray[row][col] = new Square(row,col,"NONE");
            panel.add(squareArray[row][col].GetWhite());
          }
        }
        else
        {
          if((row==5)||(row==7))
          {
            squareArray[row][col] = new Square(row,col,"WHITE");
            panel.add(squareArray[row][col].GetWhite());
            col++;
            squareArray[row][col] = new Square(row,col,"WHITE");
            panel.add(squareArray[row][col].GetBlack());
          }
          else if (row==1)
          {
            squareArray[row][col] = new Square(row,col,"RED");
            panel.add(squareArray[row][col].GetWhite());
            col++;
            squareArray[row][col] = new Square(row,col,"RED");
            panel.add(squareArray[row][col].GetBlack());
          }
          else
          {
            squareArray[row][col] = new Square(row,col,"NONE");
            panel.add(squareArray[row][col].GetWhite());
            col++;
            squareArray[row][col] = new Square(row,col,"NONE");
            panel.add(squareArray[row][col].GetBlack());
          }
        }

      }
    }







    GUI.setContentPane(panel);
    GUI.setVisible(true);
}


}
