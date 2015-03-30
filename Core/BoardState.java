import java.util.ArrayList;
public class BoardState
{
  public static final int UNTAP = 0;
  public static final int UPKEEP = 1;
  public static final int DRAW = 2;
  public static final int MAIN1 = 3;
  public static final int COMBAT = 4;
  public static final int ATTACK = 5;
  public static final int BLOCK = 6;
  public static final int DAMAGE = 7;
  public static final int ENDCOMBAT = 8;
  public static final int MAIN2 = 9;
  public static final int END = 10;
  public static final int CLEANUP = 11;

  public static int colors = 6;

  int players = 2;

  public ArrayList<Permanent>[] creatures;
  public ArrayList<Permanent>[] lands;

  public ArrayList<Card>[] library;
  public ArrayList<Card>[] hand;

  public int[][] manaPool;

  public int[] life;
  public int turn;
  public int phase;

  public BoardState()
  {
    creatures = new ArrayList<Permanent>[players];
    lands = new ArrayList<Permanent>[players];
    library = new ArrayList<Card>[players];
    hand = new ArrayList<Card[players];

    life = new int[players];
    manaPool = new int[players][colors];

    for(int i = 0; i < players; i++)
    {
      creatures[i] = new ArrayList<Permanent>();
      lands[i]= new ArrayList<Permanent>();
      library[i] = new ArrayList<Card>();
      hand[i] = new ArrayList<Card>();
      life[i] = 20;
    }

    turn = 0;
    phase = MAIN1;
  }

  public BoardState(BoardState old)
  {
    creatures = new ArrayList<Permanent>[players];
    lands = new ArrayList<Permanent>[players];
    library = new ArrayList<Card>[players];
    hand = new ArrayList<Card[players];

    life = new int[players];
    manaPool = new int[players][colors];

    for(int i = 0; i < players; i++)
    {
      creatures[i] = new ArrayList<Permanent>();
      lands[i]= new ArrayList<Permanent>();
      library[i] = new ArrayList<Card>();
      hand[i] = new ArrayList<Card>();
      life[i] = old.life[i];

      for(Permanent p:old.creatures[i])
        creatures[i].add(new Permanent(p));
      for(Permanent p:old.lands[i])
        lands[i].add(new Permanent(p));
      for(Card c:old.library[i])
        library[i].add(new Card(c));
      for(Card c:old.hand[i])
        hand[i].add(new Card(c));
    }

    turn = old.turn;
    phase = old.phase;
  }
}