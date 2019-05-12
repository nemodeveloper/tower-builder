package ru.nemodev.towerbuilder.entity.game.description.pack.background;

public class BackgroundPackDescription
{
    private String staticTexture;
    private String animationAtlas;

    public BackgroundPackDescription()
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
