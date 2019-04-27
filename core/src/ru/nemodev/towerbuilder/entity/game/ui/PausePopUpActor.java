package ru.nemodev.towerbuilder.entity.game.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

import ru.nemodev.towerbuilder.core.model.BaseActor;

public class PausePopUpActor extends BaseActor
{
    private final Sprite backgroundSprite;

    public PausePopUpActor(Sprite backgroundSprite)
    {
        super();
        this.backgroundSprite = backgroundSprite;
        setVisible(false);
    }

    @Override
    protected void doDraw(Batch batch, float parentAlpha)
    {
        backgroundSprite.draw(batch);
    }
}
