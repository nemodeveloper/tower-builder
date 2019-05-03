package ru.nemodev.towerbuilder.manager;

import java.util.HashMap;
import java.util.Map;

import ru.nemodev.towerbuilder.constant.level.GameLocationLoaderConstant;
import ru.nemodev.towerbuilder.core.manager.resource.ResourceLoader;
import ru.nemodev.towerbuilder.entity.game.location.LocationDescription;
import ru.nemodev.towerbuilder.entity.game.location.level.LevelDescription;

public class GameLocationManager
{
    private static volatile GameLocationManager instance = new GameLocationManager();

    private Map<Integer, LocationDescription> locationDescriptionMap;

    public GameLocationManager()
    {
        this.locationDescriptionMap = new HashMap<Integer, LocationDescription>();
    }

    public static GameLocationManager getInstance()
    {
        return instance;
    }

    public void prepareLocations()
    {
        locationDescriptionMap.put(0,
                ResourceLoader.getInstance().getGameLocationParser(GameLocationLoaderConstant.LOCATION_FOREST).getLocationDescription());
    }

    public LocationDescription getLocationDescription(Integer locationNumber)
    {
        return locationDescriptionMap.get(locationNumber);
    }

    public LevelDescription getLevelDescription(Integer locationNumber, Integer levelNumber)
    {
        return locationDescriptionMap.get(locationNumber).getLevelDescriptionList().get(levelNumber);
    }

}
