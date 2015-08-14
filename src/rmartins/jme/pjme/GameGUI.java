/**
 * PJME - Basic J2ME Game Project
 * @author: Rafael Martins <rafaalemao13@gmail.com>
 * @author: Diogo Autilio <diautilio@gmail.com>
 * GameGUI.java
 */
package rmartins.jme.pjme;

import javax.microedition.lcdui.Graphics;

public class GameGUI 
{
    static GameGUI sGameGUIReference;

    public GameGUI() 
    {
        ILib.gameScore = 0;
    }

    public static GameGUI Instance()
    {
        return sGameGUIReference;
    }

    public static void InitGUI()
    {
        if(sGameGUIReference != null)
        {
            return;
        }

        sGameGUIReference = new GameGUI();
    }

    public void loadGameGUI()
    {
        
    }

    public void draw(Graphics g)
    {
        g.setColor(0xA000FF);
        String score = String.valueOf(ILib.gameScore);
        g.drawString("Score: " + score, 160, 20, Graphics.TOP | Graphics.LEFT);
    }

    public void update(long timePassed)
    {
    }
}
