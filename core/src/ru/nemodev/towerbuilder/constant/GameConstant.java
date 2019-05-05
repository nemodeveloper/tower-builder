package ru.nemodev.towerbuilder.constant;


import ru.nemodev.towerbuilder.core.util.ScreenUtils;

public final class GameConstant
{
    private GameConstant() { }

    public static final float METERS_X = 9.f;
    public static final float METERS_Y = ScreenUtils.getHeight() / ScreenUtils.getWidth() * METERS_X;

    public static final float CENTRE_X = METERS_X / 2.f;
    public static final float CENTRE_Y = METERS_Y / 2.f;

    public static final float WORLD_UNIT = 1.f;

}
