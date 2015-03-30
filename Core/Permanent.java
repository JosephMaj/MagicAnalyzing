import java.awt.BufferedImage;
public class Permanent
{
  public String name = "";
  public String text = "";
  public BufferedImage image;
  public boolean creature;
  public boolean land;
  public int color;
  public Permanent(String nname, String ttext, int ncolor, BufferedImage nimage)
  {
    name = nname;
    text = ttext;
    color = ncolor;
    image = nimage;
  }
  public Permanent(Permanent p)
  {
    name = p.name;
    text = p.text;
    color = p.color;
    image = p.image;
  }
}

class Land extends Permanent
{
}