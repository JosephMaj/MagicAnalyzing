import java.awt.BufferedImage;
import java.io.File;
import java.util.Scanner;
public class Card
{
  public String name = "";
  public String text = "";
  public BufferedImage image;
  public boolean creature;
  public boolean land;
  public int color;
  public int[] cost;

  public Card(String nname, String ttext, int ncolor, BufferedImage nimage, int[] ncost)
  {
    name = nname;
    text = ttext;
    color = ncolor;
    image = nimage;
    cost = ncost;
  }
  public Card(Card c)
  {
    name = c.name;
    text = c.text;
    color = c.color;
    image = c.image;
    cost = c.cost;
  }
}