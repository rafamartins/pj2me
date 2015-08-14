/**
 * PJME - Basic J2ME Game Project
 * @author: Rafael Martins <rafaalemao13@gmail.com>
 * @author: Diogo Autilio <diautilio@gmail.com>
 * ADMidlet.java
 */
package rmartins.jme.pjme;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class ADMidlet extends MIDlet
{
    ADCanvas mCanvas;

    Display myDisplay;

    public ADMidlet()
    {
        myDisplay = Display.getDisplay(this);
        mCanvas = new ADCanvas(this);
    }

    public void startApp() 
    {
        myDisplay.setCurrent(mCanvas);
    }

    public void pauseApp()
    {
    }

    public void destroyApp(boolean unconditional)
    {
    }
}
