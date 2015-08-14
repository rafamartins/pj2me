/**
 * PJME - Basic J2ME Game Project
 * @author: Rafael Martins <rafaalemao13@gmail.com>
 * @author: Diogo Autilio <diautilio@gmail.com>
 * OptionsScreen.java
 */
package rmartins.jme.pjme;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;

public class OptionsScreen extends ScreenManager implements IScreen
{
    private String[] menuOptions;
    private String[] menuOptionsOnOff = new String[]{ "ON", "OFF" };

    public OptionsScreen()
    {
        ILib.gOptionMenu = 0;

        menuOptions = new String[2];
        menuOptions[0] = "SOUND: ";
        menuOptions[1] = "VIBRATION: ";
    }

    public void draw(Graphics g)
    {
        ILib.menuOptionsOffsetX = 100;
        ILib.menuOptionsOffsetY = 120;
        ILib.menuOptionsOnOffOffsetX = 170;
        ILib.menuOptionsOnOffOffsetY = 120;
        
        g.setColor(0xFFFFFF);
        g.fillRect(0, 0 , ILib.SCREEN_WIDTH, ILib.SCREEN_HEIGHT);

        for(int i=0; i< menuOptions.length; i++)
        {
            if(i == ILib.gOptionMenu)
            {
                g.setColor(0x0000FF);
            }
            else
            {
                g.setColor(0x000000);
            }

            g.drawString(menuOptions[i], ILib.menuOptionsOffsetX,
                ILib.menuOptionsOffsetY, Graphics.TOP | Graphics.LEFT);
            ILib.menuOptionsOffsetY+=20;             
        }

        g.setColor(0x000000);
        
        if(ILib.isSoundEnabled)
            g.drawString(menuOptionsOnOff[0], ILib.menuOptionsOnOffOffsetX,
                ILib.menuOptionsOnOffOffsetY, Graphics.TOP | Graphics.LEFT);
        else
            g.drawString(menuOptionsOnOff[1], ILib.menuOptionsOnOffOffsetX,
                ILib.menuOptionsOnOffOffsetY, Graphics.TOP | Graphics.LEFT);

        if(ILib.isVibrationEnabled)
            g.drawString(menuOptionsOnOff[0], ILib.menuOptionsOnOffOffsetX,
                ILib.menuOptionsOnOffOffsetY+20, Graphics.TOP | Graphics.LEFT);

        else
            g.drawString(menuOptionsOnOff[1], ILib.menuOptionsOnOffOffsetX,
                ILib.menuOptionsOnOffOffsetY+20, Graphics.TOP | Graphics.LEFT);

        drawSoftkeys(g);    
    }

    public void drawSoftkeys(Graphics g)
    {
        g.setColor(0xFF0000);
        g.drawString("SELECT", 10, 290,
                Graphics.TOP | Graphics.LEFT);
        g.drawString("BACK", ILib.SCREEN_WIDTH - 30, 290,
                Graphics.TOP | Graphics.LEFT);
    }

    public void update(long timePassed)
    {
        if(ILib.buttonCurrentState == GameCanvas.DOWN_PRESSED)
        {
            ILib.gOptionMenu++;

            if(ILib.gOptionMenu > 1)
                ILib.gOptionMenu = 0;

            ILib.buttonCurrentState = -1;
        }

        if(ILib.buttonCurrentState == GameCanvas.UP_PRESSED)
        {
            ILib.gOptionMenu--;

            if(ILib.gOptionMenu < 0)
                ILib.gOptionMenu = 1;

            ILib.buttonCurrentState = -1;
        }

        if(ILib.LSK_PRESS)
        {
            if(ILib.gOptionMenu == 0)
            {
                ILib.isSoundEnabled = !ILib.isSoundEnabled;
                ILib.LSK_PRESS = false;
            }

            if(ILib.gOptionMenu == 1)
            {
                ILib.isVibrationEnabled = !ILib.isVibrationEnabled;
                ILib.LSK_PRESS = false;
            }
        }

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
