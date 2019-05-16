package ru.nemodev.towerbuilder.entity.game.description.location;

import ru.nemodev.towerbuilder.constant.SoundConstant;
import ru.nemodev.towerbuilder.constant.texture.location.GameLocationTextureFinder;
import ru.nemodev.towerbuilder.entity.game.description.location.background.BackgroundPackDescription;
import ru.nemodev.towerbuilder.entity.game.description.location.block.BlockPackDescription;

public class LocationPackDescription
{
    private String name;
    private String key;
    private Long locationCoast;

    private String mainMusic;

    private BackgroundPackDescription backgroundPackDescription;
    private BlockPackDescription blockPackDescription;

    public LocationPackDescription() { }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public Long getLocationCoast()
    {
        return locationCoast;
    }

    public void setLocationCoast(Long locationCoast)
    {
        this.locationCoast = locationCoast;
    }

    public String getMainMusic()
    {
        return mainMusic;
    }

    public void setMainMusic(String mainMusic)
    {
        this.mainMusic = SoundConstant.BASE_SOUND_PATH + mainMusic;
    }

    public BackgroundPackDescription getBackgroundPackDescription()
    {
        return backgroundPackDescription;
    }

    public void setBackgroundPackDescription(BackgroundPackDescription backgroundPackDescription)
    {
        this.backgroundPackDescription = backgroundPackDescription;
        this.backgroundPackDescription.setLocationKey(key);
    }

    public BlockPackDescription getBlockPackDescription()
    {
        return blockPackDescription;
    }

    public void setBlockPackDescription(BlockPackDescription blockPackDescription)
    {
        this.blockPackDescription = blockPackDescription;
        this.blockPackDescription.setLocationKey(key);
    }

    public String getGroundAtlas()
    {
        return GameLocationTextureFinder.INSTANCE.getGroundLocationAtlasMap().get(key);
    }

}
