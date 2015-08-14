/**
 * PJME - Basic J2ME Game Project
 * @author: Rafael Martins <rafaalemao13@gmail.com>
 * @author: Diogo Autilio <diautilio@gmail.com>
 * HelpScreen.java
 */
package rmartins.jme.pjme;

import javax.microedition.lcdui.Graphics;

public class HelpScreen extends ScreenManager implements IScreen
{
    ResourceManager mResourceManager;
    private String strHelpText;
    
    public HelpScreen()
    {
        mResourceManager = new ResourceManager();
        strHelpText = new String/*[ResourceManager.MAXSTRING_COUNT]*/();
        strHelpText = mResourceManager.readStringResources();
    }

    public void draw(Graphics g)
    {
        g.setColor(0xFFFFFF);
        g.fillRect(0, 0 , ILib.SCREEN_WIDTH, ILib.SCREEN_HEIGHT);
        
        g.setColor(0x000000);
        g.drawString(ResourceManager.STR_HELP, 100, 160, Graphics.TOP | Graphics.LEFT);

        g.drawString(strHelpText, 100, 180, Graphics.TOP | Graphics.LEFT);

        drawSoftkeys(g);
    }

    public void drawSoftkeys(Graphics g)
    {
        g.setColor(0xFF0000);
        g.drawString(ResourceManager.STR_BACK, ILib.SCREEN_WIDTH - 30, 290,
                Graphics.TOP | Graphics.LEFT);
    }

    public void update(long timePassed)
    {
        if(ILib.RSK_PRESS)
        {
            if(ILib.isGameStarted)
            {
                ILib.RSK_PRESS = false;
                ILib.mNextScreen = ScreenManager.PAUSE_SCREEN;
            }
            else
            {
                ILib.RSK_PRESS = false;
                ILib.mNextScreen = ScreenManager.MAINMENU_SCREEN;
            }
            
        }
    }
}
