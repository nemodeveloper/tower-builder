package ru.nemodev.towerbuilder.entity.game.tower;

import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import ru.nemodev.towerbuilder.core.model.Box2dActor;
import ru.nemodev.towerbuilder.core.model.GameObject;


public class TowerManager extends Box2dActor
{
    public interface TowerEventListener
    {
        void maxHeightChange(TowerBlock towerBlock);
    }

    private TowerEventListener towerEventListener;
    private TowerBlock curHeightBlock;
    private boolean heightBlockChange;

    public TowerManager(World world)
    {
        super(world);
        this.heightBlockChange = false;
    }

    @Override
    protected void doAct(float delta)
    {
        TowerBlock heightBlock = getHeightBlock();

        // получаем самый высокий блок
        if (heightBlock != null)
        {
            if ((curHeightBlock == null || curHeightBlock.isNeedRemove())
                    || heightBlock.getPosition().y > curHeightBlock.getPosition().y)
            {
                if (curHeightBlock != heightBlock)
                {
                    curHeightBlock = heightBlock;
                    heightBlockChange = true;
                }
            }
        }

        if (heightBlockChange && curHeightBlock != null && !curHeightBlock.isNeedRemove())
        {
            heightBlockChange = false;
            towerEventListener.maxHeightChange(curHeightBlock);
        }
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
            for (GameObject gameObject : new Array.ArrayIterator<GameObject>(childrenList))
            {
                TowerBlock towerBlock = (TowerBlock) gameObject;
                if (towerBlock.isOnTower()
                        && towerBlock.isNotMove()
                        && !towerBlock.isNeedRemove()
                        && towerBlock.getPosition().y > max)
                {
                    max = towerBlock.getPosition().y;
                    maxHeightBlock = towerBlock;
                }
            }

            return maxHeightBlock;
        }

        return null;
    }

    public void setTowerEventListener(TowerEventListener towerEventListener)
    {
        this.towerEventListener = towerEventListener;
    }
}
