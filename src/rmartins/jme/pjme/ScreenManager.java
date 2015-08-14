/**
 * PJME - Basic J2ME Game Project
 * @author: Rafael Martins <rafaalemao13@gmail.com>
 * @author: Diogo Autilio <diautilio@gmail.com>
 * ScreenManager.java
 */
package rmartins.jme.pjme;

public class ScreenManager
{
    IScreen mCurrentScreen;
    
    private boolean activeScreen = false;
    
    public static final int SPLASH_SCREEN = 0;
    public static final int TITLE_SCREEN = 1;
    public static final int MAINMENU_SCREEN = 2;
    public static final int GAMEOPTIONS_SCREEN = 3;
    public static final int STARTGAME_SCREEN = 4;
    public static final int OPTIONS_SCREEN = 5;
    public static final int HELP_SCREEN = 6;
    public static final int ABOUT_SCREEN = 7;
    public static final int EXIT_SCREEN = 8;
    public static final int LOADING_SCREEN = 9;
    public static final int PAUSE_SCREEN = 10;
    public static final int ENDING_SCREEN = 11;
    public static final int GAME_SCREEN = 12;
    public static final int CONFIRMQUIT_SCREEN = 13;
    public static final int HIGHSCORES_SCREEN = 14;
    public static final int CONFIRMSOUND_SCREEN = 15;
    public static final int TOTAL_SCREENS = 16;

    public ScreenManager()
    {
        activeScreen = false;
    }

    public boolean isActive()
    {
        return activeScreen;
    }

    public void activate(int aIndex)
    {
        if(!activeScreen)
        {
            mCurrentScreen = createScreen(aIndex);
            ILib.gScreen = aIndex;
            ILib.mNextScreen = -1;
            activeScreen = true;
        }
    }

    public void deactivate()
    {
        mCurrentScreen = null;
        activeScreen = false;
        ILib.gScreen = -1;
    }
    
    public IScreen createScreen(int aIndex)
    {
        switch(aIndex)
        {
            case SPLASH_SCREEN:         return new SplashScreen();
            case TITLE_SCREEN:          return new TitleScreen();
            case MAINMENU_SCREEN:       return new MainMenuScreen();
            case GAMEOPTIONS_SCREEN:    return new GameOptionsScreen();
            case OPTIONS_SCREEN:        return new OptionsScreen();
            case HELP_SCREEN:           return new HelpScreen();
            case ABOUT_SCREEN:          return new AboutScreen();
            case EXIT_SCREEN:           return new ExitScreen();
            case ENDING_SCREEN:         return new EndingScreen();
            case GAME_SCREEN:           return new GameScreen();
            case CONFIRMQUIT_SCREEN:    return new ConfirmQuitScreen();
            case LOADING_SCREEN:        return new LoadingScreen();
            case HIGHSCORES_SCREEN:     return new HighScoresScreen();
            case CONFIRMSOUND_SCREEN:   return new ConfirmSoundScreen();
            default:                    return null;
        }
    }
}
