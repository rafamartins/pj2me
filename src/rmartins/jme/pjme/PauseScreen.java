/**
 * PJME - Basic J2ME Game Project
 * @author: Rafael Martins <rafaalemao13@gmail.com>
 * @author: Diogo Autilio <diautilio@gmail.com>
 * PauseScreen.java
 */
package rmartins.jme.pjme;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;

public class PauseScreen 
{
    private String[] pauseMenuOptions;

    public PauseScreen()
    {
        ILib.gPauseMenu = 0;

        pauseMenuOptions = new String[4];
        pauseMenuOptions[0] = ResourceManager.STR_RESUME;
        pauseMenuOptions[1] = ResourceManager.STR_OPTIONS;
        pauseMenuOptions[2] = ResourceManager.STR_HELP;
        pauseMenuOptions[3] = ResourceManager.STR_QUITGAME;
    }
    
    public void draw(Graphics g)
    {
        ILib.pauseMenuOffsetX = 100;
        ILib.pauseMenuOffsetY = 120;
        
        g.setColor(0xFFFFFF);
        g.fillRect(0, 0, ILib.SCREEN_WIDTH, ILib.SCREEN_HEIGHT);

        for(int i=0; i< pauseMenuOptions.length; i++)
        {
            if(i == ILib.gPauseMenu)
            {
                g.setColor(0x0000FF);
            }
            else
            {
                g.setColor(0x000000);
            }

            g.drawString(pauseMenuOptions[i], ILib.pauseMenuOffsetX,
                    ILib.pauseMenuOffsetY,
                    Graphics.TOP | Graphics.LEFT);
            ILib.pauseMenuOffsetY+=20;
        }

        drawSoftkeys(g);
    }

    public void drawSoftkeys(Graphics g)
    {
        g.setColor(0xFF0000);
        g.drawString(ResourceManager.STR_SELECT, 10, 290,
                Graphics.TOP | Graphics.LEFT);
        g.drawString(ResourceManager.STR_RESUME, ILib.SCREEN_WIDTH - 50, 290,
                Graphics.TOP | Graphics.LEFT);
    }

    public void update(long timePassed)
    {
        if(ILib.LSK_PRESS)
        {
            switch(ILib.gPauseMenu)
            {
                case 0:
                    ILib.mNextScreen = ScreenManager.GAME_SCREEN;
                    ILib.LSK_PRESS = false;
                    break;
                case 1:
                    ILib.mNextScreen = ScreenManager.OPTIONS_SCREEN;
                    ILib.LSK_PRESS = false;
                    break;
                case 2:
                    ILib.mNextScreen = ScreenManager.HELP_SCREEN;
                    ILib.LSK_PRESS = false;
                    break;
                case 3:
                    ILib.mNextScreen = ScreenManager.CONFIRMQUIT_SCREEN;
                    ILib.LSK_PRESS = false;
                    break;
            }
        }

        if(ILib.buttonCurrentState == GameCanvas.DOWN_PRESSED)
        {
            ILib.gPauseMenu++;

            if(ILib.gPauseMenu > 3)
                ILib.gPauseMenu = 0;

            ILib.buttonCurrentState = -1;
        }

        if(ILib.buttonCurrentState == GameCanvas.UP_PRESSED)
        {
            ILib.gPauseMenu--;

            if(ILib.gPauseMenu < 0)
                ILib.gPauseMenu = 3;

            ILib.buttonCurrentState = -1;
        }

        if(ILib.RSK_PRESS)
        {
            ILib.mNextScreen = ScreenManager.GAME_SCREEN;
            ILib.RSK_PRESS = false;
        }
    }

}
