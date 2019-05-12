package ru.nemodev.towerbuilder.entity.game.description.pack;

import ru.nemodev.towerbuilder.constant.SoundConstant;
import ru.nemodev.towerbuilder.entity.game.description.pack.background.BackgroundPackDescription;
import ru.nemodev.towerbuilder.entity.game.description.pack.block.BlockPackDescription;
import ru.nemodev.towerbuilder.entity.game.description.pack.ground.GroundPackDescription;

public class LocationPackDescription
{
    private String name;
    private String key;
    private String previewTexture;

    private String mainMusic;

    private BackgroundPackDescription backgroundPackDescription;
    private GroundPackDescription groundPackDescription;
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

    public String getPreviewTexture()
    {
        return previewTexture;
    }

    public void setPreviewTexture(String previewTexture)
    {
        this.previewTexture = previewTexture;
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
    }

    public GroundPackDescription getGroundPackDescription()
    {
        return groundPackDescription;
    }

    public void setGroundPackDescription(GroundPackDescription groundPackDescription)
    {
        this.groundPackDescription = groundPackDescription;
    }

    public BlockPackDescription getBlockPackDescription()
    {
        return blockPackDescription;
    }

    public void setBlockPackDescription(BlockPackDescription blockPackDescription)
    {
        this.blockPackDescription = blockPackDescription;
    }
}
