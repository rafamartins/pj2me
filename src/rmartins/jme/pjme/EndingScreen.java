/**
 * PJME - Basic J2ME Game Project
 * @author: Rafael Martins <rafaalemao13@gmail.com>
 * @author: Diogo Autilio <diautilio@gmail.com>
 * EndingScreen.java
 */
package rmartins.jme.pjme;

import javax.microedition.lcdui.Graphics;

public class EndingScreen extends ScreenManager implements IScreen
{
    public EndingScreen()
    {

    }
   
    public void draw(Graphics g)
    {
        g.setColor(0xFFFFFF);
        g.fillRect(0, 0, ILib.SCREEN_WIDTH, ILib.SCREEN_HEIGHT);

        g.setColor(0x000000);
        
        if(ILib.gWin)
            g.drawString(ResourceManager.STR_YOUWIN, 100, 150, Graphics.TOP | Graphics.LEFT);
        else
            g.drawString(ResourceManager.STR_YOULOSE, 100, 150, Graphics.TOP | Graphics.LEFT);

        drawSoftkeys(g);
    }

    public void drawSoftkeys(Graphics g)
    {
        g.setColor(0xFF0000);
        g.drawString(ResourceManager.STR_NEXT, 10, 290, Graphics.TOP | Graphics.LEFT);
        g.drawString(ResourceManager.STR_QUIT, ILib.SCREEN_WIDTH - 45, 290,
                Graphics.TOP | Graphics.LEFT);
    }

    public void update(long timePassed)
    {
        if(ILib.RSK_PRESS)
        {
            ILib.RSK_PRESS = false;
            ILib.mNextScreen = ScreenManager.CONFIRMQUIT_SCREEN;
        }

    }
}
