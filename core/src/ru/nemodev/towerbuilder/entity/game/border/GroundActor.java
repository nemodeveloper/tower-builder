package ru.nemodev.towerbuilder.entity.game.border;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;

import net.dermetfan.gdx.graphics.g2d.Box2DSprite;

import ru.nemodev.towerbuilder.core.model.Box2dActor;

public class GroundActor extends Box2dActor
{
    private final Box2DSprite groundSprite;
    private final Fixture ground;

    public GroundActor(World world, Box2DSprite groundSprite, Fixture ground)
    {
        super(world);
        this.groundSprite = groundSprite;
        this.ground = ground;
    }

    @Override
    protected void doDraw(Batch batch, float parentAlpha)
    {
        drawSprite(batch, groundSprite, ground);
    }
}
