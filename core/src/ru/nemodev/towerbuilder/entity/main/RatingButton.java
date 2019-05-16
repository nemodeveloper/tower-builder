package ru.nemodev.towerbuilder.entity.main;

import com.badlogic.gdx.graphics.g2d.Sprite;

import ru.nemodev.towerbuilder.core.manager.system.AppServiceManager;
import ru.nemodev.towerbuilder.entity.game.ui.BaseUIButton;

public class RatingButton extends BaseUIButton
{
    public RatingButton(Sprite neutralState, Sprite pressState)
    {
        super(neutralState, pressState);
    }

    @Override
    public void handleTouchUp(float x, float y)
    {
        if (!AppServiceManager.getInstance().getPlayService().isSignedIn())
        {
            AppServiceManager.getInstance().getPlayService().signIn();
        }

        AppServiceManager.getInstance().getPlayService().showScore();
    }
}
