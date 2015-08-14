/**
 * PJME - Basic J2ME Game Project
 * @author: Rafael Martins <rafaalemao13@gmail.com>
 * @author: Diogo Autilio <diautilio@gmail.com>
 * FPSManager.java
 */
package rmartins.jme.pjme;

import javax.microedition.lcdui.Graphics;

public class FPSManager
{
    private long startFPS = -1;
    private int totalFrames;
    private int fpsValue;

    public FPSManager()
    {
        fpsValue = 0;
    }

    public void updateFPS()
    {
        if (startFPS == -1)
        {
            startFPS = System.currentTimeMillis();
            totalFrames = 0;
        }

        long currentFPS = System.currentTimeMillis();
        long delay = currentFPS - startFPS;

        if (delay > 1000l)
        {
            startFPS = currentFPS;
            fpsValue = totalFrames;
            totalFrames = 0;
        }
        totalFrames++;
    }

    public int getFPSValue()
    {
        return fpsValue;
    }

    public void renderFPS(Graphics g)
    {
        g.setColor(0xFF0000);
        g.drawString("FPS: " + getFPSValue(), 20, 20,
                Graphics.TOP | Graphics.LEFT);
    }
}
