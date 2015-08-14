/**
 * PJME - Basic J2ME Game Project
 * @author: Rafael Martins <rafaalemao13@gmail.com>
 * @author: Diogo Autilio <diautilio@gmail.com>
 */
package rmartins.jme.pjme;

import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.Sprite;

public class Square extends Sprite
{
    private int[] FRAME_SEQUENCE = { 0, 1, 2, 3 };
    
    public Square() throws IOException
    {
        super(Image.createImage("/cyclops.png"), 32, 32);

        setTransform(TRANS_MIRROR_ROT270);
        setPosition(20, 190);
        setFrameSequence(FRAME_SEQUENCE);
    }

    public void draw(Graphics g)
    {
        this.paint(g);
    }

    public void update(long timePassed)
    {
        if(ILib.buttonCurrentState == GameCanvas.RIGHT_PRESSED)
        {
            if((getX()+ this.getWidth()) == 1072)
                return;
            else
            {
                move(1,0);
                nextFrame();
                Level.levelMap.move(-1, 0);
            }
        }

        if(ILib.buttonCurrentState == GameCanvas.LEFT_PRESSED)
        {
            if(getX() == 0)
                return;
            else
            {
                move(-1,0);
                prevFrame();

                if(Level.levelMap.getX() == 0)
                    return;
                else
                    Level.levelMap.move(1,0);
            }
        }
    }
}
