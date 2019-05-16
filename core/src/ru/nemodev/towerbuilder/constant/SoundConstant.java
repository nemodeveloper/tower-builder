package ru.nemodev.towerbuilder.constant;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class SoundConstant
{
    private SoundConstant() { }

    public static final String BASE_SOUND_PATH = "sound/";

    // music
    public static final String MAIN_THEME_MUSIC = BASE_SOUND_PATH + "main_theme.mp3";

    public static final String BTN_CLICK = BASE_SOUND_PATH + "btn_click.mp3";

    public static final String BOX_DROP = BASE_SOUND_PATH + "box_drop.mp3";

    public static Set<String> MUSIC_FOR_LOADING = new HashSet<String>(Arrays.asList(
            MAIN_THEME_MUSIC
    ));


    public static Set<String> SOUND_FOR_LOADING = new HashSet<String>(Arrays.asList(
            BTN_CLICK,
            BOX_DROP
    ));

}
