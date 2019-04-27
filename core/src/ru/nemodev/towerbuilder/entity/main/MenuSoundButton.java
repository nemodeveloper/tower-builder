package ru.nemodev.towerbuilder.entity.main;

import com.badlogic.gdx.graphics.g2d.Sprite;

import ru.nemodev.towerbuilder.core.listener.SoundEventListener;
import ru.nemodev.towerbuilder.core.manager.system.ConfigManager;
import ru.nemodev.towerbuilder.core.model.ButtonActor;

public class MenuSoundButton extends ButtonActor
{
    final SoundEventListener soundEventListener;

    private final Sprite soundOff;
    private final Sprite soundOffTouched;

    public MenuSoundButton(Sprite soundOn, Sprite soundOnTouched, Sprite soundOff, Sprite soundOffTouched,
                           SoundEventListener soundEventListener)
    {
        super(soundOn, soundOnTouched);

        this.soundOff = soundOff;
        this.soundOffTouched = soundOffTouched;

        this.soundEventListener = soundEventListener;

        this.currentState = ConfigManager.getInstance().isEnableSound()
                ? currentState
                : soundOff;
    }

    @Override
    protected Sprite getTouchState()
    {
        if (ConfigManager.getInstance().isEnableSound())
        {
            return super.getTouchState();
        }

        return soundOffTouched;
    }

    @Override
    protected Sprite getTouchUpState()
    {
        if (ConfigManager.getInstance().isEnableSound())
        {
            return super.getTouchUpState();
        }

        return soundOff;
    }

    @Override
    public void doTouchUp(float x, float y)
    {
        if (ConfigManager.getInstance().isEnableSound())
        {
            ConfigManager.getInstance().setEnableSound(false);
            soundEventListener.soundDisable();
        }
        else
        {
            ConfigManager.getInstance().setEnableSound(true);
            soundEventListener.soundEnable();
        }
    }
}
