package ru.nemodev.towerbuilder.constant.texture;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TowerBlockTextureConstant
{
    private static final String BASE_BORDER_PATH = "atlas/tower_block/";

    public static final String SIMPLE_BLOCK_ATLAS = BASE_BORDER_PATH + "tower_block_simple.atlas";

    public static final String TYPE_1 = "ro_1";
    public static final String TYPE_2 = "ro_2";
    public static final String TYPE_3 = "tower_block_1";

    public static String[] TYPE_LIST = {TYPE_3};

    public static final Set<String> ATLAS_FOR_LOAD = new HashSet<String>(Arrays.asList(
            SIMPLE_BLOCK_ATLAS
    ));

}
