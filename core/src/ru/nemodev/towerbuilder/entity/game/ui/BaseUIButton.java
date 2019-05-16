package ru.nemodev.towerbuilder.entity.game.ui;

import com.badlogic.gdx.graphics.g2d.Sprite;

import ru.nemodev.towerbuilder.core.manager.resource.SoundManager;
import ru.nemodev.towerbuilder.core.model.ButtonActor;

import static ru.nemodev.towerbuilder.constant.SoundConstant.BTN_CLICK;

public abstract class BaseUIButton extends ButtonActor
{
    public BaseUIButton(Sprite neutralState, Sprite touchState)
    {
        super(neutralState, touchState);
    }

    @Override
    protected void doTouchUp(float x, float y)
    {
        SoundManager.getInstance().playSound(getClickSoundName());
        handleTouchUp(x,y);
    }

    public abstract void handleTouchUp(float x, float y);

    protected String getClickSoundName()
    {
        return BTN_CLICK;
    }
}
