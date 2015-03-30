import java.util.ArrayList;
public class MoveEvaluator
{
  public static int colors = 6;

  public MoveEvaluator()
  {
  }

  public static ArrayList<Move> determineAvailableMoves(BoardState state, int player)
  {
    int[] mana = new int[colors];
    for(int i = 0; i<colors;i++)
      mana[i] = state.manaPool[player][i];
    for(Land l:state.lands[player])
      mana[l.color]++;

    int totalMana = 0;
    for(int i = 0; i<colors; i++)
      totalMana+=mana[i];

    ArrayList<Move> moveList = new ArrayList<Move>;
    for(Card c:state.hand[player])
    {
      boolean canPlay = true;
      int totalCost = c.cost[colors-1];
      for(int i = colors-2;i>=0;i--)
      {
        if (mana[i] < c.cost[i])
        {
          canPlay = false;
          break;
        }
        totalCost+=c.cost[i];
      }
      if (totalCost > totalMana)
        canPlay = false;
      if(canPlay)
        moveList.add(new Move(c));
    }
  }
}