package ru.nemodev.towerbuilder.constant.texture;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BorderTextureFinder extends AtlasFinder
{
    public static final String BASE_BORDER_PATH = "atlas/border/";

    public static final String GROUND_ATLAS = BASE_BORDER_PATH + "ground.atlas";

    private static final Set<String> ATLAS_FOR_LOAD = new HashSet<String>(Arrays.asList(
            BASE_BORDER_PATH
    ));

    @Override
    protected Set<String> getPathForScan()
    {
        return ATLAS_FOR_LOAD;
    }
}
