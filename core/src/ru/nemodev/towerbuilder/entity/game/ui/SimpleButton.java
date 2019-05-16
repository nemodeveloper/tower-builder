package ru.nemodev.towerbuilder.entity.game.ui;

import com.badlogic.gdx.graphics.g2d.Sprite;

import ru.nemodev.towerbuilder.core.model.TouchListener;

public class SimpleButton extends BaseUIButton
{
    private TouchListener touchListener;

    public SimpleButton(Sprite neutralState, Sprite touchState, TouchListener touchListener)
    {
        super(neutralState, touchState);
        this.touchListener = touchListener;
    }

    @Override
    public void handleTouchUp(float x, float y)
    {
        touchListener.handleTouch();
    }
}
