package ru.nemodev.towerbuilder.scene.main;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.List;

import ru.nemodev.towerbuilder.constant.texture.UITextureFinder;
import ru.nemodev.towerbuilder.core.model.ButtonActor;
import ru.nemodev.towerbuilder.core.scene.BaseScene;
import ru.nemodev.towerbuilder.core.util.SpriteUtils;
import ru.nemodev.towerbuilder.entity.game.background.GameLocationPreviewActor;
import ru.nemodev.towerbuilder.entity.game.description.location.LocationPackDescription;

import static ru.nemodev.towerbuilder.constant.GameConstant.HALF_Y;
import static ru.nemodev.towerbuilder.constant.GameConstant.METERS_X;

public class SelectLocationScene extends BaseScene
{
    private ButtonActor nextLocationBtn;
    private ButtonActor prevLocationBtn;
    private GameLocationPreviewActor gameLocationPreviewActor;
    private List<LocationPackDescription> locationPackDescriptionList;

    public SelectLocationScene(Batch batch, List<LocationPackDescription> locationPackDescriptionList)
    {
        super(batch);
        this.locationPackDescriptionList = locationPackDescriptionList;

        initScene();
    }

    private void initScene()
    {
        initLocationPreview();
        initNextLocationButton();
        initPrevLocationButton();
    }

    private void initLocationPreview()
    {
        gameLocationPreviewActor = new GameLocationPreviewActor(
                locationPackDescriptionList, 0);

        addGameObject(gameLocationPreviewActor);
    }

    private void initNextLocationButton()
    {
        float sizeX = 2.f;
        float sizeY = 2.f;

        float positionX = METERS_X - 1.f;
        float positionY = HALF_Y;

        Sprite startSprite = SpriteUtils.create(
                UITextureFinder.COMMON_UI_ATLAS, UITextureFinder.BUTTON_START,
                sizeX, sizeY, positionX, positionY);

        Sprite startSpriteTouched = SpriteUtils.create(
                UITextureFinder.COMMON_UI_ATLAS, UITextureFinder.BUTTON_START_TOUCHED,
                sizeX, sizeY, positionX, positionY);

        nextLocationBtn = new ButtonActor(startSprite, startSpriteTouched) {
            @Override
            protected void doTouchUp(float x, float y)
            {
                gameLocationPreviewActor.showNextLocation();
                if (!gameLocationPreviewActor.hasNextLocation())
                {
                    nextLocationBtn.setVisible(false);
                }
                prevLocationBtn.setVisible(true);
            }
        };
        nextLocationBtn.setVisible(gameLocationPreviewActor.hasNextLocation());

        addGameObject(nextLocationBtn);
    }

    private void initPrevLocationButton()
    {
        float sizeX = 2.f;
        float sizeY = 2.f;

        float positionX = 1.f;
        float positionY = HALF_Y;

        Sprite startSprite = SpriteUtils.create(
                UITextureFinder.COMMON_UI_ATLAS, UITextureFinder.BUTTON_START,
                sizeX, sizeY, positionX, positionY);

        startSprite.flip(true, true);

        Sprite startSpriteTouched = SpriteUtils.create(
                UITextureFinder.COMMON_UI_ATLAS, UITextureFinder.BUTTON_START_TOUCHED,
                sizeX, sizeY, positionX, positionY);

        startSpriteTouched.flip(true, true);

        prevLocationBtn = new ButtonActor(startSprite, startSpriteTouched) {
            @Override
            protected void doTouchUp(float x, float y)
            {
                gameLocationPreviewActor.showPrevLocation();
                if (!gameLocationPreviewActor.hasPrevLocation())
                {
                    prevLocationBtn.setVisible(false);
                }
                nextLocationBtn.setVisible(true);
            }
        };
        prevLocationBtn.setVisible(gameLocationPreviewActor.hasPrevLocation());

        addGameObject(prevLocationBtn);
    }

    @Override
    public boolean isInputController()
    {
        return true;
    }
}