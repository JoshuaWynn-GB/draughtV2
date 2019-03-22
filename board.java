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

  Square firstSquare;
  Square secSquare;
  Square opSquare;



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
      boolean king = false;




      for (int row=0; row<8; row++)
      {
        for(int col=0; col<8; col++)
        {
          square = squareArray[row][col];

          JButton clickedSqr = square.GetWhite();



          if (e.getSource().equals(clickedSqr))
          {

            if (square.GetContents()=="WHITE")
            {
              clicked = 0;
            }

            if (square.GetContents()=="RED")
            {
              clicked = 0;
            }

            if ((square.GetContents()=="whiteKING")||(square.GetContents()=="redKING"))
            {
              clicked = 0;
            }

            if (clicked == 0)
            {
              if ((square.GetContents()=="RED")||(square.GetContents()=="redKING"))
              {
                firstColClick = col;
                firstRowClick = row;
                clicked = 1;
                firstSquare = squareArray[firstRowClick][firstColClick];
              }
              if((square.GetContents()=="WHITE")||(square.GetContents()=="whiteKING"))
              {
                firstColClick = col;
                firstRowClick = row;
                clicked = 1;
                firstSquare = squareArray[firstRowClick][firstColClick];
              }
            }
            else
            {
              if ((square.GetContents()=="NONE") && (firstSquare.GetContents() == "WHITE") && (row==firstRowClick-1) && ((col==firstColClick-1) || (col==firstColClick+1)))
              {
                secColClick = col;
                secRowClick = row;
                clicked = 0;
                secSquare = squareArray[secRowClick][secColClick];
                square.moveTo(firstSquare,secSquare);
                if (row==0)
                {
                  square.upgrade(secSquare);
                }
              }
              if ((square.GetContents()=="NONE") && (firstSquare.GetContents() == "RED") && (row==firstRowClick+1) && ((col==firstColClick-1) || (col==firstColClick+1)))
              {
                secColClick = col;
                secRowClick = row;
                clicked = 0;
                secSquare = squareArray[secRowClick][secColClick];
                square.moveTo(firstSquare,secSquare);
                if (row==7)
                {
                  square.upgrade(secSquare);
                }
              }
              if ((square.GetContents()=="NONE") && (firstSquare.GetContents() == "WHITE") && (row==firstRowClick-2) && (col==firstColClick+2))
              {
                secColClick = col;
                secRowClick = row;
                clicked = 0;
                secSquare = squareArray[secRowClick][secColClick];
                opSquare = squareArray[secRowClick+1][secColClick-1];
                square.takeCount(firstSquare,secSquare,opSquare);
                if (row==0)
                {
                  square.upgrade(secSquare);
                }
              }
              if ((square.GetContents()=="NONE") && (firstSquare.GetContents() == "WHITE") && (row==firstRowClick-2) && (col==firstColClick-2))
              {
                secColClick = col;
                secRowClick = row;
                clicked = 0;
                secSquare = squareArray[secRowClick][secColClick];
                opSquare = squareArray[secRowClick+1][secColClick+1];
                square.takeCount(firstSquare,secSquare,opSquare);
                if (row==7)
                {
                  square.upgrade(secSquare);
                }
              }
              if ((square.GetContents()=="NONE") && (firstSquare.GetContents() == "RED") && (row==firstRowClick+2) && (col==firstColClick+2))
              {
                secColClick = col;
                secRowClick = row;
                clicked = 0;
                secSquare = squareArray[secRowClick][secColClick];
                opSquare = squareArray[secRowClick-1][secColClick-1];
                square.takeCount(firstSquare,secSquare,opSquare);
                if (row==0)
                {
                  square.upgrade(secSquare);
                }
              }
              if ((square.GetContents()=="NONE") && (firstSquare.GetContents() == "RED") && (row==firstRowClick+2) && (col==firstColClick-2))
              {
                secColClick = col;
                secRowClick = row;
                clicked = 0;
                secSquare = squareArray[secRowClick][secColClick];
                opSquare = squareArray[secRowClick-1][secColClick+1];
                square.takeCount(firstSquare,secSquare,opSquare);
                if (row==7)
                {
                  square.upgrade(secSquare);
                }
              }
              if ((square.GetContents()=="NONE") && ((firstSquare.GetContents() == "whiteKING")||(firstSquare.GetContents() == "redKING")) && ((row==firstRowClick+1)||(row==firstRowClick-1)) && ((col==firstColClick-1) || (col==firstColClick+1)))
              {
                secColClick = col;
                secRowClick = row;
                clicked = 0;
                secSquare = squareArray[secRowClick][secColClick];
                square.moveTo(firstSquare,secSquare);
              }
              if ((square.GetContents()=="NONE") && ((firstSquare.GetContents() == "whiteKING")||(firstSquare.GetContents() == "redKING")) && (row==firstRowClick-2) && (col==firstColClick+2))
              {
                secColClick = col;
                secRowClick = row;
                clicked = 0;
                secSquare = squareArray[secRowClick][secColClick];
                opSquare = squareArray[secRowClick+1][secColClick-1];
                square.takeCount(firstSquare,secSquare,opSquare);
              }
              if ((square.GetContents()=="NONE") && ((firstSquare.GetContents() == "whiteKING")||(firstSquare.GetContents() == "redKING")) && (row==firstRowClick-2) && (col==firstColClick-2))
              {
                secColClick = col;
                secRowClick = row;
                clicked = 0;
                secSquare = squareArray[secRowClick][secColClick];
                opSquare = squareArray[secRowClick+1][secColClick+1];
                square.takeCount(firstSquare,secSquare,opSquare);
              }
              if ((square.GetContents()=="NONE") && ((firstSquare.GetContents() == "whiteKING")||(firstSquare.GetContents() == "redKING")) && (row==firstRowClick+2) && (col==firstColClick+2))
              {
                secColClick = col;
                secRowClick = row;
                clicked = 0;
                secSquare = squareArray[secRowClick][secColClick];
                opSquare = squareArray[secRowClick-1][secColClick-1];
                square.takeCount(firstSquare,secSquare,opSquare);
              }
              if ((square.GetContents()=="NONE") && ((firstSquare.GetContents() == "whiteKING")||(firstSquare.GetContents() == "redKING")) && (row==firstRowClick+2) && (col==firstColClick-2))
              {
                secColClick = col;
                secRowClick = row;
                clicked = 0;
                secSquare = squareArray[secRowClick][secColClick];
                opSquare = squareArray[secRowClick-1][secColClick+1];
                square.takeCount(firstSquare,secSquare,opSquare);
              }
              clicked = 0;
            }
            break;
          }
        }

      }

    }

}
