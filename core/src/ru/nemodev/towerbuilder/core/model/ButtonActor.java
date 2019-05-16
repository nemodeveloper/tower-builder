package ru.nemodev.towerbuilder.core.model;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

import ru.nemodev.towerbuilder.core.manager.resource.SoundManager;

import static ru.nemodev.towerbuilder.constant.SoundConstant.BTN_CLICK;

public abstract class ButtonActor extends BaseActor
{
    protected final Sprite neutralState;
    protected final Sprite touchState;

    protected Sprite currentState;

    public ButtonActor(Sprite neutralState, Sprite touchState)
    {
        this.neutralState = neutralState;
        this.touchState = touchState;

        this.currentState = neutralState;
    }

    @Override
    protected void doDraw(Batch batch, float parentAlpha)
    {
        currentState.draw(batch);
    }

    protected Sprite getTouchState()
    {
        return touchState;
    }

    protected Sprite getTouchUpState()
    {
        return neutralState;
    }

    @Override
    public boolean touchDown(float x, float y)
    {
        playTouchSound();
        currentState = getTouchState();

        return doTouchDown(x, y);
    }

    protected boolean doTouchDown(float x, float y)
    {
        return true;
    }

    @Override
    public void touchUp(float x, float y)
    {
        if (isTouch(x, y) != null)
        {
            doTouchUp(x, y);
        }

        currentState = getTouchUpState();
    }

    protected void doTouchUp(float x, float y) { }

    @Override
    public GameObject isTouch(float x, float y)
    {
        return isVisible() && neutralState.getBoundingRectangle().contains(x, y)
                ? this
                : null;
    }

    protected String getClickSoundName()
    {
        return BTN_CLICK;
    }

    protected void playTouchSound()
    {
        SoundManager.getInstance().playSound(getClickSoundName());
    }
}
