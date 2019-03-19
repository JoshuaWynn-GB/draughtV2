import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Square implements ActionListener
{
  private int rowPosition;
  private int colPosition;


  ImageIcon colWhite = new ImageIcon("empty.png");
  JButton WhiteBut = new JButton(colWhite);
  ImageIcon colBlack = new ImageIcon("empty2.png");
  JButton BlackBut = new JButton(colBlack);


  public Square(int r, int c, String Contain)
  {
    rowPosition = r;
    colPosition = c;

    WhiteBut.addActionListener(this);

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

  public void actionPerformed(ActionEvent e)
  {
    System.out.println("clicked: " + colPosition + ", " + rowPosition);
  }
}
