package ru.nemodev.towerbuilder.core.manager.resource.game;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;

public class GameDescriptionLoader extends AsynchronousAssetLoader<GameDescriptionParser, GameDescriptionLoader.GameDescriptionLoaderParameter>
{
    private GameDescriptionParser gameDescriptionParser;

    public GameDescriptionLoader(FileHandleResolver resolver)
    {
        super(resolver);
    }

    @Override
    public void loadAsync(AssetManager manager, String fileName, FileHandle file, GameDescriptionLoaderParameter parameter)
    {
        gameDescriptionParser = new GameDescriptionParser(file);
    }

    @Override
    public GameDescriptionParser loadSync(AssetManager manager, String fileName, FileHandle file, GameDescriptionLoaderParameter parameter)
    {
        GameDescriptionParser current = gameDescriptionParser;
        this.gameDescriptionParser = null;

        return current;
    }

    @Override
    public Array<AssetDescriptor> getDependencies(String fileName, FileHandle file, GameDescriptionLoaderParameter parameter)
    {
        return null;
    }

    public static class GameDescriptionLoaderParameter extends AssetLoaderParameters<GameDescriptionParser>
    {

    }
}
