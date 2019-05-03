package ru.nemodev.towerbuilder.entity.game.tower;

import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

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

    public TowerBlock getHeightBlock()
    {
        if (hasChildren())
        {
            float max = 0;
            TowerBlock maxHeightBlock = null;
            for (GameObject gameObject: new Array.ArrayIterator<GameObject>(childrenList))
            {
                TowerBlock towerBlock = (TowerBlock) gameObject;
                if (towerBlock.getPosition().y > max)
                {
                    max = towerBlock.getPosition().y;
                    maxHeightBlock = towerBlock;
                }
            }

            return maxHeightBlock;
        }

        return null;
    }
}
