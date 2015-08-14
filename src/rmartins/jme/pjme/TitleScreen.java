/**
 * PJME - Basic J2ME Game Project
 * @author: Rafael Martins <rafaalemao13@gmail.com>
 * @author: Diogo Autilio <diautilio@gmail.com>
 * TitleScreen.java
 */
package rmartins.jme.pjme;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;

public class TitleScreen extends ScreenManager implements IScreen
{
    public TitleScreen()
    {

    }
    
    public void draw(Graphics g)
    {
        g.setColor(0xFFFFFF);
        g.fillRect(0, 0, 240, 320);

        g.setColor(0x000000);
        g.drawString("PRESS OK", 100, 150, Graphics.TOP | Graphics.LEFT);
    }

    public void drawSoftkeys(Graphics g)
    {

    }

    public void update(long timePassed)
    {
        if(ILib.buttonCurrentState == GameCanvas.FIRE_PRESSED)
        {
            ILib.mNextScreen = ScreenManager.CONFIRMSOUND_SCREEN;
            ILib.buttonCurrentState = -1;
        }
    }    
}
