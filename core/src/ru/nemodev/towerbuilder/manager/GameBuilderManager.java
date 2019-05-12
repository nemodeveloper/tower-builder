package ru.nemodev.towerbuilder.manager;

import java.util.HashMap;
import java.util.Map;

import ru.nemodev.towerbuilder.constant.level.GameLoaderConstant;
import ru.nemodev.towerbuilder.core.manager.resource.ResourceLoader;
import ru.nemodev.towerbuilder.entity.game.description.GameDescription;
import ru.nemodev.towerbuilder.entity.game.description.mode.ModeDescription;
import ru.nemodev.towerbuilder.entity.game.description.mode.ModeType;
import ru.nemodev.towerbuilder.entity.game.description.pack.LocationPackDescription;

public class GameBuilderManager
{
    private static volatile GameBuilderManager instance = new GameBuilderManager();

    private final Map<ModeType, ModeDescription> modeDescriptionMap;
    private final Map<String, LocationPackDescription> locationPackDescriptionMap;

    public GameBuilderManager()
    {
        this.modeDescriptionMap = new HashMap<ModeType, ModeDescription>();
        this.locationPackDescriptionMap = new HashMap<String, LocationPackDescription>();
    }

    public static GameBuilderManager getInstance()
    {
        return instance;
    }

    public void prepareLocations()
    {
        GameDescription gameDescription = ResourceLoader.getInstance().getGameLocationParser(GameLoaderConstant.GAME_DESCRIPTION).getGameDescription();

        for (ModeDescription modeDescription : gameDescription.getModeDescriptionList())
        {
            modeDescriptionMap.put(modeDescription.getModeType(), modeDescription);
        }

        for (LocationPackDescription locationPackDescription : gameDescription.getLocationPackDescriptionList())
        {
            locationPackDescriptionMap.put(locationPackDescription.getKey(), locationPackDescription);
        }
    }

    public ModeDescription getModeDescription(ModeType modeType)
    {
        return modeDescriptionMap.get(modeType);
    }

    public LocationPackDescription getLocationPackDescription(String locationKey)
    {
        return locationPackDescriptionMap.get(locationKey);
    }

}
