/**
 * PJME - Basic J2ME Game Project
 * @author: Rafael Martins <rafaalemao13@gmail.com>
 * @author: Diogo Autilio <diautilio@gmail.com>
 * IScreen.java
 */

package rmartins.jme.pjme;

import javax.microedition.lcdui.Graphics;

public interface IScreen
{
    void draw(Graphics g);

    void drawSoftkeys(Graphics g);

    void update(long timePassed);
}
