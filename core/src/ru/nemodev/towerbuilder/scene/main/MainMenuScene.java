package ru.nemodev.towerbuilder.scene.main;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

import ru.nemodev.towerbuilder.constant.SoundConstant;
import ru.nemodev.towerbuilder.constant.texture.UITextureFinder;
import ru.nemodev.towerbuilder.core.listener.SoundEventListener;
import ru.nemodev.towerbuilder.core.manager.resource.SoundManager;
import ru.nemodev.towerbuilder.core.manager.system.ConfigManager;
import ru.nemodev.towerbuilder.core.scene.BaseScene;
import ru.nemodev.towerbuilder.core.util.SpriteUtils;
import ru.nemodev.towerbuilder.entity.main.ExitGameButton;
import ru.nemodev.towerbuilder.entity.main.MenuSoundButton;
import ru.nemodev.towerbuilder.entity.main.RatingButton;
import ru.nemodev.towerbuilder.entity.main.StartGameButton;

import static ru.nemodev.towerbuilder.constant.GameConstant.HALF_X;

public class MainMenuScene extends BaseScene
{
    private final float MENU_BTN_SIZE = 2.f;
    private final float MENU_BTN_POS_Y = 2.f;

    private StartGameButton startGameButton;
    private ExitGameButton exitGameButton;

    private MenuSoundButton menuSoundButton;
    private Music mainMenuMusic;

    private RatingButton ratingButton;

    public MainMenuScene(Batch batch)
    {
        super(batch);

        init();
    }

    private void init()
    {
        initStartButton();
        // TODO пока что убрал кнопку выхода
        //initExitButton();

        initMenuMusic();

        initRatingButton();
    }

    private void initStartButton()
    {
        float positionX = HALF_X;

        Sprite startSprite = SpriteUtils.create(
                UITextureFinder.COMMON_UI_ATLAS, UITextureFinder.BUTTON_START,
                MENU_BTN_SIZE, MENU_BTN_SIZE, positionX, MENU_BTN_POS_Y);

        Sprite startSpriteTouched = SpriteUtils.create(
                UITextureFinder.COMMON_UI_ATLAS, UITextureFinder.BUTTON_START_TOUCHED,
                MENU_BTN_SIZE, MENU_BTN_SIZE, positionX, MENU_BTN_POS_Y);

        startGameButton = new StartGameButton(startSprite, startSpriteTouched);

        addGameObject(startGameButton);
    }

    private void initExitButton()
    {
        float positionX = HALF_X - MENU_BTN_SIZE - 0.5f;

        Sprite exitSprite = SpriteUtils.create(
                UITextureFinder.COMMON_UI_ATLAS, UITextureFinder.BUTTON_EXIT,
                MENU_BTN_SIZE, MENU_BTN_SIZE, positionX, MENU_BTN_POS_Y);

        Sprite exitSpriteTouched = SpriteUtils.create(
                UITextureFinder.COMMON_UI_ATLAS, UITextureFinder.BUTTON_EXIT_TOUCHED,
                MENU_BTN_SIZE, MENU_BTN_SIZE, positionX, MENU_BTN_POS_Y);

        exitGameButton = new ExitGameButton(exitSprite, exitSpriteTouched);

        addGameObject(exitGameButton);
    }

    private void initMenuMusic()
    {
        mainMenuMusic = SoundManager.getInstance().getMusic(SoundConstant.MAIN_THEME_MUSIC, true);
        if (ConfigManager.getInstance().isEnableSound())
        {
            mainMenuMusic.play();
        }

        float positionX = HALF_X + MENU_BTN_SIZE + 0.5f;

        Sprite soundOnSprite = SpriteUtils.create(
                UITextureFinder.COMMON_UI_ATLAS, UITextureFinder.BUTTON_SOUND_ON,
                MENU_BTN_SIZE, MENU_BTN_SIZE, positionX, MENU_BTN_POS_Y);
        Sprite soundOnSpriteTouched = SpriteUtils.create(
                UITextureFinder.COMMON_UI_ATLAS, UITextureFinder.BUTTON_SOUND_ON_TOUCHED,
                MENU_BTN_SIZE, MENU_BTN_SIZE, positionX, MENU_BTN_POS_Y);

        Sprite soundOffSprite = SpriteUtils.create(
                UITextureFinder.COMMON_UI_ATLAS, UITextureFinder.BUTTON_SOUND_OFF,
                MENU_BTN_SIZE, MENU_BTN_SIZE, positionX, MENU_BTN_POS_Y);
        Sprite soundOffSpriteTouched = SpriteUtils.create(
                UITextureFinder.COMMON_UI_ATLAS, UITextureFinder.BUTTON_SOUND_OFF_TOUCHED,
                MENU_BTN_SIZE, MENU_BTN_SIZE, positionX, MENU_BTN_POS_Y);

        menuSoundButton = new MenuSoundButton(soundOnSprite, soundOnSpriteTouched,
                soundOffSprite, soundOffSpriteTouched,
                new SoundEventListener()
                {
                    @Override
                    public void soundEnable()
                    {
                        mainMenuMusic.play();
                    }

                    @Override
                    public void soundDisable()
                    {
                        mainMenuMusic.stop();
                    }
                });

        addGameObject(menuSoundButton);

    }

    private void initRatingButton()
    {
        float positionX = HALF_X - MENU_BTN_SIZE - 0.5f;

        Sprite ratingSprite = SpriteUtils.create(
                UITextureFinder.COMMON_UI_ATLAS, UITextureFinder.BUTTON_RATING,
                MENU_BTN_SIZE, MENU_BTN_SIZE, positionX, MENU_BTN_POS_Y);

        Sprite ratingSpriteTouched = SpriteUtils.create(
                UITextureFinder.COMMON_UI_ATLAS, UITextureFinder.BUTTON_RATING_TOUCHED,
                MENU_BTN_SIZE, MENU_BTN_SIZE, positionX, MENU_BTN_POS_Y);

        ratingButton = new RatingButton(ratingSprite, ratingSpriteTouched);

        addGameObject(ratingButton);
    }

    @Override
    public boolean isInputController()
    {
        return true;
    }

    @Override
    public void dispose()
    {
        super.dispose();
    }
}
