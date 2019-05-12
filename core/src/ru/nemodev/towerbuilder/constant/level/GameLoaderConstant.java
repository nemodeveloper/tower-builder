package ru.nemodev.towerbuilder.constant.level;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class GameLoaderConstant
{
    public static final Set<String> DESCRIPTION_FOR_LOADING = buildDescriptionForLoading();

    private static final String BASE_LOCATION_FILE_PATH = "description/";

    public static final String GAME_DESCRIPTION = BASE_LOCATION_FILE_PATH + "game.json";

    private static Set<String> buildDescriptionForLoading()
    {
        return new HashSet<String>(Arrays.asList(
                GAME_DESCRIPTION
        ));
    }

}
