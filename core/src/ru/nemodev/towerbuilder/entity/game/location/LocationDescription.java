package ru.nemodev.towerbuilder.entity.game.location;

import java.util.List;

import ru.nemodev.towerbuilder.entity.game.location.level.LevelDescription;

public class LocationDescription
{
    private Integer locationNumber;
    private String locationName;
    private String backgroundTexture;

    private List<LevelDescription> levelDescriptionList;

    public LocationDescription()
    { }

    public Integer getLocationNumber()
    {
        return locationNumber;
    }

    public void setLocationNumber(Integer locationNumber)
    {
        this.locationNumber = locationNumber;
    }

    public String getLocationName()
    {
        return locationName;
    }

    public void setLocationName(String locationName)
    {
        this.locationName = locationName;
    }

    public String getBackgroundTexture()
    {
        return backgroundTexture;
    }

    public void setBackgroundTexture(String backgroundTexture)
    {
        this.backgroundTexture = backgroundTexture;
    }

    public List<LevelDescription> getLevelDescriptionList()
    {
        return levelDescriptionList;
    }

    public void setLevelDescriptionList(List<LevelDescription> levelDescriptionList)
    {
        this.levelDescriptionList = levelDescriptionList;
    }
}
