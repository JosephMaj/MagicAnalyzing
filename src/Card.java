import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Hashtable;
public class Card
{
  /* Card type is represented as an 8 bit integer. For example:
   * 00000110 = 6 represents an artifact creature.
   * Cards usually only have 1-2 types, and if they have 2 one of them is usually
   * "creature" and the other is "artifact" or "enchantment".
   * 
   * For now, we only have creatures, lands, and sorceries, but later we can add more. 
   * We're going to ignore Tribal for now, because it overcomplicates things and is a
   * minor mechanic from a single block. */

  /* No flavor text for now, maybe in the distant future. */

  public static final int LAND = 0x1;
  public static final int CREATURE = 0x2;
  public static final int ARTIFACT = 0x4;
  public static final int ENCHANTMENT = 0x8;
  public static final int PLANESWALKER = 0x10;
  public static final int SORCERY = 0x20;
  public static final int INSTANT = 0x40;

  /* We store the set of all cards here for now. Maybe move to file or cache lookup
   * if it becomes a memory concern later. */
  public static Hashtable<String,Card> cardList = new Hashtable<String,Card>();

  public String name = "";
  public int type;
  public String text = "";
  public BufferedImage image;
  public int color;
  public int[] cost;

  public Card(String nname, int ntype, String ntext, int ncolor, int[] ncost)
  {
    name = nname;
    type = ntype;
    text = ntext;
    color = ncolor;
    cost = ncost;
  }
  public Card(Card c)
  {
    this(c.name,c.type,c.text,c.color,c.cost);
  }
  public Card(String name)
  {
    this(cardList.get(name));
  }

  /* Sample format (no leading asterisks or spaces):

   * For a 2/2 creature that costs 1W and has no special abilities:
   * A Dude
   * 2 1
   * Human
   * 
   * 2 2
   * 1 0 0 0 0 1

   * For a burn spell that costs R:
   * Thunder Bolt
   * 32 8
   * Thunder Bolt does 3 damage to target creature or player.
   * 0 0 0 1 0 0
   */

  /* Should probably switch to JSONs at some point, but this will do for now.
     Input file should be a list of correctly formatted cards, no blank lines
     except for in the appropriate field for cards with blank text boxes. We don't
     do any verification for now, since we're making the files ourselves and we're kind
     of short on time. For now, make sure the last line isn't an extra blank line. */

  public static void loadCardList(String cardFileName)
  {
    try
    {
      Scanner clr = new Scanner(new File(cardFileName));
      String n; // Name
      int t; // Type
      int c; // Color
      while(clr.hasNextLine())
      {
        n = clr.nextLine();
        t = clr.nextInt();
        c = clr.nextInt();
        clr.nextLine();
        if((t^CREATURE) == 0)
          cardList.put(n,new Creature(
                          n,t,clr.nextLine(),clr.nextLine(),clr.nextInt(),clr.nextInt(),c,
                          new int[] {clr.nextInt(),clr.nextInt(),clr.nextInt(),
                                     clr.nextInt(),clr.nextInt(),clr.nextInt()}));
        else
          cardList.put(n,new Card(n,t,clr.nextLine(),c,
                       new int[] {clr.nextInt(),clr.nextInt(),clr.nextInt(),
                                  clr.nextInt(),clr.nextInt(),clr.nextInt()}));
        clr.nextLine();
      }
      clr.close();
    }
    catch(IOException e)
    {System.out.println("Error reading card list file.");}
  }
}

/* This may or may not just get absorbed by "Card", since it isn't terrible for other
   cards to just default to 0/0 if it means saving a useless class. We might be able to
   use this for combat though, and we might also want to make a class for sorceries. */

class Creature extends Card
{
  int power = 0;
  int toughness = 0;
  String creatureType = "";

  public Creature(String nname, int ntype, String nctype, String ntext,
                  int np, int nt, int ncolor, int[] ncost)
  {
    super(nname, ntype, ntext, ncolor, ncost);
    power = np;
    toughness = nt;
    creatureType = nctype;
  }
}