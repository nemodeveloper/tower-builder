package ru.nemodev.towerbuilder.entity.game.background;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.List;

import ru.nemodev.towerbuilder.constant.GameConstant;
import ru.nemodev.towerbuilder.constant.texture.location.GameLocationTextureFinder;
import ru.nemodev.towerbuilder.core.manager.resource.FontManager;
import ru.nemodev.towerbuilder.core.model.BaseStaticActor;
import ru.nemodev.towerbuilder.core.util.SpriteUtils;
import ru.nemodev.towerbuilder.entity.game.description.location.LocationPackDescription;
import ru.nemodev.towerbuilder.entity.game.description.location.background.BackgroundPackDescription;
import ru.nemodev.towerbuilder.manager.GameBuilderManager;

import static ru.nemodev.towerbuilder.constant.GameConstant.HALF_Y;

public class GameLocationPreviewActor extends BaseStaticActor
{
    private final String locationKey;
    private final BitmapFont font;
    private Sprite backgroundSprite;

    public GameLocationPreviewActor(List<LocationPackDescription> locationPackDescriptionList, int selectedLocation)
    {
        this.font = FontManager.getInstance().getBox2dCommonFont();

        LocationPackDescription locationPackDescription = locationPackDescriptionList.get(selectedLocation);
        BackgroundPackDescription backgroundPackDescription = locationPackDescription.getBackgroundPackDescription();
        this.locationKey = locationPackDescription.getKey();

        this.backgroundSprite = SpriteUtils.create(
                backgroundPackDescription.getStaticBackgorundAtlas(), GameLocationTextureFinder.STATIC_BACKGROUND_TEXTURE_KEY,
                GameConstant.METERS_X, GameConstant.METERS_Y, GameConstant.HALF_X, HALF_Y);

        GameBuilderManager.getInstance().setSelectedLocationKey(locationKey);
    }

    @Override
    protected void doDraw(Batch batch, float parentAlpha)
    {
        backgroundSprite.draw(batch, parentAlpha);
        // TODO криво отрисовывается название локации
        //font.draw(batch, locationKey, GameConstant.HALF_X, HALF_Y + HALF_Y/2);
    }
}
