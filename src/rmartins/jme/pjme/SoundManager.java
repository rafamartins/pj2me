/**
 * PJME - Basic J2ME Game Project
 * @author: Rafael Martins <rafaalemao13@gmail.com>
 * @author: Diogo Autilio <diautilio@gmail.com>
 * SoundManager.java
 */
package rmartins.jme.pjme;

import java.io.InputStream;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;

public class SoundManager
{
    Player soundPlayer;
    InputStream soundInputStream;

    private String[] soundNames=
    {
        "/menusound.mid",
        "/effectsound.mid"
    };

    private int numSounds = 2;
    public static int SOUND_MENU = 0;
    public static int SOUND_EFFECT = 1;

    public void playSound(int sound)
    {
        try
        {
            soundInputStream = getClass().getResourceAsStream(soundNames[sound]);
            soundPlayer = Manager.createPlayer(soundInputStream, "audio/midi");
            soundPlayer.prefetch();
            soundPlayer.setLoopCount(-1);
            soundPlayer.start();
        }catch(Exception e)
        {}
    }

    public void stopSound(int sound)
    {
        try
        {
            soundPlayer.close();
        }catch(Exception e)
        {}
    }

    public void stopAllSounds()
    {
        try
        {
            soundPlayer = null;
        }catch(Exception e)
        {}
    }
}
