package ru.nemodev.towerbuilder.entity.game.description.mode.block;


public class MoveBlockDescription
{
    private MoveType moveType;
    private float minAngle;
    private float maxAngle;

    private float minDistanceY;
    private float startSize;
    private float startSpeed;
    private PhysicDescription physicDescription;

    public MoveBlockDescription()
    { }

    public MoveType getMoveType()
    {
        return moveType;
    }

    public void setMoveType(MoveType moveType)
    {
        this.moveType = moveType;
    }

    public float getMinAngle()
    {
        return minAngle;
    }

    public void setMinAngle(float minAngle)
    {
        this.minAngle = minAngle;
    }

    public float getMaxAngle()
    {
        return maxAngle;
    }

    public void setMaxAngle(float maxAngle)
    {
        this.maxAngle = maxAngle;
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

    public float getStartSpeed()
    {
        return startSpeed;
    }

    public void setStartSpeed(float startSpeed)
    {
        this.startSpeed = startSpeed;
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
