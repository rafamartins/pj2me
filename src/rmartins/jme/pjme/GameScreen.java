/**
 * PJME - Basic J2ME Game Project
 * @author: Rafael Martins <rafaalemao13@gmail.com>
 * @author: Diogo Autilio <diautilio@gmail.com>
 * GameScreen.java
 */
package rmartins.jme.pjme;

import java.io.IOException;
import javax.microedition.lcdui.Graphics;

public class GameScreen extends ScreenManager implements IScreen
{
    GameGUI mGameGUI;
    Level mLevel;
    Enemy mEnemy;
    Square mSquare;

    static GameScreen gGameReference;

    public GameScreen()
    {
        ILib.isGameStarted = true;

        GameGUI.InitGUI();
        mGameGUI = GameGUI.Instance();
        mGameGUI.loadGameGUI();
        mLevel = Level.InitLevel();
        loadElements();
    }

    public void loadElements()
    {
        loadSprites();
    }

    public void loadSprites()
    {
        try
        {
            mSquare = new Square();
            mEnemy = new Enemy();

        } catch (IOException ex)
        {
        }
    }

    public void draw(Graphics g)
    {        
        mLevel.draw(g);
        mGameGUI.draw(g);
        mSquare.draw(g);
        mEnemy.draw(g);

        drawSoftkeys(g);
    }

    public void drawSoftkeys(Graphics g)
    {
        g.setColor(0xFF0000);
        g.drawString(ResourceManager.STR_PAUSE, ILib.SCREEN_WIDTH - 45, 290,
                Graphics.TOP | Graphics.LEFT);
    }

    public void update(long timePassed)
    {
        if(mSquare.collidesWith(mEnemy, false))
        {
            mEnemy.setVisible(false);
            ILib.gameScore += 50;
        }
        
        if(ILib.RSK_PRESS)
        {
            ILib.mNextScreen = ScreenManager.PAUSE_SCREEN;
            ILib.RSK_PRESS = false;
        }

        mGameGUI.update(timePassed);
        mSquare.update(timePassed);
        mEnemy.update(timePassed);

        System.out.println("ButtonState: " + ILib.buttonCurrentState);
    }
}
