package ru.nemodev.towerbuilder.entity.game.tower;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;

import net.dermetfan.gdx.graphics.g2d.Box2DSprite;

import ru.nemodev.towerbuilder.constant.GameConstant;
import ru.nemodev.towerbuilder.core.model.Box2dActor;
import ru.nemodev.towerbuilder.core.util.Box2dObjectBuilder;
import ru.nemodev.towerbuilder.entity.game.ConstantBox2dBodyType;

public class TowerBlockMove extends Box2dActor
{
    private final TowerManager towerManager;
    private final Box2DSprite blockSpite;
    private final Fixture blockFixture;

    public TowerBlockMove(World world, TowerManager towerManager, Box2DSprite blockSpite, Fixture blockFixture)
    {
        super(world);
        this.towerManager = towerManager;
        this.blockSpite = blockSpite;
        this.blockFixture = blockFixture;
    }

    @Override
    protected void doAct(float delta)
    {
        float size = 0.5f;
        Vector2 position = blockFixture.getBody().getPosition();

        if (position.x + 0.2f >= GameConstant.METERS_X - size || position.x - 0.2f <= size)
        {
            blockFixture.getBody().setLinearVelocity(blockFixture.getBody().getLinearVelocity().x * -1.f, 0.f);
        }
    }

    @Override
    protected void doDraw(Batch batch, float parentAlpha)
    {
        drawSprite(batch, blockSpite, blockFixture);
    }

    @Override
    public void remove()
    {
        world.destroyBody(blockFixture.getBody());
        super.remove();
    }

    public TowerBlock dropBlock()
    {
        setVisible(false);
        setNeedRemove(true);

        Fixture towerBlockFixture = Box2dObjectBuilder.createBoxFixture(world, ConstantBox2dBodyType.SIMPLE_TOWER_BLOCK,
                blockFixture.getBody().getPosition(),  1.f, 1.f);

        TowerBlock towerBlock = new TowerBlock(world, blockSpite, towerBlockFixture);
        towerManager.addGameObject(towerBlock);

        return towerBlock;
    }

}
