import java.util.Scanner;
public class MagicTUI
{
  public static BoardState currentState;
  public static void main(String[] args)
  {
    Card.loadCardList("cards.txt");
    Scanner in = new Scanner(System.in);
    currentState = new BoardState();
    
  }
}