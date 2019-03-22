import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Square
{
  private int rowPosition;
  private int colPosition;
  private String squareContains;

  ImageIcon colWhite = new ImageIcon("empty.png");
  JButton WhiteBut = new JButton(colWhite);
  ImageIcon colBlack = new ImageIcon("empty2.png");
  JButton BlackBut = new JButton(colBlack);

  ImageIcon redCount = new ImageIcon("red.png");
  ImageIcon whiteCount = new ImageIcon("white.png");
  ImageIcon redKingCount = new ImageIcon("red-king.png");
  ImageIcon whiteKingCount = new ImageIcon("white-king.png");




  public Square(int r, int c, String Contain)
  {
    rowPosition = r;
    colPosition = c;
    squareContains = Contain;

    if (Contain == "RED")
    {
      WhiteBut.setIcon(redCount);
    }
    if (Contain == "WHITE")
    {
      WhiteBut.setIcon(whiteCount);
    }

    if (Contain == "NONE")
    {
      WhiteBut.setIcon(colWhite);
    }



  }

  public JButton GetBlack()
  {
    return BlackBut;
  }
  public JButton GetWhite()
  {
    return WhiteBut;
  }

  public int GetColPos()
  {
    return colPosition;
  }

  public int GetRowPos()
  {
    return rowPosition;
  }

  public String GetContents()
  {
    return squareContains;
  }



  public void moveTo(Square first,Square second)
  {


    if (first.GetContents()== "WHITE")
    {
      second.GetWhite().setIcon(whiteCount);
      second.squareContains = "WHITE";
    }

    if (first.GetContents()== "RED")
    {
      second.GetWhite().setIcon(redCount);
      second.squareContains = "RED";
    }
    if (first.GetContents()== "redKING")
    {
      second.GetWhite().setIcon(redKingCount);
      second.squareContains = "redKING";
    }
    if (first.GetContents()== "whiteKING")
    {
      second.GetWhite().setIcon(whiteKingCount);
      second.squareContains = "whiteKING";
    }
    first.GetWhite().setIcon(colWhite);
    first.squareContains= "NONE";
  }

  public void takeCount(Square first,Square second,Square oponent)
  {


    if (first.GetContents()== "WHITE")
    {
      second.GetWhite().setIcon(whiteCount);
      second.squareContains = "WHITE";
    }

    if (first.GetContents()== "RED")
    {
      second.GetWhite().setIcon(redCount);
      second.squareContains = "RED";
    }
    if (first.GetContents()== "redKING")
    {
      second.GetWhite().setIcon(redKingCount);
      second.squareContains = "redKING";
    }
    if (first.GetContents()== "whiteKING")
    {
      second.GetWhite().setIcon(whiteKingCount);
      second.squareContains = "whiteKING";
    }
    first.GetWhite().setIcon(colWhite);
    first.squareContains= "NONE";
    oponent.GetWhite().setIcon(colWhite);
    oponent.squareContains= "NONE";
  }

  public void upgrade(Square sqr)
  {
    if (sqr.GetContents()== "WHITE")
    {
      sqr.GetWhite().setIcon(whiteKingCount);
      sqr.squareContains = "whiteKING";
    }

    if (sqr.GetContents()== "RED")
    {
      sqr.GetWhite().setIcon(redKingCount);
      sqr.squareContains = "redKING";
    }
  }
}
