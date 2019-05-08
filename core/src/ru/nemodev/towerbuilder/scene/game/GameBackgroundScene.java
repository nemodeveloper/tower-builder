package ru.nemodev.towerbuilder.scene.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

import ru.nemodev.towerbuilder.constant.GameConstant;
import ru.nemodev.towerbuilder.constant.texture.BackgroundTextureConstant;
import ru.nemodev.towerbuilder.core.scene.BaseScene;
import ru.nemodev.towerbuilder.core.util.SpriteUtils;
import ru.nemodev.towerbuilder.entity.game.background.GameBackgroundActor;
import ru.nemodev.towerbuilder.entity.game.location.level.background.BackgroundDescription;
import ru.nemodev.towerbuilder.manager.GameManager;

public class GameBackgroundScene extends BaseScene
{
    private BackgroundDescription backgroundDescription;
    private GameBackgroundActor gameBackgroundActor;

    public GameBackgroundScene(Batch batch, BackgroundDescription backgroundDescription)
    {
        super(batch);
        this.backgroundDescription = backgroundDescription;

        init();
    }

    private void init()
    {
        Sprite backgroundSprite = SpriteUtils.create(
                BackgroundTextureConstant.BACKGROUND_ATLAS, backgroundDescription.getStaticTexture(),
                GameConstant.METERS_X, GameConstant.METERS_Y,
                GameConstant.HALF_X, GameConstant.HALF_Y);

        gameBackgroundActor = new GameBackgroundActor(backgroundSprite);
        addGameObject(gameBackgroundActor);
    }

    @Override
    protected boolean isNeedUpdate()
    {
        return !GameManager.getInstance().isPause();
    }

}
