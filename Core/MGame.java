/*
* Magic: The Gathering Simulator Backend
*
* Code by David Sekora
* Created March 17th 2015
*
* TO DO:
*/

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.ArrayList
public class ZGame extends JPanel implements KeyListener
{
  static final int DEFAULT_ROWS = 3;
  static final int DEFAULT_COLS = 5;

  int rows = 3;
  int cols = 5;

  Color borderColor = Color.WHITE;
  Color activeBackColor = new Color(0,0,200);
  Color passiveBackColor = new Color(0,0,150);
  Color textColor = Color.BLACK;

  int xOffset = 100;
  int yOffset = 100;
  int playWidth = 600;
  int playerHeight = 200;
  int playHeight = playerHeight*2+1;

  int cardWidth = playWidth/(cols+1);
  int cardHeight = playHeight/rows - 10;

  int dividerX1 = xOffset+1;
  int dividerX2 = xOffset + playerWidth - 1;
  int dividerYOffset = yOffset+playerHeight + 1;
  int backY1 = yOffset+1;
  int backWidth = playWidth-2;
  int backHeight = playHeight-2;

  int lifeX = dividerX2 + 21;
  int lifeY1 = playerHeight/2 - 10;
  int lifeY2 = dividerYOffset + lifeY1;

  BoardState curState;

  Random random;

  public MGame(int wid, int hei)
  {
    super();
    this.setFocusable(true);
    addKeyListener(this);

    curState = new BoardState();
    random = new Random();
  }

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    // Draw the play border
    g.setColor(borderColor);
    g.drawRect(xOffset,yOffset,playWidth,playHeight);
    g.drawLine(dividerX1, dividerYOffset, dividerX2, dividerYOffset);
    
    // Draw the playfield backdrop
    g.setColor(passiveBackColor);
    g.fillRect(dividerX1,backY1,backWidth,backHeight);

    // Draw the cards
    for(int i=0;i<creatures1.size();i++)
    {
      drawPermanent(g, xOffset + i*cardWidth, dividerYOffset + 10, creatures1.get(i));
    }
    for(int i=0;i<creatures1.size();i++)
    {
      drawPermanent(g, xOffset + i*cardWidth, dividerYOffset + 10, creatures1.get(i));
    }

    g.setColor(textColor);
    g.drawString("Player 1 Life: " + life1,lifeX,lifeY1);
    g.drawString("Player 2 Life: " + life2,lifeX,lifeY2);

    if(lost)
    {
      g.setColor(new Color(0,0,0,180));
      g.fillRect(xOffset+1,yOffset+1,width-2,height-2);
      g.drawString("Game Over!",xOffset+60,yOffset + height + 20);
    }
    else if(paused)
    {
      g.setColor(new Color(0,0,0,128));
      g.fillRect(xOffset+1,yOffset+1,width-2,height-2);
      g.drawString("Paused!",xOffset+60,yOffset + height + 20); 
    }
  }

  public void drawBox(Graphics g, int row, int col, Color c)
  {
    int x = xOffset + boxSize*col;
    int y = yOffset + boxSize*row;
    g.setColor(c);
    g.fillRect(x+1,y+1,boxSize-2,boxSize-2);
    g.setColor(borderColor);
    g.drawRect(x,y,boxSize,boxSize);
  }

  public void resetFrame()
  {
    nextTick = System.currentTimeMillis() + MSPF;
  }

  public void togglePause()
  {
    paused = !paused;
    repaint();
  }

  public void movePlayerLeft()
  {
    if(playerCol>0)
      playerCol--;
  }

  public void movePlayerRight()
  {
    if(playerCol<cols-1)
      playerCol++;
  }

  public void movePlayerUp()
  {
    if(playerRow>0)
      playerRow--;
  }

  public void movePlayerDown()
  {
    if(playerRow<rows-1)
      playerRow++;
  }

  public void keyPressed(KeyEvent e)
  {
    if(!paused)
      switch(e.getKeyCode())
      {
       case KeyEvent.VK_A:
        movePlayerLeft();
        break;

       case KeyEvent.VK_D:
        movePlayerRight();
        break;

       case KeyEvent.VK_W:
        movePlayerUp();
        break;

       case KeyEvent.VK_S:
        movePlayerDown();
        break;

 
       case KeyEvent.VK_K:
       case KeyEvent.VK_J:
        break;
      }
  }

  public void keyReleased(KeyEvent e)
  {
    switch(e.getKeyCode())
    {
     case KeyEvent.VK_P:
      togglePause();
      break;
    }
  }
  public void keyTyped(KeyEvent e)
  {
  }
}