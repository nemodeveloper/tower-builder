package ru.nemodev.towerbuilder.core.manager.resource.game;

import com.badlogic.gdx.files.FileHandle;
import com.fasterxml.jackson.databind.ObjectMapper;

import ru.nemodev.towerbuilder.entity.game.description.GameDescription;

public class GameDescriptionParser
{
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private GameDescription gameDescription;

    public GameDescriptionParser(FileHandle file)
    {
        try
        {
            gameDescription = objectMapper.readValue(file.readString(), GameDescription.class);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public GameDescription getGameDescription()
    {
        return gameDescription;
    }
}
