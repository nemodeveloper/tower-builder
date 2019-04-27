package ru.nemodev.towerbuilder.scene.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.Viewport;
import ru.nemodev.towerbuilder.core.scene.BaseScene;
import ru.nemodev.towerbuilder.entity.game.background.BackgroundActor;
import ru.nemodev.towerbuilder.manager.GameManager;
import ru.nemodev.towerbuilder.manager.pool.PoolManager;

public class GameBackgroundScene extends BaseScene
{
    private BackgroundActor backgroundActor;

    public GameBackgroundScene(Viewport viewport, Batch batch)
    {
        super(viewport, batch);

        init();
    }

    private void init()
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

    @Override
    protected boolean isNeedUpdate()
    {
        return !GameManager.getInstance().isPause();
    }

}
