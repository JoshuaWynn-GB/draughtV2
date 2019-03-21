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
    first.GetWhite().setIcon(colWhite);
    second.GetWhite().setIcon(whiteCount);
    first.squareContains= "NONE";
    second.squareContains = "WHITE";
  }
}
