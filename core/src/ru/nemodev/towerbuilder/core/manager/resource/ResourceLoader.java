package ru.nemodev.towerbuilder.core.manager.resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import ru.nemodev.towerbuilder.core.manager.resource.game.GameDescriptionLoader;
import ru.nemodev.towerbuilder.core.manager.resource.game.GameDescriptionParser;
import ru.nemodev.towerbuilder.core.physic.BodyEditorLoader;
import ru.nemodev.towerbuilder.core.physic.PhysicBodyEditorLoader;

/**
 * created by NemoDev on 08.05.2018 - 20:06
 */
public final class ResourceLoader implements Disposable
{
    private static volatile ResourceLoader instance = new ResourceLoader();

    private final AssetManager assetManager;

    private ResourceLoader()
    {
        this.assetManager = new AssetManager();
        this.assetManager.setLoader(BodyEditorLoader.class, new PhysicBodyEditorLoader(assetManager.getFileHandleResolver()));
        this.assetManager.setLoader(GameDescriptionParser.class, new GameDescriptionLoader(assetManager.getFileHandleResolver()));
    }

    public static ResourceLoader getInstance()
    {
        return instance;
    }

    public void dispose()
    {
        assetManager.dispose();
    }

    public boolean isFinishLoad()
    {
        return assetManager.update();
    }

    private void loadAssets(Set<String> fileNames, Class clazz)
    {
        for (String fileName : fileNames)
        {
            assetManager.load(fileName, clazz);
        }
    }

    // atlas/sprite
    public void loadAtlas(Set<String> atlasNames)
    {
        loadAssets(atlasNames, TextureAtlas.class);
    }

    private TextureAtlas getTextureAtlas(String atlasName)
    {
        return assetManager.get(atlasName, TextureAtlas.class);
    }

    public Sprite getSpriteWithoutWait(String filename)
    {
        return new Sprite(new Texture(Gdx.files.internal(filename)));
    }

    public Sprite getSprite(String atlasName, String spriteName)
    {
        return getTextureAtlas(atlasName).createSprite(spriteName);
    }

    public Array<Sprite> getSprites(String atlasName)
    {
        return getTextureAtlas(atlasName).createSprites();
    }

    public List<String> getAtlasSpriteNameList(String atlasName)
    {
        TextureAtlas textureAtlas = getTextureAtlas(atlasName);

        List<String> spriteNameList = new LinkedList<String>();
        for (TextureAtlas.AtlasRegion atlasRegion : textureAtlas.getRegions())
        {
            spriteNameList.add(atlasRegion.name);
        }

        return spriteNameList;
    }

    // sounds
    public void loadMusic(Set<String> musics)
    {
        loadAssets(musics, Music.class);
    }

    public Music getMusic(String musicName)
    {
        return assetManager.get(musicName, Music.class);
    }

    public void loadSound(Set<String> sounds)
    {
        loadAssets(sounds, Sound.class);
    }

    public Sound getSound(String soundName)
    {
        return assetManager.get(soundName, Sound.class);
    }

    // physic
    public void loadBodyEditorLoader(Set<String> physicBody)
    {
        loadAssets(physicBody, BodyEditorLoader.class);
    }

    public BodyEditorLoader getBodyEditorLoader(String bodyEditorName)
    {
        return assetManager.get(bodyEditorName, BodyEditorLoader.class);
    }

    // game level
    public void loadLocation(Set<String> locationPathList)
    {
        loadAssets(locationPathList, GameDescriptionParser.class);
    }

    public GameDescriptionParser getGameLocationParser(String locationPath)
    {
        return assetManager.get(locationPath, GameDescriptionParser.class);
    }

}
