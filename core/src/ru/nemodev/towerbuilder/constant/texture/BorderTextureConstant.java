package ru.nemodev.towerbuilder.constant.texture;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BorderTextureConstant
{
    public static final String BASE_BORDER_PATH = "atlas/border/";

    public static final String GROUND_ATLAS = BASE_BORDER_PATH + "ground.atlas";


    public static final Set<String> ATLAS_FOR_LOAD = new HashSet<String>(Arrays.asList(
            GROUND_ATLAS
    ));

}
