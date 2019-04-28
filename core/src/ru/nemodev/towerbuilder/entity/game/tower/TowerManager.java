package ru.nemodev.towerbuilder.entity.game.tower;

import com.badlogic.gdx.physics.box2d.World;

import ru.nemodev.towerbuilder.core.model.Box2dActor;
import ru.nemodev.towerbuilder.core.model.GameObject;


public class TowerManager extends Box2dActor
{
    public TowerManager(World world)
    {
        super(world);
    }

    @Override
    public GameObject isTouch(float x, float y)
    {
        return null;
    }
}
