/**
 * PJME - Basic J2ME Game Project
 * @author: Rafael Martins <rafaalemao13@gmail.com>
 * @author: Diogo Autilio <diautilio@gmail.com>
 * LoadingScreen.java
 */
package rmartins.jme.pjme;

import javax.microedition.lcdui.Graphics;

public class LoadingScreen extends ScreenManager implements IScreen
{
    private int loadingProgress;

    public LoadingScreen()
    {
        loadingProgress = 0;
    }

    public void draw(Graphics g)
    {
        g.setColor(0xFFFFFF);
        g.fillRect(0, 0, ILib.SCREEN_WIDTH, ILib.SCREEN_HEIGHT);

        g.setColor(0x000000);
        g.drawString(ResourceManager.STR_LOADING, 100, 150, Graphics.TOP | Graphics.LEFT);

        g.setColor(0xFF0000);
        g.drawRect(40, 220, 160, 20);

        g.fillRect(40, 220, loadingProgress, 20);
    }

    public void drawSoftkeys(Graphics g)
    {
    }

    public void update(long timePassed)
    {
        loadingProgress+=5;

        try
        {
            Thread.sleep(100);
        }catch(Exception e)
        {
        }

        if(loadingProgress == 160)
        {
            if(!ILib.isGameStarted)
            {
                //Menu Loading
                ILib.mNextScreen = ScreenManager.MAINMENU_SCREEN;
                
                /*if(ILib.isSoundEnabled)
                    ILib.soundPlayer.playSound(SoundManager.SOUND_MENU);*/
            }
            else
                //Start Game Loading
                ILib.mNextScreen = ScreenManager.GAME_SCREEN;
                
        }
    }
}
