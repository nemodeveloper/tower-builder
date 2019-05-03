package ru.nemodev.towerbuilder.core.model;


public abstract class BaseStaticActor extends BaseActor
{
    @Override
    protected boolean isNeedUpdate()
    {
        return false;
    }

    @Override
    public GameObject isTouch(float x, float y)
    {
        return null;
    }
}
