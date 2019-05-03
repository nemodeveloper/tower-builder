package ru.nemodev.towerbuilder.constant.texture;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TowerBlockTextureConstant
{
    public static final String BASE_BORDER_PATH = "atlas/tower_block/";

    public static final String SIMPLE_BLOCK_ATLAS = BASE_BORDER_PATH + "tower_block_simple.atlas";


    public static final Set<String> ATLAS_FOR_LOAD = new HashSet<String>(Arrays.asList(
            SIMPLE_BLOCK_ATLAS
    ));

}
