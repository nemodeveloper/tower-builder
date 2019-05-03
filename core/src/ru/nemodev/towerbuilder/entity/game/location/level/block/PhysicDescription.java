package ru.nemodev.towerbuilder.entity.game.location.level.block;

import com.badlogic.gdx.physics.box2d.BodyDef;

import ru.nemodev.towerbuilder.entity.game.Box2dBodyType;

public class PhysicDescription
{
    private float density;
    private float friction;
    private float restitution;

    private Box2dBodyType box2dBodyType;

    public PhysicDescription()
    { }

    public float getDensity()
    {
        return density;
    }

    public void setDensity(float density)
    {
        this.density = density;
    }

    public float getFriction()
    {
        return friction;
    }

    public void setFriction(float friction)
    {
        this.friction = friction;
    }

    public float getRestitution()
    {
        return restitution;
    }

    public void setRestitution(float restitution)
    {
        this.restitution = restitution;
    }

    public Box2dBodyType getBox2dBodyType()
    {
        if (box2dBodyType == null)
        {
            box2dBodyType = new Box2dBodyType()
            {
                @Override
                public BodyDef.BodyType getBodyType()
                {
                    return BodyDef.BodyType.DynamicBody;
                }

                @Override
                public float getDensity()
                {
                    return density;
                }

                @Override
                public float getFriction()
                {
                    return friction;
                }

                @Override
                public float getRestitution()
                {
                    return restitution;
                }
            };
        }

        return box2dBodyType;
    }
}
