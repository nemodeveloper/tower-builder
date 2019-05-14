package ru.nemodev.towerbuilder.constant.texture;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ru.nemodev.towerbuilder.constant.texture.location.GameLocationTextureFinder;


public final class AtlasLoaderConstant
{
    private AtlasLoaderConstant() { }

    private static final List<AtlasFinder> atlasFinderList = Arrays.asList(
            GameLocationTextureFinder.INSTANCE,
            new BackgroundTextureFinder(),
            new BorderTextureFinder(),
            new UITextureFinder()
    );

    public static final Set<String> ATLAS_BODY_FOR_LOADING = buildAtlasForLoading();

    private static Set<String> buildAtlasForLoading()
    {
        Set<String> atlasForLoading = new HashSet<String>();
        for (AtlasFinder atlasFinder : atlasFinderList)
        {
            atlasForLoading.addAll(atlasFinder.getAtlasForLoad());
        }

        return atlasForLoading;
    }

}
