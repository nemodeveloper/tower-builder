package ru.nemodev.towerbuilder.core.manager.resource.game;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;

public class GameLocationLoader extends AsynchronousAssetLoader<GameLocationParser, GameLocationLoader.GameLocationLoaderParameter>
{
    private GameLocationParser gameLocationParser;

    public GameLocationLoader(FileHandleResolver resolver)
    {
        super(resolver);
    }

    @Override
    public void loadAsync(AssetManager manager, String fileName, FileHandle file, GameLocationLoaderParameter parameter)
    {
        gameLocationParser = new GameLocationParser(file);
    }

    @Override
    public GameLocationParser loadSync(AssetManager manager, String fileName, FileHandle file, GameLocationLoaderParameter parameter)
    {
        GameLocationParser current = gameLocationParser;
        this.gameLocationParser = null;

        return current;
    }

    @Override
    public Array<AssetDescriptor> getDependencies(String fileName, FileHandle file, GameLocationLoaderParameter parameter)
    {
        return null;
    }

    public static class GameLocationLoaderParameter extends AssetLoaderParameters<GameLocationParser>
    {

    }
}
