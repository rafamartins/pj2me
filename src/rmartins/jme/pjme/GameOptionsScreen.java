/**
 * PJME - Basic J2ME Game Project
 * @author: Rafael Martins <rafaalemao13@gmail.com>
 * @author: Diogo Autilio <diautilio@gmail.com>
 * GameOptionsScreen.java
 */
package rmartins.jme.pjme;

import javax.microedition.lcdui.Graphics;

public class GameOptionsScreen extends ScreenManager implements IScreen
{
    GameGUI gameGUI;
    
    public GameOptionsScreen()
    {
        ILib.isGameStarted = true;
    }

    public void draw(Graphics g)
    {
        g.setColor(0xFFFFFF);
        g.fillRect(0, 0, ILib.SCREEN_WIDTH, ILib.SCREEN_HEIGHT);

        g.setColor(0x000000);
        g.drawString(ResourceManager.STR_LEVELOPTIONS, 100, 160, Graphics.TOP | Graphics.LEFT);

        drawSoftkeys(g);
    }

    public void drawSoftkeys(Graphics g)
    {
        g.setColor(0xFF0000);
        g.drawString(ResourceManager.STR_SELECT, 10, 290,
                Graphics.TOP | Graphics.LEFT);
        g.drawString(ResourceManager.STR_BACK, ILib.SCREEN_WIDTH - 30, 290,
                Graphics.TOP | Graphics.LEFT);
    }

    public void update(long timePassed)
    {
        if(ILib.LSK_PRESS)
        {
            ILib.LSK_PRESS = false;
            ILib.soundPlayer.stopSound(0);
            ILib.mNextScreen = ScreenManager.LOADING_SCREEN;
        }

        if(ILib.RSK_PRESS)
        {
            ILib.RSK_PRESS = false;
            ILib.mNextScreen = ScreenManager.MAINMENU_SCREEN;

        }
    }
}
