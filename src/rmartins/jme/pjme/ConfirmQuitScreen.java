/**
 * PJME - Basic J2ME Game Project
 * @author: Rafael Martins <rafaalemao13@gmail.com>
 * @author: Diogo Autilio <diautilio@gmail.com>
 * ConfirmQuitScreen.java
 */
package rmartins.jme.pjme;

import javax.microedition.lcdui.Graphics;

public class ConfirmQuitScreen extends ScreenManager implements IScreen
{
    public ConfirmQuitScreen()
    {
        
    }

    public void draw(Graphics g)
    {
        g.setColor(0xFFFFFF);
        g.fillRect(0, 0, ILib.SCREEN_WIDTH, ILib.SCREEN_HEIGHT);

        g.setColor(0x000000);
        g.drawString(ResourceManager.STR_QUITGAME, 100, 160, Graphics.TOP | Graphics.LEFT);

        drawSoftkeys(g);
    }

    public void drawSoftkeys(Graphics g)
    {
        g.setColor(0xFF0000);
        g.drawString(ResourceManager.STR_YES, 10, 290, Graphics.TOP | Graphics.LEFT);
        g.drawString(ResourceManager.STR_NO, ILib.SCREEN_WIDTH - 30, 290,
                Graphics.TOP | Graphics.LEFT);
    }

    public void update(long timePassed)
    {
        if(ILib.LSK_PRESS)
        {
            ILib.isGameStarted = false;
            ILib.LSK_PRESS = false;
            ILib.mNextScreen = ScreenManager.MAINMENU_SCREEN;           
        }

        if(ILib.RSK_PRESS)
        {
            ILib.RSK_PRESS = false;
            ILib.mNextScreen = ScreenManager.PAUSE_SCREEN;           
        }
    }



}
