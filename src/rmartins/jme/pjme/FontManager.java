/**
 * PJME - Basic J2ME Game Project
 * @author: Rafael Martins <rafaalemao13@gmail.com>
 * @author: Diogo Autilio <diautilio@gmail.com>
 * FontManager.java
 */

package rmartins.jme.pjme;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class FontManager
{
    Image fontImg;
    public int width, height;
    private final boolean fixed = false;
    public static final int FONT_TRACKING = 1;

    public FontManager()
    {
    }

    public static final int FONT_WIDTHS [] =
    {
        6,		//A
	7,		//B
	7,		//C
	7,		//D
	6,		//E
	6,		//F
	7,		//G
	6,		//H
	3,		//I
	5,		//J
	7,		//K
	5,		//L
	7,		//M
	7,		//N
	7,		//O
	6,		//P
	7,		//Q
	7,		//R
	7,		//S
	7,		//T
	7,		//U
	7,		//V
	9,		//W
	9,		//X
	7,		//Y
	7,		//Z
	6,		//0
	4,		//1
	6,		//2
	6,		//3
	6,		//4
	6,		//5
	6,		//6
	6,		//7
	6,		//8
	6,		//9
	3,		//!
	9,		//@
	7,		//#
	6,		//$
	9,		//%
	7,		//^
	9,		//&
	7,		//*
	5,		//(
	5,		//)
	9,		//©
	9,		//}
	5,		//[
	6,		//]
	6,		//<
	6,		//>
	4,		//;
	3,		//:
	4,		//,
        3,		//.
        3,		//'
        5,		//"
        7,		//?
        6,		///
        7,		//-
        6,		//=
        7,		//_
        7,		//+
        6,		//\
        3,		//|
        4,		//`
        9,		//~
        3,		//¡
        7,		//¿
        6,		//À
        6,		//È
        6,		//É
        4,		//Í
        7,		//Ü
        8,		//ß
        6,		//à
        6,		//á
        6,		//â
        6,		//ä
        6,		//ç
        6,		//è
        6,		//é
        6,		//ê
        4,		//ì
        4,		//í
        5,		//î
        6,		//ñ
        6,		//ó
        6,		//ô
        6,		//ö
        6,		//ù
        6,		//ú
        6,		//û
        6, 		//ü
        6,              //Ã
        6,              //Õ
        7,              //Ç
        6               //Á
    };

    public static final String CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()©}[]<>;:,.'\"?/-=_+\\|`~¡¿ÀÈÉÍÜßàáâäçèéêìíîñóôöùúûüÃÕÇÁ";

    public void loadFont(String imagePath)
    {
	try
	{
            fontImg = Image.createImage(imagePath);
            this.width   = fontImg.getWidth() / CHARSET.length();
            this.height  = fontImg.getHeight();
	}
	catch (Exception e) {
            System.out.println("Error ao carregar a fonte "+ e);
        }
    }

    public void unload()
    {
        fontImg = null;
    }

    public final void print(Graphics graphics, String text, int x, int y, int flags)
    {
        int len = text.length();
	int dx;
	int dy;
	int width = 0;
	int clipX = graphics.getClipX();
	int clipY = graphics.getClipY();
	int clipW = graphics.getClipWidth();
	int clipH = graphics.getClipHeight();
	int r = clipX + clipW;

	char[] string = text.toCharArray();

	// set initial position, adjusting for justification flags
	dx = x;
	dy = y;

	for (int i = 0; i < len; i++)
	{
            int character = string[i];
            if (character != '|')
            {
                if (character != ' ')
		{
                    if (dx < r)
                    {
                        int c = getCharacterIndex((char)character);
			width = this.fixed? this.width : (FONT_WIDTHS[c<0?0:c]);
			if (c >= 0)
			{
                            if (dx > -width && dx + width > clipX)
                            {
                                graphics.setClip(clipX, clipY, clipW, clipH);
				graphics.clipRect(dx, dy, width, this.height);
				graphics.drawImage(fontImg, dx - (this.width * c), dy, Graphics.LEFT|Graphics.TOP);
                            }
			}
                    }
                    else
                    {
                        while ((i + 1 < len) && (string[i+1] != '|'))
                            i++;
                    }
		}
		else
		{
                    width = this.width >> 1;
		}
		// move to next space
		dx += width + FontManager.FONT_TRACKING;
            }
            else
            {
                // move back to the beginning of the line
		dx  = x;
		dy += this.height + 1;
            }
	}
            // restore clip window
            graphics.setClip(0, 0, ILib.SCREEN_WIDTH, ILib.SCREEN_HEIGHT);
    }

    public int getCharacterIndex(char character)
    {
        int c = FontManager.CHARSET.indexOf(character);

        // if the character is valid, return its index
	if (c >= 0)
            return c;

        // if the character was not valid, try looking for its opposite-case counterpart
	if (Character.isLowerCase(character))
            return FontManager.CHARSET.indexOf(Character.toUpperCase(character));

	if (Character.isUpperCase(character))
            return FontManager.CHARSET.indexOf(Character.toLowerCase(character));
	
	// character cannot be found, give up
    	return c;
    }

    public short GetTextWidth(String text)
    {
        char f;
        int i = 0, pixLen = 0;
        int len = text.length();

        while (i < len)
        {
            f = text.charAt(i++);
            if (f >= ' ')
            {
                int c = getCharacterIndex(f);
                pixLen += FONT_WIDTHS[c<0?0:c];
            }
        }
        return (short)pixLen;
    }
}
