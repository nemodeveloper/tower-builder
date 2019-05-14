package ru.nemodev.towerbuilder.constant.texture.location;

import com.badlogic.gdx.files.FileHandle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ru.nemodev.towerbuilder.constant.texture.AtlasFinder;

public class GameLocationTextureFinder extends AtlasFinder
{
    public static final String BASE_LOCATION_PATH = "atlas/location/";

    private static final String PREVIEW_ATLAS_KEY = "preview";
    private static final String STATIC_BACKGROUND_ATLAS_KEY = "static_background";
    private static final String ANIMATION_BACKGROUND_ATLAS_KEY = "animation_background";
    private static final String GROUND_ATLAS_KEY = "ground";
    private static final String STATIC_BLOCK_ATLAS_KEY = "static_block";
    private static final String ANIMATION_BLOCK_ATLAS_KEY = "animation_block";

    public static final String STATIC_BACKGROUND_TEXTURE_KEY = "background";
    public static final String STATIC_GROUND_TEXTURE_KEY = "ground";

    public static final String LOCATION_MOUNT_BASE_PATH = BASE_LOCATION_PATH + "mount";
    public static final String LOCATION_ICE_BASE_PATH = BASE_LOCATION_PATH + "ice";

    private static final Set<String> PATH_FOR_LOAD = new HashSet<String>(Arrays.asList(
            LOCATION_MOUNT_BASE_PATH,
            LOCATION_ICE_BASE_PATH
    ));

    public static final GameLocationTextureFinder INSTANCE = new GameLocationTextureFinder();

    private final Map<String, String> previewLocationAtlasMap;
    private final Map<String, String> staticBackgroundLocationAtlasMap;
    private final Map<String, String> animationBackgroundLocationAtlasMap;
    private final Map<String, String> groundLocationAtlasMap;
    private final Map<String, String> staticBlockLocationAtlasMap;
    private final Map<String, Set<String>> animationBlockLocationAtlasMap;

    public GameLocationTextureFinder()
    {
        previewLocationAtlasMap = new HashMap<String, String>();
        staticBackgroundLocationAtlasMap = new HashMap<String, String>();
        animationBackgroundLocationAtlasMap = new HashMap<String, String>();
        groundLocationAtlasMap = new HashMap<String, String>();
        staticBlockLocationAtlasMap = new HashMap<String, String>();
        animationBlockLocationAtlasMap = new HashMap<String, Set<String>>();
    }

    @Override
    protected Set<String> getPathForScan()
    {
        return PATH_FOR_LOAD;
    }

    @Override
    protected void processAtlas(FileHandle fileHandle, String scanPath)
    {
        String locationKey = scanPath.substring(scanPath.lastIndexOf("/") + 1);
        String atlasPath = fileHandle.path();

        if (atlasPath.contains(PREVIEW_ATLAS_KEY))
        {
            previewLocationAtlasMap.put(locationKey, atlasPath);
            return;
        }

        if (atlasPath.contains(STATIC_BACKGROUND_ATLAS_KEY))
        {
            staticBackgroundLocationAtlasMap.put(locationKey, atlasPath);
            return;
        }

        if (atlasPath.contains(ANIMATION_BACKGROUND_ATLAS_KEY))
        {
            animationBackgroundLocationAtlasMap.put(locationKey, atlasPath);
            return;
        }

        if (atlasPath.contains(GROUND_ATLAS_KEY))
        {
            groundLocationAtlasMap.put(locationKey, atlasPath);
            return;
        }

        if (atlasPath.contains(STATIC_BLOCK_ATLAS_KEY))
        {
            staticBlockLocationAtlasMap.put(locationKey, atlasPath);
            return;
        }

        if (atlasPath.contains(ANIMATION_BLOCK_ATLAS_KEY))
        {
            if (animationBlockLocationAtlasMap.get(locationKey) == null)
            {
                animationBlockLocationAtlasMap.put(locationKey, new HashSet<String>());
            }

            animationBlockLocationAtlasMap.get(locationKey).add(atlasPath);
            return;
        }

    }

    public Map<String, String> getPreviewLocationAtlasMap()
    {
        return previewLocationAtlasMap;
    }

    public Map<String, String> getStaticBackgroundLocationAtlasMap()
    {
        return staticBackgroundLocationAtlasMap;
    }

    public Map<String, String> getAnimationBackgroundLocationAtlasMap()
    {
        return animationBackgroundLocationAtlasMap;
    }

    public Map<String, String> getGroundLocationAtlasMap()
    {
        return groundLocationAtlasMap;
    }

    public Map<String, String> getStaticBlockLocationAtlasMap()
    {
        return staticBlockLocationAtlasMap;
    }

    public Map<String, Set<String>> getAnimationBlockLocationAtlasMap()
    {
        return animationBlockLocationAtlasMap;
    }
}
