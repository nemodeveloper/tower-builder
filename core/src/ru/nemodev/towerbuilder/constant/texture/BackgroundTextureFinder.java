package ru.nemodev.towerbuilder.constant.texture;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class BackgroundTextureFinder extends AtlasFinder
{
    public BackgroundTextureFinder() {}

    public static final String SPLASH = "splash.png";

    private static final String BASE_BACKGROUND_PATH = "atlas/background/";

    public static final String BACKGROUND_ATLAS = BASE_BACKGROUND_PATH + "background.atlas";
    public static final String BACKGROUND = "background";

    private static final Set<String> ATLAS_FOR_LOAD = new HashSet<String>(Arrays.asList(
            BASE_BACKGROUND_PATH
    ));

    @Override
    protected Set<String> getPathForScan()
    {
        return ATLAS_FOR_LOAD;
    }
}
