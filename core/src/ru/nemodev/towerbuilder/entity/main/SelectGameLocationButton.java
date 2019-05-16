package ru.nemodev.towerbuilder.entity.main;

import com.badlogic.gdx.graphics.g2d.Sprite;

import ru.nemodev.towerbuilder.core.model.ButtonActor;
import ru.nemodev.towerbuilder.core.model.TouchListener;

public class SelectGameLocationButton extends ButtonActor
{
    private TouchListener touchListener;

    public SelectGameLocationButton(Sprite neutralState, Sprite touchState, TouchListener touchListener)
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
