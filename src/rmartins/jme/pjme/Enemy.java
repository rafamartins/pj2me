/**
 * PJME - Basic J2ME Game Project
 * @author: Rafael Martins <rafaalemao13@gmail.com>
 * @author: Diogo Autilio <diautilio@gmail.com>
 * Enemy.java
 */
package rmartins.jme.pjme;

import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

public class Enemy extends Sprite
{
    private int[] FRAME_SEQUENCE;
    private int enemyState = -1;

    public static final int ENEMY_STATE_WALK = 0;
    public static final int ENEMY_STATE_ATTACK = 1;
    public static final int ENEMY_STATE_DIE = 2;
   
    public Enemy() throws IOException
    {
        super(Image.createImage("/medusa.png"), 32, 32);

        setFrameSequence(FRAME_SEQUENCE);
        setTransform(TRANS_MIRROR_ROT270);
        setPosition(ILib.SCREEN_WIDTH + 10, 190);
    }

    public void setEnemyState(int enemyState)
    {
        switch(enemyState)
        {
            case ENEMY_STATE_WALK: break;
            case ENEMY_STATE_ATTACK: break;
            case ENEMY_STATE_DIE: break;
        }
    }

    public int getEnemyState()
    {
        return enemyState;
    }

    public void draw(Graphics g)
    {
        paint(g);
    }

    public void update(long timePassed)
    {
        move(-1, 0);
    }

}
