package ru.nemodev.towerbuilder.core.model;


public abstract class BaseStaticActor extends BaseActor
{
    @Override
    protected boolean isNeedUpdate()
    {
        return false;
    }
}
