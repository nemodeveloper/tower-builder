package ru.nemodev.towerbuilder.constant;


import ru.nemodev.towerbuilder.core.util.ScreenUtils;

public final class GameConstant
{
    private GameConstant() { }

    public static final float METERS_X = 9.f;
    public static final float METERS_Y = ScreenUtils.getHeight() / ScreenUtils.getWidth() * METERS_X;

}
