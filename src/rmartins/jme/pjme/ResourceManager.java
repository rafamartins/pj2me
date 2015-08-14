/**
 * PJME - Basic J2ME Game Project
 * @author: Rafael Martins <rafaalemao13@gmail.com>
 * @author: Diogo Autilio <diautilio@gmail.com>
 * ResourceManager.java
 */
package rmartins.jme.pjme;

import java.io.InputStream;
import java.util.Vector;

public class ResourceManager
{
    public static final int MAXSTRING_COUNT = 50;
    
    public static final String STR_SELECT = "SELECT";
    public static final String STR_BACK = "BACK";
    public static final String STR_RESUME = "RESUME";
    public static final String STR_CANCEL = "CANCEL";
    public static final String STR_SKIP = "SKIP";
    public static final String STR_YES = "YES";
    public static final String STR_NO = "NO";
    public static final String STR_NEXT = "NEXT";
    public static final String STR_QUIT = "QUIT";

    public static final String STR_MENU = "MENU";
    public static final String STR_PAUSE = "PAUSE";
    public static final String STR_LOADING = "LOADING...";

    public static final String STR_ON = "ON";
    public static final String STR_OFF = "OFF";

    public static final String STR_SOUND = "SOUND: ";
    public static final String STR_VIBRATION = "VIBRATION: ";
    public static final String STR_LANGUAGE = "LANGUAGE";
    public static final String STR_CONFIRMSOUND = "DO YOU WANT SOUND?";

    public static final String STR_NEWGAME = "NEW GAME";
    public static final String STR_RESUMEGAME = "RESUME GAME";
    public static final String STR_OPTIONS = "OPTIONS";
    public static final String STR_HELP = "HELP";
    public static final String STR_ABOUT = "ABOUT";
    public static final String STR_EXIT = "EXIT";
    public static final String STR_QUITGAME = "QUIT GAME";
    public static final String STR_LEVELOPTIONS = "LEVEL OPTIONS";

    public static final String STR_YOUWIN = "YOU WIN";
    public static final String STR_YOULOSE = "YOU LOSE";

    public String readStringResources()
    {
        //String gameStrings[] = new String[ResourceManager.MAXSTRING_COUNT];

        InputStream is = getClass().getResourceAsStream("/text.txt");
        StringBuffer sb = new StringBuffer();
        Vector lines = new Vector();

        try
        {
            int chars, i = 0;
            while ((chars = is.read()) != -1)
            {
                //sb.append((char) chars);

                if(chars == '\n')
                {
                    lines.addElement(sb.toString());
                    sb.delete(0, sb.length());
                    //gameStrings[i] = sb.toString();
                }
                else
                {
                    sb.append((char)chars);
                }
                
                //i++;
            }

            return sb.toString();
            //return gameStrings;
        }catch (Exception e)
        {
        }

        return null;
    }
}
