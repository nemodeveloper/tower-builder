package ru.nemodev.towerbuilder.scene.game;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.Viewport;

import net.dermetfan.gdx.graphics.g2d.Box2DSprite;

import ru.nemodev.towerbuilder.constant.texture.BorderTextureConstant;
import ru.nemodev.towerbuilder.core.listener.SoundEventListener;
import ru.nemodev.towerbuilder.core.manager.resource.SoundManager;
import ru.nemodev.towerbuilder.core.manager.system.ConfigManager;
import ru.nemodev.towerbuilder.core.scene.Box2dScene;
import ru.nemodev.towerbuilder.core.util.Box2dObjectBuilder;
import ru.nemodev.towerbuilder.core.util.SpriteUtils;
import ru.nemodev.towerbuilder.entity.game.ConstantBox2dBodyType;
import ru.nemodev.towerbuilder.entity.game.border.GroundActor;
import ru.nemodev.towerbuilder.entity.game.location.level.LevelDescription;
import ru.nemodev.towerbuilder.entity.game.player.PlayerActor;
import ru.nemodev.towerbuilder.entity.game.tower.TowerBlockGenerator;
import ru.nemodev.towerbuilder.entity.game.tower.TowerManager;
import ru.nemodev.towerbuilder.manager.GameManager;


/**
 * created by NemoDev on 06.05.2018 - 21:39
 */
public class GameScene extends Box2dScene
{
    private LevelDescription levelDescription;

    private Music musicBackground;
    private GroundActor groundActor;

    private TowerManager towerManager;
    private TowerBlockGenerator towerBlockGenerator;

    private PlayerActor playerActor;

    public GameScene(World world, Viewport viewport, Batch batch, LevelDescription levelDescription)
    {
        super(world, viewport, batch);
        this.levelDescription = levelDescription;

        init();
    }

    private void init()
    {
        initTowerComponent();
        initPlayer();
        initBorder();

        musicBackground = SoundManager.getInstance().getMusic(levelDescription.getMainMusic(), true);
        if (ConfigManager.getInstance().isEnableSound())
        {
            musicBackground.play();
        }
    }

    private void initTowerComponent()
    {
        towerManager = new TowerManager(world);
        addGameObject(towerManager);

        towerBlockGenerator = new TowerBlockGenerator(world, towerManager, levelDescription.getMoveBlockDescription());
    }

    private void initPlayer()
    {
        playerActor = new PlayerActor(world, towerBlockGenerator);

        addGameObject(playerActor);
    }

    private void initBorder()
    {
        Fixture groundFixture = Box2dObjectBuilder.createBoxFixture(
                world, ConstantBox2dBodyType.GROUND,
                levelDescription.getGroundDescription().getPosition(),
                levelDescription.getGroundDescription().getWidth(), levelDescription.getGroundDescription().getHeight());
        Body groundBody = groundFixture.getBody();
        groundBody.setFixedRotation(true);

        Box2DSprite groundSprite = SpriteUtils.createBox2d(
                BorderTextureConstant.GROUND_ATLAS,
                levelDescription.getGroundDescription().getTexture());

        groundActor = new GroundActor(world, groundSprite, groundFixture);

        addGameObject(groundActor);
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
