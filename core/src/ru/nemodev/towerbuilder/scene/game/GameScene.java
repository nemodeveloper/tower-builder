package ru.nemodev.towerbuilder.scene.game;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.Viewport;

import net.dermetfan.gdx.graphics.g2d.Box2DSprite;

import ru.nemodev.towerbuilder.constant.GameConstant;
import ru.nemodev.towerbuilder.constant.SoundConstant;
import ru.nemodev.towerbuilder.constant.texture.BorderTextureConstant;
import ru.nemodev.towerbuilder.core.listener.SoundEventListener;
import ru.nemodev.towerbuilder.core.manager.resource.SoundManager;
import ru.nemodev.towerbuilder.core.manager.system.ConfigManager;
import ru.nemodev.towerbuilder.core.scene.Box2dScene;
import ru.nemodev.towerbuilder.core.util.Box2dObjectBuilder;
import ru.nemodev.towerbuilder.core.util.SpriteUtils;
import ru.nemodev.towerbuilder.entity.game.ConstantBox2dBodyType;
import ru.nemodev.towerbuilder.entity.game.border.GroundActor;
import ru.nemodev.towerbuilder.entity.game.player.PlayerActor;
import ru.nemodev.towerbuilder.manager.GameManager;


/**
 * created by NemoDev on 06.05.2018 - 21:39
 */
public class GameScene extends Box2dScene
{
    private Music musicBackground;
    private GroundActor groundActor;
    private PlayerActor playerActor;

    public GameScene(World world, Viewport viewport, Batch batch)
    {
        super(world, viewport, batch);

        init();
    }

    private void init()
    {
        initPlayer();
        initBorder();

        musicBackground = SoundManager.getInstance().getMusic(SoundConstant.MAIN_THEME_MUSIC, true);
        if (ConfigManager.getInstance().isEnableSound())
        {
            musicBackground.play();
        }
    }

    private void initBorder()
    {
        Fixture groundFixture = Box2dObjectBuilder.createBoxFixture(world, ConstantBox2dBodyType.GROUND,
                new Vector2(GameConstant.METERS_X / 2.f, 0.75f),  GameConstant.METERS_X / 2.f, 1.5f);
        Body groundBody = groundFixture.getBody();
        groundBody.setFixedRotation(true);

        Box2DSprite groundSprite = SpriteUtils.createBox2d(BorderTextureConstant.GROUND_ATLAS, BorderTextureConstant.GROUND);

        groundActor = new GroundActor(world, groundSprite, groundFixture);

        addGameObject(groundActor);
    }

    private void initPlayer()
    {
        playerActor = new PlayerActor(world);

        addGameObject(playerActor);
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

        musicBackground.stop();
    }

    @Override
    protected boolean isNeedUpdate()
    {
        return !GameManager.getInstance().isPause();
    }

    public SoundEventListener getSoundEventListener()
    {
        return new SoundEventListener()
        {
            @Override
            public void soundEnable()
            {
                musicBackground.play();
            }

            @Override
            public void soundDisable()
            {
                musicBackground.stop();
            }
        };
    }
}
