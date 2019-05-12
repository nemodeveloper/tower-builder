package ru.nemodev.towerbuilder.scene.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

import ru.nemodev.towerbuilder.constant.GameConstant;
import ru.nemodev.towerbuilder.constant.texture.BackgroundTextureConstant;
import ru.nemodev.towerbuilder.core.scene.BaseScene;
import ru.nemodev.towerbuilder.core.util.SpriteUtils;
import ru.nemodev.towerbuilder.entity.game.background.GameBackgroundActor;
import ru.nemodev.towerbuilder.entity.game.description.pack.background.BackgroundPackDescription;
import ru.nemodev.towerbuilder.manager.GameManager;

public class GameBackgroundScene extends BaseScene
{
    private BackgroundPackDescription backgroundPackDescription;
    private GameBackgroundActor gameBackgroundActor;

    public GameBackgroundScene(Batch batch, BackgroundPackDescription backgroundPackDescription)
    {
        super(batch);
        this.backgroundPackDescription = backgroundPackDescription;

        init();
    }

    private void init()
    {
        Sprite backgroundSprite = SpriteUtils.create(
                BackgroundTextureConstant.BACKGROUND_ATLAS, backgroundPackDescription.getStaticTexture(),
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
