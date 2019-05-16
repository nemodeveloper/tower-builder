package ru.nemodev.towerbuilder.entity.main;

import com.badlogic.gdx.graphics.g2d.Sprite;

import ru.nemodev.towerbuilder.entity.game.ui.BaseUIButton;
import ru.nemodev.towerbuilder.manager.GameManager;

public class ExitGameButton extends BaseUIButton
{
    public ExitGameButton(Sprite neutralState, Sprite pressState)
    {
        super(neutralState, pressState);
    }

    @Override
    public void handleTouchUp(float x, float y)
    {
        GameManager.getInstance().exit();
    }
}
