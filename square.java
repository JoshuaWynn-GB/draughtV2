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

  public Square(double x, double y)
  {
    xPosition = x;
    yPosition = y;


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
