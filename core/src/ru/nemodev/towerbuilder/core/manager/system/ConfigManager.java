package ru.nemodev.towerbuilder.core.manager.system;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * created by NemoDev on 08.05.2018 - 20:45
 */
public final class ConfigManager
{
    private static final String GAME_PREFERENCES_KEY = "APP_PREFERENCES";
    private static final String BEST_SCORE_KEY = "BEST_SCORE";

    private static final String SOUND_ENABLE_KEY = "SOUND_ENABLE";

    private static volatile ConfigManager instance = new ConfigManager();

    private final Preferences gamePreferences;

    private ConfigManager()
    {
        gamePreferences = Gdx.app.getPreferences(GAME_PREFERENCES_KEY);
    }

    public static ConfigManager getInstance()
    {
        return instance;
    }

    public int getBestScore()
    {
        return gamePreferences.getInteger(BEST_SCORE_KEY, 0);
    }

    public void setBestScore(int score)
    {
        if (getBestScore() < score)
        {
            gamePreferences.putInteger(BEST_SCORE_KEY, score);
            gamePreferences.flush();
            AppServiceManager.getInstance().getPlayService().submitScore(score);
        }
    }

    public void setEnableSound(boolean soundEnable)
    {
        gamePreferences.putBoolean(SOUND_ENABLE_KEY, soundEnable);
        gamePreferences.flush();
    }

    public boolean isEnableSound()
    {
        return gamePreferences.getBoolean(SOUND_ENABLE_KEY, true);
    }

}
