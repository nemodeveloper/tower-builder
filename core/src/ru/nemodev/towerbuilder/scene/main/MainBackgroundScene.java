package ru.nemodev.towerbuilder.scene.main;

import com.badlogic.gdx.graphics.g2d.Batch;

import com.badlogic.gdx.utils.viewport.Viewport;

import ru.nemodev.towerbuilder.core.scene.BaseScene;
import ru.nemodev.towerbuilder.entity.game.background.BackgroundActor;
import ru.nemodev.towerbuilder.manager.pool.PoolManager;


/**
 * created by NemoDev on 06.05.2018 - 21:39
 */
public class MainBackgroundScene extends BaseScene
{
    private BackgroundActor backgroundActor;

    public MainBackgroundScene(Viewport viewport, Batch batch)
    {
        super(viewport, batch);

        init();
    }

    public void init()
    {
        backgroundActor = PoolManager.getInstance().get(BackgroundActor.class);
        addGameObject(backgroundActor);
    }

    @Override
    public void dispose()
    {
        super.dispose();

        PoolManager.getInstance().free(backgroundActor);
    }

}
