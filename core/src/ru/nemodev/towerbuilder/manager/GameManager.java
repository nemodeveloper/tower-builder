package ru.nemodev.towerbuilder.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.nemodev.towerbuilder.core.manager.GameStatus;
import ru.nemodev.towerbuilder.core.manager.ScreenManager;
import ru.nemodev.towerbuilder.core.manager.system.AppServiceManager;
import ru.nemodev.towerbuilder.core.service.AdsService;
import ru.nemodev.towerbuilder.core.util.InputUtils;
import ru.nemodev.towerbuilder.entity.game.description.mode.ModeType;
import ru.nemodev.towerbuilder.screen.game.GameScreen;

/**
 * created by NemoDev on 08.05.2018 - 20:45
 */
public final class GameManager
{
    private static volatile GameManager instance = new GameManager();

    private GameStatus gameStatus;

    private ScreenManager screenManager;
    private final Batch spriteBatch;

    private int newGameCount = 0;

    private GameManager()
    {
        spriteBatch = new SpriteBatch();
    }

    public static GameManager getInstance()
    {
        return instance;
    }

    public Batch getSpriteBatch()
    {
        return spriteBatch;
    }

    public boolean isGameOver()
    {
        return gameStatus == GameStatus.GAME_OVER;
    }

    public boolean isRunning()
    {
        return gameStatus == GameStatus.RUNNING;
    }

    public boolean isPause()
    {
        return gameStatus == GameStatus.PAUSE;
    }

    public GameStatus getGameStatus()
    {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus)
    {
        this.gameStatus = gameStatus;

        if (isGameOver())
        {
            InputUtils.setInputProcessor(new InputAdapter()
            {
                boolean isStartNewGame = false;

                @Override
                public boolean touchDown(int screenX, int screenY, int pointer, int button)
                {
                    return true;
                }

                @Override
                public boolean touchUp(int screenX, int screenY, int pointer, int button)
                {
                    if (!isStartNewGame)
                    {
                        isStartNewGame = true;
                        ++newGameCount;

                        if (newGameCount == 2)
                        {
                            newGameCount = 0;
                            AppServiceManager.getInstance().getAdsService().showFullScreenBanner(new AdsService.AdsListener()
                            {
                                @Override
                                public void adsShowed(boolean showed)
                                {

                                }
                            });
                        }

                        getScreenManager().popScreen();
                        getScreenManager().pushScreen(
                                new GameScreen(
                                        GameBuilderManager.getInstance().getModeDescription(ModeType.count),
                                        GameBuilderManager.getInstance().getLocationPackDescription("ice")));
                    }
                    return true;
                }
            });
        }
    }

    public void setScreenManager(ScreenManager screenManager)
    {
        this.screenManager = screenManager;
    }

    public ScreenManager getScreenManager()
    {
        return screenManager;
    }

    public void exit()
    {
        Gdx.app.exit();
        System.exit(0);
    }

}
