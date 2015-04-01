import java.awt.image.BufferedImage;
public class Permanent {
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

  public Permanent(String nname, int ntype, String ntext, int ncolor) {
    name = nname;
    type = ntype;
    text = ntext;
    color = ncolor;
  }

  public Permanent(Permanent p) {
    this(p.name, p.type, p.text, p.color);
  }

  public Permanent(Card card) {

    this(nname = card.name, type = card.type, ntext = card.text, ncolor = card.color);

  }
}
  class Land extends Permanent {
    boolean tapped;
    public Land(String nname, int ntype, String ntext, int ncolor){
      super(nname,ntype,ntext,ncolor);
      tapped=false;
    }
  }

  class Creature extends Permanent {
    int power, toughness;

    public Creature(String nname, int ntype, String ntext, int ncolor, int power, int toughness){
      super(nname, ntypew, ntext, ncolor);
      this.power=power;
      this.toughness=toughness;

    }

  }


  class Artifact extends Permanent {
  }

  class Enchantment extends Permanent {
  }

  class PlanesWalker extends Permanent {

  }
