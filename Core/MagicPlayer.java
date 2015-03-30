import javax.swing.JFrame;
public class MagicSim
{
  public static void main(String[] args)
  {
    JFrame frame = new JFrame();

    frame.setSize(800,600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    MGame game = new MGame(800,600);
    frame.add(game);
    frame.setVisible(true);
  }
}