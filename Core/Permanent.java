import java.awt.image.BufferedImage;
public class Permanent
{
  public static final int LAND = 0x1;
  public static final int CREATURE = 0x2;
  public static final int ARTIFACT = 0x4;
  public static final int ENCHANTMENT = 0x8;
  public static final int PLANESWALKER = 0x10;

  public String name = "";
  public int type;
  public String text = "";
  public int color;
  public BufferedImage image;
  public Permanent(String nname, int ntype, String ntext, int ncolor)
  {
    name = nname;
    type = ntype;
    text = ntext;
    color = ncolor;
  }

  public Permanent(Permanent p)
  {
    this(p.name,p.type,p.text,p.color);
  }
}