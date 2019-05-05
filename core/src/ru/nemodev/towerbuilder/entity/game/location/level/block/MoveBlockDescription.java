package ru.nemodev.towerbuilder.entity.game.location.level.block;

import java.util.List;

import ru.nemodev.towerbuilder.constant.texture.TowerBlockTextureConstant;

public class MoveBlockDescription
{
    private String staticBlockAtlas;
    private List<String> animationBlockAtlas;
    private MoveType moveType;

    private float minDistanceY;
    private float startSize;
    private float startVelocityX;
    private PhysicDescription physicDescription;

    public MoveBlockDescription()
    { }

    public String getStaticBlockAtlas()
    {
        return staticBlockAtlas;
    }

    public void setStaticBlockAtlas(String staticBlockAtlas)
    {
        this.staticBlockAtlas = TowerBlockTextureConstant.BASE_BORDER_PATH + staticBlockAtlas;
    }

    public List<String> getAnimationBlockAtlas()
    {
        return animationBlockAtlas;
    }

    public void setAnimationBlockAtlas(List<String> animationBlockAtlas)
    {
        this.animationBlockAtlas = animationBlockAtlas;
    }

    public MoveType getMoveType()
    {
        return moveType;
    }

    public void setMoveType(MoveType moveType)
    {
        this.moveType = moveType;
    }

    public float getMinDistanceY()
    {
        return minDistanceY;
    }

    public void setMinDistanceY(float minDistanceY)
    {
        this.minDistanceY = minDistanceY;
    }

    public float getStartSize()
    {
        return startSize;
    }

    public void setStartSize(float startSize)
    {
        this.startSize = startSize;
    }

    public float getStartVelocityX()
    {
        return startVelocityX;
    }

    public void setStartVelocityX(float startVelocityX)
    {
        this.startVelocityX = startVelocityX;
    }

    public PhysicDescription getPhysicDescription()
    {
        return physicDescription;
    }

    public void setPhysicDescription(PhysicDescription physicDescription)
    {
        this.physicDescription = physicDescription;
    }
}
