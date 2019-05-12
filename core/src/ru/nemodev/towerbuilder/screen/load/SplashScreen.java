package ru.nemodev.towerbuilder.screen.load;

import com.badlogic.gdx.graphics.g2d.Sprite;

import ru.nemodev.towerbuilder.constant.SoundConstant;
import ru.nemodev.towerbuilder.constant.level.GameLoaderConstant;
import ru.nemodev.towerbuilder.constant.texture.AtlasLoaderConstant;
import ru.nemodev.towerbuilder.constant.texture.BackgroundTextureConstant;
import ru.nemodev.towerbuilder.core.manager.resource.FontManager;
import ru.nemodev.towerbuilder.core.manager.resource.PhysicManager;
import ru.nemodev.towerbuilder.core.manager.resource.ResourceLoader;
import ru.nemodev.towerbuilder.core.scene.BaseScene;
import ru.nemodev.towerbuilder.core.screen.BaseLoaderScreen;
import ru.nemodev.towerbuilder.core.util.SpriteUtils;
import ru.nemodev.towerbuilder.entity.load.SplashActor;
import ru.nemodev.towerbuilder.manager.GameBuilderManager;
import ru.nemodev.towerbuilder.manager.GameManager;
import ru.nemodev.towerbuilder.screen.main.MainScreen;

import static ru.nemodev.towerbuilder.constant.GameConstant.HALF_X;
import static ru.nemodev.towerbuilder.constant.GameConstant.HALF_Y;
import static ru.nemodev.towerbuilder.constant.GameConstant.METERS_X;
import static ru.nemodev.towerbuilder.constant.GameConstant.METERS_Y;

public class SplashScreen extends BaseLoaderScreen
{
    private final Sprite splashActor;

    public SplashScreen()
    {
        super();

        BaseScene baseScene = new BaseScene(GameManager.getInstance().getSpriteBatch());
        splashActor = SpriteUtils.create(BackgroundTextureConstant.SPLASH, METERS_X, METERS_Y, HALF_X, HALF_Y);
        baseScene.addGameObject(new SplashActor(splashActor));

        addScene(baseScene);
    }

    @Override
    protected void loadResources()
    {
        loadTexture();
        loadSound();
        loadPhysic();
        loadGameLocation();

        FontManager.getInstance();
    }

    private void loadTexture()
    {
        ResourceLoader.getInstance().loadAtlas(AtlasLoaderConstant.ATLAS_BODY_FOR_LOADING);
    }

    private void loadSound()
    {
        ResourceLoader.getInstance().loadMusic(SoundConstant.MUSIC_FOR_LOADING);
        ResourceLoader.getInstance().loadSound(SoundConstant.SOUND_FOR_LOADING);
    }

    private void loadPhysic()
    {
        PhysicManager.getInstance();
    }

    private void loadGameLocation()
    {
        ResourceLoader.getInstance().loadLocation(GameLoaderConstant.DESCRIPTION_FOR_LOADING);
    }

    @Override
    protected void doAfterLoadResource()
    {
        PhysicManager.getInstance().preparePhysicBodies();
        GameBuilderManager.getInstance().prepareLocations();

        GameManager.getInstance().getScreenManager().popScreen();
        GameManager.getInstance().getScreenManager().pushScreen(new MainScreen());
    }

    @Override
    public void dispose()
    {
        super.dispose();
        splashActor.getTexture().dispose();
    }
}
