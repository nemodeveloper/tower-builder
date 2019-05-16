package ru.nemodev.towerbuilder.screen.main;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Array;

import java.util.List;

import ru.nemodev.towerbuilder.core.manager.GameStatus;
import ru.nemodev.towerbuilder.core.scene.Scene;
import ru.nemodev.towerbuilder.core.screen.BaseScreen;
import ru.nemodev.towerbuilder.entity.game.description.location.LocationPackDescription;
import ru.nemodev.towerbuilder.manager.GameBuilderManager;
import ru.nemodev.towerbuilder.manager.GameManager;
import ru.nemodev.towerbuilder.scene.main.MainMenuScene;
import ru.nemodev.towerbuilder.scene.main.SelectLocationScene;

/**
 * created by NemoDev on 06.05.2018 - 19:30
 */
public class MainScreen extends BaseScreen
{
    public MainScreen()
    {
        super(new Array<Scene>());

        Batch batch = GameManager.getInstance().getSpriteBatch();

        initSelectLocationScene(batch);
        initMenuScene(batch);
    }

    @Override
    protected GameStatus getGameStatus()
    {
        return GameStatus.READY;
    }

    private void initMenuScene(Batch batch)
    {
        MainMenuScene mainMenuScene = new MainMenuScene(batch);

        addScene(mainMenuScene);
    }

    private void initSelectLocationScene(Batch batch)
    {
        List<LocationPackDescription> locationPackDescriptionList = GameBuilderManager.getInstance().getLocationPackDescriptionList();
        SelectLocationScene selectLocationScene = new SelectLocationScene(batch, locationPackDescriptionList);

        addScene(selectLocationScene);
    }

    @Override
    public void dispose()
    {
        super.dispose();
    }
}
