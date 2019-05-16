package ru.nemodev.towerbuilder.entity.main;

import com.badlogic.gdx.graphics.g2d.Sprite;

import ru.nemodev.towerbuilder.core.util.InputUtils;
import ru.nemodev.towerbuilder.entity.game.description.mode.ModeType;
import ru.nemodev.towerbuilder.entity.game.ui.BaseUIButton;
import ru.nemodev.towerbuilder.manager.GameBuilderManager;
import ru.nemodev.towerbuilder.manager.GameManager;
import ru.nemodev.towerbuilder.screen.game.GameScreen;

public class StartGameButton extends BaseUIButton
{
    public StartGameButton(Sprite neutralState, Sprite pressState)
    {
        super(neutralState, pressState);
    }

    @Override
    public void handleTouchUp(float x, float y)
    {
        InputUtils.vibrate(250);

        GameManager.getInstance().getScreenManager().popScreen();
        GameManager.getInstance().getScreenManager().pushScreen(
                new GameScreen(
                        GameBuilderManager.getInstance().getModeDescription(ModeType.count),
                        GameBuilderManager.getInstance().getSelectedLocationPackDescription()));
    }
}
