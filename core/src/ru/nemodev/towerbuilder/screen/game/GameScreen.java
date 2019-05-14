package ru.nemodev.towerbuilder.screen.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import ru.nemodev.towerbuilder.core.manager.GameStatus;
import ru.nemodev.towerbuilder.core.scene.Scene;
import ru.nemodev.towerbuilder.core.screen.BaseScreen;
import ru.nemodev.towerbuilder.entity.game.description.location.LocationPackDescription;
import ru.nemodev.towerbuilder.entity.game.description.mode.ModeDescription;
import ru.nemodev.towerbuilder.manager.GameManager;
import ru.nemodev.towerbuilder.scene.game.GameBackgroundScene;
import ru.nemodev.towerbuilder.scene.game.GameScene;
import ru.nemodev.towerbuilder.scene.game.GameUIScene;

/**
 * created by NemoDev on 06.05.2018 - 19:31
 */
public class GameScreen extends BaseScreen
{
    private final ModeDescription modeDescription;
    private final LocationPackDescription locationPackDescription;

    private GameBackgroundScene gameBackgroundScene;
    private GameScene gameScene;
    private GameUIScene gameUIScene;

    public GameScreen(ModeDescription modeDescription, LocationPackDescription locationPackDescription)
    {
        super(new Array<Scene>());

        this.modeDescription = modeDescription;
        this.locationPackDescription = locationPackDescription;

        Batch batch = GameManager.getInstance().getSpriteBatch();

        initBackgroundScene(batch);
        initGameScene(batch);
        initGameUIScene(batch);
    }

    private void initBackgroundScene(Batch batch)
    {
        gameBackgroundScene = new GameBackgroundScene(batch, locationPackDescription.getBackgroundPackDescription());
        addScene(gameBackgroundScene);
    }

    private void initGameScene(Batch batch)
    {
        gameScene = new GameScene(new World(new Vector2(0.f, -10.f), false),
                batch, modeDescription, locationPackDescription);

        addScene(gameScene);
    }

    private void initGameUIScene(Batch batch)
    {
        gameUIScene = new GameUIScene(batch, gameScene.getSoundEventListener());
        gameUIScene.addGameObject(gameScene.getGameScoreActor());
        addScene(gameUIScene);
    }

    @Override
    protected GameStatus getGameStatus()
    {
        return GameStatus.RUNNING;
    }

}
