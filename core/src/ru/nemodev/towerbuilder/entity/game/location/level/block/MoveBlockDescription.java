package ru.nemodev.towerbuilder.entity.game.location.level.block;

import com.badlogic.gdx.math.Vector2;

import ru.nemodev.towerbuilder.constant.texture.TowerBlockTextureConstant;

public class MoveBlockDescription
{
    private String atlasTexture;
    private Vector2 startPosition;
    private float startSize;
    private float startVelocityX;
    private PhysicDescription physicDescription;

    public MoveBlockDescription()
    { }

    public String getAtlasTexture()
    {
        return atlasTexture;
    }

    public void setAtlasTexture(String atlasTexture)
    {
        this.atlasTexture = TowerBlockTextureConstant.BASE_BORDER_PATH + atlasTexture;
    }

    public Vector2 getStartPosition()
    {
        return startPosition;
    }

    public void setStartPosition(Vector2 startPosition)
    {
        this.startPosition = startPosition;
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
