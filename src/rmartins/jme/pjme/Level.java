/**
 * PJME - Basic J2ME Game Project
 * @author: Rafael Martins <rafaalemao13@gmail.com>
 * @author: Diogo Autilio <diautilio@gmail.com>
 * Level.java
 */
package rmartins.jme.pjme;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.lcdui.game.TiledLayer;

public class Level extends LayerManager
{
    static Level mLevelReference;

    Image levelImg;
    public static TiledLayer levelMap;

    public static int levelOffsetX;
    public static int levelOffsetY;
    public static int levelMapWidth;

    private int[] levelGrid = { 1 };
    
    public Level()
    {
        levelOffsetX = 0;
        levelOffsetY = 0;

        try
        {
            levelImg = Image.createImage("/map.png");
        }catch(Exception e)
        {

        }

        levelMapWidth = levelImg.getWidth();

        levelMap = new TiledLayer(1, 1, levelImg, 1280, 320);

        for(int i=0; i<levelGrid.length; i++)
        {
            levelMap.setCell(i%1, i/1, levelGrid[i]);
        }

        append(levelMap);
        setViewWindow(0, 0, ILib.SCREEN_WIDTH, ILib.SCREEN_HEIGHT);
    }

    public static Level InitLevel()
    {
        if(mLevelReference == null)
        {
            mLevelReference = new Level();
        }

        return mLevelReference;
    }

    public void loadLevel(int levelNumber)
    {
        switch(levelNumber)
        {
            
        }
    }

    public void loadLevelResources()
    {
        
    }

    public void draw(Graphics g)
    {
        g.setColor(0xFFFFFF);
        g.fillRect(0, 0, ILib.SCREEN_WIDTH, ILib.SCREEN_HEIGHT);

        paint(g, 0, 0);
        //g.drawImage(levelImg, levelOffsetX, levelOffsetY, Graphics.TOP | Graphics.LEFT);
    }

    public void update(long timePassed)
    {

    }
}
