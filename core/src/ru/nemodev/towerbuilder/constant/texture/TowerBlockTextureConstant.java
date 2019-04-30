package ru.nemodev.towerbuilder.constant.texture;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TowerBlockTextureConstant
{
    private static final String BASE_BORDER_PATH = "atlas/tower_block/";

    public static final String SIMPLE_BLOCK_ATLAS = BASE_BORDER_PATH + "tower_block_simple.atlas";

    public static final String SIMPLE_TYPE_1 = "tower_block_1";

    public static final String TYPE_1 = "block_1";
    public static final String TYPE_2 = "block_2";
    public static final String TYPE_3 = "block_3";
    public static final String TYPE_4 = "block_4";
    public static final String TYPE_5 = "block_5";

    public static String[] TYPE_LIST = {SIMPLE_TYPE_1};

    public static final Set<String> ATLAS_FOR_LOAD = new HashSet<String>(Arrays.asList(
            SIMPLE_BLOCK_ATLAS
    ));

}
