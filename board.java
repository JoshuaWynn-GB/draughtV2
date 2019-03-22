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
  Square moveWSpaceLeft;
  Square moveWSpaceRight;
  Square moveRSpaceLeft;
  Square moveRSpaceRight;



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




      for (int row=0; row<8; row++)
      {
        for(int col=0; col<8; col++)
        {
          square = squareArray[row][col];

          JButton clickedSqr = square.GetWhite();



          if (e.getSource().equals(clickedSqr))
          {
            System.out.println("clicked: " + col + ", " + row);

            //moveable spaces for white & red

            if (clicked==0)
            {
              if ((row==0))
              {
                System.out.println("     can't move anywhere");
                moveWSpaceLeft = squareArray[row][col];
                moveWSpaceRight = squareArray[row][col];

                moveRSpaceLeft = squareArray[row][col];
                moveRSpaceRight = squareArray[row][col];


              }
              else if (col==0)
              {
                System.out.println("     can move right");
                moveWSpaceLeft = squareArray[row][col];
                moveWSpaceRight = squareArray[row-1][col+1];

                moveRSpaceLeft = squareArray[row][col];
                moveRSpaceRight = squareArray[row+1][col+1];

              }
              else if (col==7)
              {
                System.out.println("     can move left");
                moveWSpaceLeft = squareArray[row-1][col-1];
                moveWSpaceRight = squareArray[row][col];

                moveRSpaceLeft = squareArray[row+1][col-1];
                moveRSpaceRight = squareArray[row][col];

              }
              else
              {
                System.out.println("     can move left & right");
                moveWSpaceLeft = squareArray[row-1][col-1];
                moveWSpaceRight = squareArray[row-1][col+1];

                moveRSpaceLeft = squareArray[row+1][col-1];
                moveRSpaceRight = squareArray[row+1][col+1];
              }
            }



            JButton clickedWLeft = moveWSpaceLeft.GetWhite();
            JButton clickedWRight = moveWSpaceRight.GetWhite();

            JButton clickedRLeft = moveRSpaceLeft.GetWhite();
            JButton clickedRRight = moveRSpaceRight.GetWhite();

            if (square.GetContents()=="WHITE")
            {
              clicked = 0;
            }

            if (square.GetContents()=="RED")
            {
              clicked = 0;
            }



            if ((clicked == 0)&&(square.GetContents()=="RED"))
            {
              firstColClick = col;
              firstRowClick = row;
              clicked = 1;
              firstSquare = squareArray[firstRowClick][firstColClick];
            }
            else if((clicked == 0)&&(square.GetContents()=="WHITE"))
            {
              firstColClick = col;
              firstRowClick = row;
              clicked = 1;
              firstSquare = squareArray[firstRowClick][firstColClick];
            }

            else if ((clicked == 1) && (square.GetContents()=="NONE") && (firstSquare.GetContents() == "WHITE") && (row==firstRowClick-1) && ((col==firstColClick-1) || (col==firstColClick+1)))
            {
              secColClick = col;
              secRowClick = row;
              clicked = 0;
              secSquare = squareArray[secRowClick][secColClick];
              square.moveTo(firstSquare,secSquare);
            }
            else if ((clicked == 1) && (square.GetContents()=="NONE") && (firstSquare.GetContents() == "RED") && (row==firstRowClick+1) && ((col==firstColClick-1) || (col==firstColClick+1)))
            {
              secColClick = col;
              secRowClick = row;
              clicked = 0;
              secSquare = squareArray[secRowClick][secColClick];
              square.moveTo(firstSquare,secSquare);
            }
            else
            {
              clicked = 0;
            }
            System.out.println(clicked);
            break;

          }
        }

      }

    }
}
