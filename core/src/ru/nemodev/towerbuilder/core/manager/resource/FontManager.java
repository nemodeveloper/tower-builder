package ru.nemodev.towerbuilder.core.manager.resource;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.Disposable;

/**
 * created by NemoDev on 08.05.2018 - 20:45
 */
public final class FontManager implements Disposable
{
    private static volatile FontManager instance = new FontManager();

    private BitmapFont box2dCommonFont;
    private BitmapFont commonFont;

    private FontManager()
    {
        init();
    }

    private void init()
    {
        FreeTypeFontGenerator freeTypeFontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("font/Corbel.ttf"));
        commonFont = generateFont(freeTypeFontGenerator, 52);

        int size = 256;//(int) ((1.f / METERS_X) * ScreenUtils.getWidth() * ScreenUtils.getDensity());
        float scale = 0.01f;//METERS_Y / ScreenUtils.getWidth();
        box2dCommonFont = generateFont(freeTypeFontGenerator, size);
        box2dCommonFont.getData().setScale(scale);

        freeTypeFontGenerator.dispose();
    }

    public static FontManager getInstance()
    {
        return instance;
    }

    public BitmapFont getCommonFont()
    {
        return commonFont;
    }

    public BitmapFont getBox2dCommonFont()
    {
        return box2dCommonFont;
    }

    @Override
    public void dispose()
    {
        commonFont.dispose();
    }

    private BitmapFont generateFont(FreeTypeFontGenerator freeTypeFontGenerator, int size)
    {
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = size;
        parameter.characters = FreeTypeFontGenerator.DEFAULT_CHARS;
        parameter.kerning = true;
        parameter.magFilter = Texture.TextureFilter.Linear;
        parameter.minFilter = Texture.TextureFilter.Linear;

        BitmapFont font = freeTypeFontGenerator.generateFont(parameter);
        font.setUseIntegerPositions(true);
        font.setColor(Color.WHITE);

        return font;
    }
}
