package ru.nemodev.towerbuilder.screen.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import ru.nemodev.towerbuilder.constant.GameConstant;
import ru.nemodev.towerbuilder.core.manager.GameStatus;
import ru.nemodev.towerbuilder.core.scene.Scene;
import ru.nemodev.towerbuilder.core.screen.BaseScreen;
import ru.nemodev.towerbuilder.entity.game.location.level.LevelDescription;
import ru.nemodev.towerbuilder.manager.GameManager;
import ru.nemodev.towerbuilder.scene.game.GameBackgroundScene;
import ru.nemodev.towerbuilder.scene.game.GameScene;
import ru.nemodev.towerbuilder.scene.game.GameUIScene;

/**
 * created by NemoDev on 06.05.2018 - 19:31
 */
public class GameScreen extends BaseScreen
{
    private LevelDescription levelDescription;

    private GameBackgroundScene gameBackgroundScene;
    private GameScene gameScene;
    private GameUIScene gameUIScene;

    public GameScreen(LevelDescription levelDescription)
    {
        super(new Array<Scene>());

        this.levelDescription = levelDescription;
        Batch batch = GameManager.getInstance().getSpriteBatch();

        initBackgroundScene(batch);
        initGameScene(batch);
        initGameUIScene(batch);
    }

    private void initBackgroundScene(Batch batch)
    {
        OrthographicCamera camera = new OrthographicCamera(GameConstant.METERS_X, GameConstant.METERS_Y);
        camera.setToOrtho(false, GameConstant.METERS_X, GameConstant.METERS_Y);

        gameBackgroundScene = new GameBackgroundScene(
                new ExtendViewport(
                        GameConstant.METERS_X, GameConstant.METERS_Y,
                        GameConstant.METERS_X, GameConstant.METERS_Y, camera),
                batch,
                levelDescription.getBackgroundDescription());
        addScene(gameBackgroundScene);
    }

    private void initGameScene(Batch batch)
    {
        OrthographicCamera camera = new OrthographicCamera(GameConstant.METERS_X, GameConstant.METERS_Y);
        camera.setToOrtho(false, GameConstant.METERS_X, GameConstant.METERS_Y);

        gameScene = new GameScene(
                new World(new Vector2(0.f, -10.f), false),
                new ExtendViewport(
                        GameConstant.METERS_X, GameConstant.METERS_Y,
                        GameConstant.METERS_X, GameConstant.METERS_Y, camera),
                batch,
                levelDescription);

        addScene(gameScene);
    }

    private void initGameUIScene(Batch batch)
    {
        OrthographicCamera camera = new OrthographicCamera(GameConstant.METERS_X, GameConstant.METERS_Y);
        camera.setToOrtho(false, GameConstant.METERS_X, GameConstant.METERS_Y);

        gameUIScene = new GameUIScene(new ExtendViewport(GameConstant.METERS_X, GameConstant.METERS_Y, GameConstant.METERS_X, GameConstant.METERS_Y, camera), batch,
                gameScene.getSoundEventListener());
        addScene(gameUIScene);
    }

    @Override
    protected GameStatus getGameStatus()
    {
        return GameStatus.RUNNING;
    }

}
