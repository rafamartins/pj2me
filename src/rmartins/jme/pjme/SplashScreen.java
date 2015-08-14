/**
 * PJME - Basic J2ME Game Project
 * @author: Rafael Martins <rafaalemao13@gmail.com>
 * @author: Diogo Autilio <diautilio@gmail.com>
 * SplashScreen.java
 */
package rmartins.jme.pjme;

import javax.microedition.lcdui.Graphics;

public class SplashScreen extends ScreenManager implements IScreen
{
    int mWait;

    private final int SPLASH_TIME = 55;

    public SplashScreen()
    {
        mWait = 0;
    }
    
    public void draw(Graphics g)
    {
        ILib.drawSplash(g, 50);
    }

    public void update(long timePassed)
    {
        mWait++;
        //System.out.println("WAIT TIME: " + mWait);

        if(mWait == SPLASH_TIME)
        {
            ILib.mNextScreen = ScreenManager.TITLE_SCREEN;
        }
    }

    public void drawSoftkeys(Graphics g) {
        
    }

}
