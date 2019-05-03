package ru.nemodev.towerbuilder.entity.game.location.level.ground;

import com.badlogic.gdx.math.Vector2;

public class GroundDescription
{
    private String type;
    private String texture;
    private Vector2 position;
    private float width;
    private float height;

    public GroundDescription()
    { }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getTexture()
    {
        return texture;
    }

    public void setTexture(String texture)
    {
        this.texture = texture;
    }

    public Vector2 getPosition()
    {
        return position;
    }

    public void setPosition(Vector2 position)
    {
        this.position = position;
    }

    public float getWidth()
    {
        return width;
    }

    public void setWidth(float width)
    {
        this.width = width;
    }

    public float getHeight()
    {
        return height;
    }

    public void setHeight(float height)
    {
        this.height = height;
    }
}
