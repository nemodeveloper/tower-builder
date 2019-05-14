package ru.nemodev.towerbuilder.entity.game.description.location.background;

import ru.nemodev.towerbuilder.constant.texture.location.GameLocationTextureFinder;

public class BackgroundPackDescription
{
    private String locationKey;
    private boolean staticTexture;

    public BackgroundPackDescription()
    { }

    public boolean isStaticTexture()
    {
        return staticTexture;
    }

    public void setStaticTexture(boolean staticTexture)
    {
        this.staticTexture = staticTexture;
    }

    public String getLocationKey()
    {
        return locationKey;
    }

    public void setLocationKey(String locationKey)
    {
        this.locationKey = locationKey;
    }

    public String getStaticBackgorundAtlas()
    {
        return GameLocationTextureFinder.INSTANCE.getStaticBackgroundLocationAtlasMap().get(locationKey);
    }
}
