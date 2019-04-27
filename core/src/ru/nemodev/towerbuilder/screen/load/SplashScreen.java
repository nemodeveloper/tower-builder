package ru.nemodev.towerbuilder.screen.load;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import ru.nemodev.towerbuilder.constant.SoundConstant;
import ru.nemodev.towerbuilder.constant.texture.AtlasLoaderConstant;
import ru.nemodev.towerbuilder.constant.texture.BackgroundTextureConstant;
import ru.nemodev.towerbuilder.core.manager.resource.FontManager;
import ru.nemodev.towerbuilder.core.manager.resource.PhysicManager;
import ru.nemodev.towerbuilder.core.manager.resource.ResourceLoader;
import ru.nemodev.towerbuilder.core.scene.BaseScene;
import ru.nemodev.towerbuilder.core.screen.BaseLoaderScreen;
import ru.nemodev.towerbuilder.core.util.ScreenUtils;
import ru.nemodev.towerbuilder.core.util.SpriteUtils;
import ru.nemodev.towerbuilder.manager.GameManager;
import ru.nemodev.towerbuilder.entity.load.SplashActor;
import ru.nemodev.towerbuilder.screen.main.MainScreen;

public class SplashScreen extends BaseLoaderScreen
{
    private final Sprite splashActor;

    public SplashScreen()
    {
        super();

        BaseScene baseScene = new BaseScene(new ScreenViewport(), GameManager.getInstance().getSpriteBatch());

        splashActor = SpriteUtils.create(BackgroundTextureConstant.SPLASH);
        splashActor.setSize(ScreenUtils.getWidth(), ScreenUtils.getHeight());
        splashActor.setPosition(0, 0);

        baseScene.addGameObject(new SplashActor(splashActor));

        addScene(baseScene);
    }

    @Override
    protected void loadResources()
    {
        loadTexture();
        loadSound();
        loadPhysic();

        FontManager.getInstance();
    }

    private void loadTexture()
    {
        ResourceLoader.getInstance().loadAtlas(AtlasLoaderConstant.ATLAS_BODY_FOR_LOADING);
    }

    public void loadSound()
    {
        ResourceLoader.getInstance().loadMusic(SoundConstant.MUSIC_FOR_LOADING);
        ResourceLoader.getInstance().loadSound(SoundConstant.SOUND_FOR_LOADING);
    }

    public void loadPhysic()
    {
        PhysicManager.getInstance();
    }

    @Override
    protected void doAfterLoadResource()
    {
        PhysicManager.getInstance().preparePhysicBodies();

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
