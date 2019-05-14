package ru.nemodev.towerbuilder.entity.game.description.location.block;


import ru.nemodev.towerbuilder.constant.texture.location.GameLocationTextureFinder;

public class BlockPackDescription
{
    private String locationKey;
    private boolean staticAtlas;

    public BlockPackDescription() { }

    public boolean isStaticAtlas()
    {
        return staticAtlas;
    }

    public void setStaticAtlas(boolean staticAtlas)
    {
        this.staticAtlas = staticAtlas;
    }

    public String getLocationKey()
    {
        return locationKey;
    }

    public void setLocationKey(String locationKey)
    {
        this.locationKey = locationKey;
    }

    public String getStaticBlockAtlas()
    {
        return GameLocationTextureFinder.INSTANCE.getStaticBlockLocationAtlasMap().get(locationKey);
    }
}
