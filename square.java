import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Square
{
  private double xPosition;
  private double yPosition;


  ImageIcon colWhite = new ImageIcon("empty.png");
  JButton WhiteBut = new JButton(colWhite);
  ImageIcon colBlack = new ImageIcon("empty2.png");
  JButton BlackBut = new JButton(colBlack);


  public Square(int x, int y, String Contain)
  {
    xPosition = x;
    yPosition = y;

    if (Contain == "RED")
    {
      ImageIcon redCount = new ImageIcon("red.png");
      WhiteBut.setIcon(redCount);
    }
    if (Contain == "WHITE")
    {
      ImageIcon whiteCount = new ImageIcon("white.png");
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
}
