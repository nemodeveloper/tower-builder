package ru.nemodev.towerbuilder.entity.main;

import com.badlogic.gdx.graphics.g2d.Sprite;

import ru.nemodev.towerbuilder.core.model.ButtonActor;
import ru.nemodev.towerbuilder.core.util.InputUtils;
import ru.nemodev.towerbuilder.entity.game.description.mode.ModeType;
import ru.nemodev.towerbuilder.manager.GameBuilderManager;
import ru.nemodev.towerbuilder.manager.GameManager;
import ru.nemodev.towerbuilder.screen.game.GameScreen;

public class StartGameButton extends ButtonActor
{
    public StartGameButton(Sprite neutralState, Sprite pressState)
    {
        super(neutralState, pressState);
    }

    @Override
    public void doTouchUp(float x, float y)
    {
        InputUtils.vibrate(250);

        GameManager.getInstance().getScreenManager().popScreen();
        GameManager.getInstance().getScreenManager().pushScreen(
                new GameScreen(
                        GameBuilderManager.getInstance().getModeDescription(ModeType.count),
                        GameBuilderManager.getInstance().getSelectedLocationPackDescription()));
    }
}
