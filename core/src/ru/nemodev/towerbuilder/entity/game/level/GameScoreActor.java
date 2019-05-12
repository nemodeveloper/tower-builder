package ru.nemodev.towerbuilder.entity.game.level;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import ru.nemodev.towerbuilder.core.manager.resource.FontManager;
import ru.nemodev.towerbuilder.core.model.BaseActor;
import ru.nemodev.towerbuilder.core.model.GameObject;

public class GameScoreActor extends BaseActor
{
    private final BitmapFont font;
    private int enableCount;

    public GameScoreActor(int enableCount)
    {
        super();
        this.font = FontManager.getInstance().getBox2dCommonFont();
        this.enableCount = enableCount;
    }

    public void addEnableCount(int count)
    {
        enableCount += count;
        if (enableCount < 0)
        {
            enableCount = 0;
        }
    }

    @Override
    protected boolean isNeedUpdate()
    {
        return false;
    }

    @Override
    public GameObject isTouch(float x, float y)
    {
        return null;
    }

    @Override
    public void draw(Batch batch, float parentAlpha)
    {
        // TODO доделать вывод текста
//        font.draw(batch, String.valueOf(enableCount),
//                GameConstant.HALF_X, GameConstant.HALF_Y);
    }
}
