import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Board implements ActionListener
{
  public int clicked=0;

  public int firstColClick;
  public int firstRowClick;

  public int secColClick;
  public int secRowClick;


  Square[][] squareArray = new Square[8][8];
  public Board()
  {


    JFrame GUI = new JFrame();
    GUI.setTitle("Draughts");
    GUI.setSize(800, 800);
    GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();

    panel.setLayout(new GridLayout(8, 8));




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
            squareArray[row][col].GetWhite().addActionListener(this);
          }
          else if ((row==0)||(row==2))
          {
            squareArray[row][col] = new Square(row,col,"RED");
            panel.add(squareArray[row][col].GetBlack());
            col++;
            squareArray[row][col] = new Square(row,col,"RED");
            panel.add(squareArray[row][col].GetWhite());
            squareArray[row][col].GetWhite().addActionListener(this);
          }
          else
          {
            squareArray[row][col] = new Square(row,col,"NONE");
            panel.add(squareArray[row][col].GetBlack());
            col++;
            squareArray[row][col] = new Square(row,col,"NONE");
            panel.add(squareArray[row][col].GetWhite());
            squareArray[row][col].GetWhite().addActionListener(this);
          }
        }
        else
        {
          if((row==5)||(row==7))
          {
            squareArray[row][col] = new Square(row,col,"WHITE");
            panel.add(squareArray[row][col].GetWhite());
            squareArray[row][col].GetWhite().addActionListener(this);
            col++;
            squareArray[row][col] = new Square(row,col,"WHITE");
            panel.add(squareArray[row][col].GetBlack());
          }
          else if (row==1)
          {
            squareArray[row][col] = new Square(row,col,"RED");
            panel.add(squareArray[row][col].GetWhite());
            squareArray[row][col].GetWhite().addActionListener(this);
            col++;
            squareArray[row][col] = new Square(row,col,"RED");
            panel.add(squareArray[row][col].GetBlack());
          }
          else
          {
            squareArray[row][col] = new Square(row,col,"NONE");
            panel.add(squareArray[row][col].GetWhite());
            squareArray[row][col].GetWhite().addActionListener(this);
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


  public void actionPerformed(ActionEvent e)
    {
      Square square;
      Square firstSquare;
      Square secSquare;


      for (int row=0; row<8; row++)
      {
        for(int col=0; col<8; col++)
        {
          square = squareArray[row][col];

          JButton clickedSqr = square.GetWhite();
          if (e.getSource().equals(clickedSqr))
          {
            if ((clicked == 0)&&(square.GetContents()=="WHITE"))
            {
              firstColClick = col;
              firstRowClick = row;
              clicked++;
            }
            else if ((clicked == 1) && (square.GetContents()=="NONE"))
            {
              secColClick = col;
              secRowClick = row;
              clicked = 0;

              firstSquare = squareArray[firstRowClick][firstColClick];
              secSquare = squareArray[secRowClick][secColClick];

              System.out.println("first click: " + firstColClick + "," + firstRowClick + " second click: " + secColClick + ", " + secRowClick);
              square.moveTo(firstSquare,secSquare);
            }
            break;
          }
        }

      }

    }
}
