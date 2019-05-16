package ru.nemodev.towerbuilder.core.model;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class SimpleButtonActor extends ButtonActor
{
    private TouchListener touchListener;

    public SimpleButtonActor(Sprite neutralState, Sprite touchState, TouchListener touchListener)
    {
        super(neutralState, touchState);
        this.touchListener = touchListener;
    }

    @Override
    protected void doTouchUp(float x, float y)
    {
        touchListener.handleTouch();
    }
}
