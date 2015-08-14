/**
 * PJME - Basic J2ME Game Project
 * @author: Rafael Martins <rafaalemao13@gmail.com>
 * @author: Diogo Autilio <diautilio@gmail.com>
 * ILib.java
 */
package rmartins.jme.pjme;

import java.io.InputStream;
import javax.microedition.lcdui.Graphics;

public class ILib
{
    //ScreenManager Handling
    public static int gScreen = 0;
    public static int mNextScreen = -1;

    //Menu Handling
    public static int gMenu = 0;
    public static int gOptionMenu = 0;
    public static int gPauseMenu = 0;
    public static int menuOffsetX = 0;
    public static int menuOffsetY = 0;
    public static int menuOptionsOffsetX = 0;
    public static int menuOptionsOffsetY = 0;
    public static int menuOptionsOnOffOffsetX = 0;
    public static int menuOptionsOnOffOffsetY = 0;
    public static int pauseMenuOffsetX = 0;
    public static int pauseMenuOffsetY = 0;

    //Device Features Handling
    public static boolean isSoundEnabled = false;
    public static boolean isVibrationEnabled = false;
    public static SoundManager soundPlayer;

    //Game Handling
    public static boolean isGameStarted = false;
    public static boolean gWin = false;
    public static int gameScore;
    
    //Device Attibutes
    public static final int SCREEN_WIDTH = 240;
    public static final int SCREEN_HEIGHT = 320;
    public static final int HALF_WIDTH = SCREEN_WIDTH/2;
    public static final int HALF_HEIGHT = SCREEN_HEIGHT/2;
    public static final int FIRE_KEYCODE = -5;
    public static final int LSK_KEYCODE = -6;
    public static final int RSK_KEYCODE = -7;  
    public static final int CLEAR_KEYCODE = -8;

    //Device Key Handling
    public static boolean LSK_PRESS = false;
    public static boolean RSK_PRESS = false;
    public static int buttonCurrentState = -1;
    public static int buttonStatePressed = 0;

    //States
    public static final int FINISHAPP_STATE = 0;

    //Util
    public static void drawSplash(Graphics g, /*Image splashImage,*/ int iTime)
    {
        g.setColor(0xFF0000);
        g.drawString("SPLASH SCREEN", 100, 150, Graphics.TOP | Graphics.LEFT);

        try
        {
            Thread.sleep(iTime);
        }catch(Exception e){}
    }
}
