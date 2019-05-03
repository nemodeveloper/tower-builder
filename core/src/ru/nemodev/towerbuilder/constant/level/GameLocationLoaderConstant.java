package ru.nemodev.towerbuilder.constant.level;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class GameLocationLoaderConstant
{
    public static final Set<String> LOCATION_FOR_LOADING = buildLocationForLoading();

    private static final String BASE_LOCATION_FILE_PATH = "location/";

    public static final String LOCATION_FOREST = BASE_LOCATION_FILE_PATH + "forest.json";

    private static Set<String> buildLocationForLoading()
    {
        Set<String> locationForLoading = new HashSet<String>(Arrays.asList(
                LOCATION_FOREST
        ));

        return locationForLoading;
    }

}
