package ru.nemodev.towerbuilder.entity.game.description;

import java.util.List;

import ru.nemodev.towerbuilder.entity.game.description.mode.ModeDescription;
import ru.nemodev.towerbuilder.entity.game.description.pack.LocationPackDescription;

public class GameDescription
{
    private List<ModeDescription> modeDescriptionList;
    private List<LocationPackDescription> locationPackDescriptionList;

    public GameDescription()
    { }

    public List<ModeDescription> getModeDescriptionList()
    {
        return modeDescriptionList;
    }

    public void setModeDescriptionList(List<ModeDescription> modeDescriptionList)
    {
        this.modeDescriptionList = modeDescriptionList;
    }

    public List<LocationPackDescription> getLocationPackDescriptionList()
    {
        return locationPackDescriptionList;
    }

    public void setLocationPackDescriptionList(List<LocationPackDescription> locationPackDescriptionList)
    {
        this.locationPackDescriptionList = locationPackDescriptionList;
    }
}
