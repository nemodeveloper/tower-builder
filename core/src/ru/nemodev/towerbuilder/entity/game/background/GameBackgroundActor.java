package ru.nemodev.towerbuilder.entity.game.background;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

import ru.nemodev.towerbuilder.core.model.BaseStaticActor;

public class GameBackgroundActor extends BaseStaticActor
{
    private Sprite backgroundSprite;

    public GameBackgroundActor(Sprite backgroundSprite)
    {
        this.backgroundSprite = backgroundSprite;
    }

    @Override
    protected void doDraw(Batch batch, float parentAlpha)
    {
        backgroundSprite.draw(batch, parentAlpha);
    }
}
