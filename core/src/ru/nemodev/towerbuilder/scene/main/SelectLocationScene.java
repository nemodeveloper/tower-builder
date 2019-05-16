package ru.nemodev.towerbuilder.scene.main;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

import ru.nemodev.towerbuilder.constant.texture.UITextureFinder;
import ru.nemodev.towerbuilder.core.model.SimpleButtonActor;
import ru.nemodev.towerbuilder.core.model.TouchListener;
import ru.nemodev.towerbuilder.core.scene.BaseScene;
import ru.nemodev.towerbuilder.core.util.SpriteUtils;
import ru.nemodev.towerbuilder.entity.game.background.GameLocationPreviewActor;
import ru.nemodev.towerbuilder.entity.game.description.location.LocationPackDescription;

import java.util.List;

import static ru.nemodev.towerbuilder.constant.GameConstant.HALF_Y;
import static ru.nemodev.towerbuilder.constant.GameConstant.METERS_X;

public class SelectLocationScene extends BaseScene
{
    private final int maxLocationsCount;
    private int selectedLocation;
    private List<LocationPackDescription> locationPackDescriptionList;

    public SelectLocationScene(Batch batch, List<LocationPackDescription> locationPackDescriptionList)
    {
        super(batch);

        this.selectedLocation = 0;
        this.locationPackDescriptionList = locationPackDescriptionList;
        this.maxLocationsCount = locationPackDescriptionList.size() - 1;

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
        GameLocationPreviewActor gameLocationPreviewActor = new GameLocationPreviewActor(
                locationPackDescriptionList, selectedLocation);

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

        SimpleButtonActor nextLocationBtn = new SimpleButtonActor(startSprite, startSpriteTouched, new TouchListener()
        {
            @Override
            public void handleTouch()
            {
                if (selectedLocation < maxLocationsCount)
                {
                    selectedLocation++;
                }
                else
                {
                    selectedLocation = 0;
                }

                initScene();
            }
        });

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

        SimpleButtonActor prevLocationBtn = new SimpleButtonActor(startSprite, startSpriteTouched, new TouchListener()
        {
            @Override
            public void handleTouch()
            {
                if (selectedLocation != 0)
                {
                    selectedLocation--;
                }
                else
                {
                    selectedLocation = maxLocationsCount;
                }

                initScene();
            }
        });

        addGameObject(prevLocationBtn);
    }

    @Override
    public boolean isInputController()
    {
        return true;
    }
}