/**
 * PJME - Basic J2ME Game Project
 * @author: Rafael Martins <rafaalemao13@gmail.com>
 * @author: Diogo Autilio <diautilio@gmail.com>
 * MainMenuScreen.java
 */
package rmartins.jme.pjme;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;

public class MainMenuScreen extends ScreenManager implements IScreen
{
    private String[] menuOptions;
    
    public MainMenuScreen()
    {
        ILib.gMenu = 0;
        ILib.isGameStarted = false;

        menuOptions = new String[]
        {
            ResourceManager.STR_NEWGAME,
            ResourceManager.STR_OPTIONS,
            ResourceManager.STR_HELP,
            ResourceManager.STR_ABOUT,
            ResourceManager.STR_EXIT
        };
    }
    
    public void draw(Graphics g)
    {
        ILib.menuOffsetX = 100;
        ILib.menuOffsetY = 120;
        
        g.setColor(0xFFFFFF);
        g.fillRect(0, 0, ILib.SCREEN_WIDTH, ILib.SCREEN_HEIGHT);

        for(int i=0; i< menuOptions.length; i++)
        {
            if(i == ILib.gMenu)
            {
                g.setColor(0x0000FF);
            }
            else
            {
                g.setColor(0x000000);
            }

            g.drawString(menuOptions[i], ILib.menuOffsetX, ILib.menuOffsetY,
                    Graphics.TOP | Graphics.LEFT);
            ILib.menuOffsetY+=20;
        }
        
        drawSoftkeys(g);
    }

    public void drawSoftkeys(Graphics g)
    {
        g.setColor(0xFF0000);
        g.drawString(ResourceManager.STR_SELECT, 10, 290,
                Graphics.TOP | Graphics.LEFT);
    }

    public void update(long timePassed)
    {
        if(ILib.buttonCurrentState == GameCanvas.DOWN_PRESSED)
        {
            ILib.gMenu++;
            
            if(ILib.gMenu > 4)
                ILib.gMenu = 0;

            ILib.buttonCurrentState = -1;
        }

        if(ILib.buttonCurrentState == GameCanvas.UP_PRESSED)
        {
            ILib.gMenu--;

            if(ILib.gMenu < 0)
                ILib.gMenu = 4;

            ILib.buttonCurrentState = -1;
        }

        if(ILib.LSK_PRESS)
        {
            switch(ILib.gMenu)
            {            
                case 0: //Start Game
                    ILib.LSK_PRESS = false;
                    ILib.mNextScreen = ScreenManager.GAMEOPTIONS_SCREEN;
                    break;
                case 1: //Options
                    ILib.LSK_PRESS = false;
                    ILib.mNextScreen = ScreenManager.OPTIONS_SCREEN;
                    break;
                case 2: //Help
                    ILib.LSK_PRESS = false;
                    ILib.mNextScreen = ScreenManager.HELP_SCREEN;
                    break;
                case 3: //About
                    ILib.LSK_PRESS = false;
                    ILib.mNextScreen = ScreenManager.ABOUT_SCREEN;
                    break;
                case 4: //Exit
                    ILib.LSK_PRESS = false;
                    ILib.mNextScreen = ScreenManager.EXIT_SCREEN;
                    break;
            }
        }
    }
}
