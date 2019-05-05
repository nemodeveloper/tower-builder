package ru.nemodev.towerbuilder.entity.game.location.level.background;

public class BackgroundDescription
{
    private String staticTexture;
    private String animationAtlas;

    public BackgroundDescription()
    { }

    public String getStaticTexture()
    {
        return staticTexture;
    }

    public void setStaticTexture(String staticTexture)
    {
        this.staticTexture = staticTexture;
    }

    public String getAnimationAtlas()
    {
        return animationAtlas;
    }

    public void setAnimationAtlas(String animationAtlas)
    {
        this.animationAtlas = animationAtlas;
    }
}
