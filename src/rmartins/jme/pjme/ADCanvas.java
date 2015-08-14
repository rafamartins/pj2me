/**
 * PJME - Basic J2ME Game Project
 * @author: Rafael Martins <rafaalemao13@gmail.com>
 * @author: Diogo Autilio <diautilio@gmail.com>
 * ADCanvas.java
 */
package rmartins.jme.pjme;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;

public class ADCanvas extends GameCanvas implements Runnable
{
    ADMidlet midlet;
    ScreenManager mScreenManager;
    
    Thread gameThread;

    private boolean isRunning = false;
    
    public ADCanvas(ADMidlet midlet) 
    {
        super(false);
        this.midlet = midlet;

        setFullScreenMode(true);
        isRunning = true;
        mScreenManager = new ScreenManager();
        ILib.mNextScreen = ScreenManager.SPLASH_SCREEN;

        ILib.soundPlayer = new SoundManager();

        gameThread = new Thread(this);
        gameThread.start();
    }

    public void hideNotify()
    {
    }

    public void showNotify()
    {
    }
    
    public void keyPressed(int keyCode)
    {
        int keys = getKeyStates();
        
        if(keyCode == ILib.LSK_KEYCODE)
            ILib.LSK_PRESS = true;
        if(keyCode == ILib.RSK_KEYCODE)
            ILib.RSK_PRESS = true;

        if((keys & LEFT_PRESSED)!= 0)
        {
            ILib.buttonCurrentState = LEFT_PRESSED;
        }
        else if((keys & RIGHT_PRESSED)!= 0)
        {
            ILib.buttonCurrentState = RIGHT_PRESSED;
        }
        else if((keys & UP_PRESSED)!= 0)
        {
            ILib.buttonCurrentState = UP_PRESSED;
        }
        else if((keys & DOWN_PRESSED)!= 0)
        {
            ILib.buttonCurrentState = DOWN_PRESSED;
        }
        else if((keys & FIRE_PRESSED)!= 0)
        {
            ILib.buttonCurrentState = FIRE_PRESSED;
        }
    }

    public void keyReleased(int keyCode)
    {
        ILib.buttonCurrentState = -1;
    }

    public void keyRepeated(int keyCode)
    {
        int keys = getKeyStates();

        if((keys & LEFT_PRESSED)!= 0)
        {
            ILib.buttonCurrentState = LEFT_PRESSED;
        }
        else if((keys & RIGHT_PRESSED)!= 0)
        {
            ILib.buttonCurrentState = RIGHT_PRESSED;
        }
        else if((keys & UP_PRESSED)!= 0)
        {
            ILib.buttonCurrentState = UP_PRESSED;
        }
        else if((keys & DOWN_PRESSED)!= 0)
        {
            ILib.buttonCurrentState = DOWN_PRESSED;
        }
        else if((keys & FIRE_PRESSED)!= 0)
        {
            ILib.buttonCurrentState = FIRE_PRESSED;
        }
    }

    public void run()
    {
        FPSManager fpsManager = new FPSManager();
        
        final Graphics g = getGraphics();
        long lastLoopTime = System.currentTimeMillis();
        
        while(isRunning)
        {
            long timeDifference = System.currentTimeMillis() - lastLoopTime;
            lastLoopTime += timeDifference;

            //Screen Manager code
            if (ILib.mNextScreen != -1)
            {
                if (mScreenManager.isActive())
                {
                    mScreenManager.deactivate();
                }

                mScreenManager.activate(ILib.mNextScreen);
            }

            if (mScreenManager.isActive())
            {
                mScreenManager.mCurrentScreen.draw(g);
                mScreenManager.mCurrentScreen.update(timeDifference);
                fpsManager.updateFPS();
                fpsManager.renderFPS(g);
                flushGraphics();
            }

            //rmartins: We handle exit app from here (helpscreen cant handle
            //app context)
            if(ILib.LSK_PRESS && ILib.gScreen == ScreenManager.EXIT_SCREEN)
            {
                ILib.soundPlayer.stopAllSounds();
                System.gc();
                midlet.destroyApp(true);
                midlet.notifyDestroyed();
            }
        }
    }    
}
