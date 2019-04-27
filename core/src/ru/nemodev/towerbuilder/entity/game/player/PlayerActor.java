package ru.nemodev.towerbuilder.entity.game.player;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;

import net.dermetfan.gdx.graphics.g2d.Box2DSprite;

import java.util.concurrent.atomic.AtomicBoolean;

import ru.nemodev.towerbuilder.constant.texture.BorderTextureConstant;
import ru.nemodev.towerbuilder.core.model.Box2dActor;
import ru.nemodev.towerbuilder.core.model.GameObject;
import ru.nemodev.towerbuilder.core.util.Box2dObjectBuilder;
import ru.nemodev.towerbuilder.core.util.SpriteUtils;
import ru.nemodev.towerbuilder.entity.game.ConstantBox2dBodyType;
import ru.nemodev.towerbuilder.entity.game.tower.TowerBlock;

public class PlayerActor extends Box2dActor
{
    private volatile AtomicBoolean isLock;

    private float spawnPosX;
    private float spawnPosY;

    public PlayerActor(World world)
    {
        super(world);
        this.isLock = new AtomicBoolean(false);
    }

    @Override
    public GameObject isTouch(float x, float y)
    {
        return this;
    }

    @Override
    public synchronized boolean touchDown(float x, float y)
    {
        if (isLock.get())
            return false;

        isLock.set(true);
        spawnPosX = x;
        spawnPosY = y;

        return true;
    }

    @Override
    protected void doAct(float delta)
    {
        if (isLock.get())
        {
            spawnTowerBlock(spawnPosX, spawnPosY);
            isLock.set(false);
        }
    }

    private void spawnTowerBlock(float x, float y)
    {
        Fixture towerBlockFixture = Box2dObjectBuilder.createBoxFixture(world, ConstantBox2dBodyType.SIMPLE_TOWER_BLOCK,
                new Vector2(x, y),  1.f, 1.f);
        Body towerBlockBody = towerBlockFixture.getBody();

        Box2DSprite towerBlockSprite = SpriteUtils.createBox2d(BorderTextureConstant.GROUND_ATLAS, BorderTextureConstant.GROUND);

        TowerBlock towerBlock = new TowerBlock(world, towerBlockSprite, towerBlockFixture);
        addGameObject(towerBlock);
    }
}
