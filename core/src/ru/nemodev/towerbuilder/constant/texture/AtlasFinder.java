package ru.nemodev.towerbuilder.constant.texture;

import com.badlogic.gdx.files.FileHandle;

import java.io.File;
import java.io.FileFilter;
import java.util.HashSet;
import java.util.Set;

import ru.nemodev.towerbuilder.core.util.FileUtils;

public abstract class AtlasFinder
{
    private static final String ATLAS_KEY = "atlas";

    public Set<String> getAtlasForLoad()
    {
        Set<String> atlasForLoad = new HashSet<String>();
        for (String path : getPathForScan())
        {
            for (FileHandle fileHandle : FileUtils.getInternalFile(path).list(getAtlasFilter()))
            {
                processAtlas(fileHandle, path);
                atlasForLoad.add(fileHandle.path());
            }
        }

        return atlasForLoad;
    }

    protected void processAtlas(FileHandle fileHandle, String scanPath) { }

    protected abstract Set<String> getPathForScan();

    private FileFilter getAtlasFilter()
    {
        return new FileFilter()
        {
            @Override
            public boolean accept(File file)
            {
                return file.getName().endsWith(ATLAS_KEY);
            }
        };
    }
}
