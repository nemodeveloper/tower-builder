package ru.nemodev.towerbuilder.core.manager.resource.game;

import com.badlogic.gdx.files.FileHandle;
import com.fasterxml.jackson.databind.ObjectMapper;

import ru.nemodev.towerbuilder.entity.game.location.LocationDescription;

public class GameLocationParser
{
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private LocationDescription locationDescription;

    public GameLocationParser(FileHandle file)
    {
        try
        {
            locationDescription = objectMapper.readValue(file.readString(), LocationDescription.class);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public LocationDescription getLocationDescription()
    {
        return locationDescription;
    }
}
