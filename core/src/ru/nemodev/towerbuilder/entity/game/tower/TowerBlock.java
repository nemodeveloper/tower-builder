package ru.nemodev.towerbuilder.entity.game.tower;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;

import net.dermetfan.gdx.graphics.g2d.Box2DSprite;

import ru.nemodev.towerbuilder.core.model.Box2dActor;
import ru.nemodev.towerbuilder.core.physic.collision.Contactable;
import ru.nemodev.towerbuilder.entity.game.border.GroundActor;

public class TowerBlock extends Box2dActor
{
    private final Box2DSprite blockSpite;
    private final Fixture blockFixture;

    private boolean onTower;

    public TowerBlock(World world, Box2DSprite blockSpite, Fixture blockFixture)
    {
        super(world);
        this.blockSpite = blockSpite;
        this.blockFixture = blockFixture;
        this.blockFixture.setUserData(this);
        this.onTower = false;
    }

    public Vector2 getPosition()
    {
        return blockFixture.getBody().getPosition();
    }

    public boolean isOnTower()
    {
        return onTower;
    }

    public boolean isNotMoveByY()
    {
        return Math.abs(blockFixture.getBody().getLinearVelocity().y) < 0.3f;
    }

    @Override
    public void beginContact(Contactable contactable)
    {
        if (contactable instanceof TowerBlock || contactable instanceof GroundActor)
        {
            onTower = true;
        }
    }

    @Override
    public void endContact(Contactable contactable)
    {
        if (contactable instanceof TowerBlock || contactable instanceof GroundActor)
        {
            onTower = false;
        }
    }

    @Override
    protected void doDraw(Batch batch, float parentAlpha)
    {
        drawSprite(batch, blockSpite, blockFixture);
    }

    @Override
    protected void doAct(float delta)
    {
        if (blockFixture.getBody().getPosition().y < 0)
        {
            remove();
        }
    }

    @Override
    public void remove()
    {
        world.destroyBody(blockFixture.getBody());
        super.remove();
    }
}


