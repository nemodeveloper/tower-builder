package ru.nemodev.towerbuilder.entity.game.border;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import net.dermetfan.gdx.graphics.g2d.Box2DSprite;

import ru.nemodev.towerbuilder.constant.GameConstant;
import ru.nemodev.towerbuilder.core.model.Box2dActor;
import ru.nemodev.towerbuilder.core.util.Box2dObjectBuilder;
import ru.nemodev.towerbuilder.core.util.SpriteUtils;
import ru.nemodev.towerbuilder.entity.game.ConstantBox2dBodyType;
import ru.nemodev.towerbuilder.entity.game.description.mode.ground.GroundDescription;

public class GroundActor extends Box2dActor
{
    private final Fixture ground;
    private final Array<Box2DSprite> groundSpriteList;

    public GroundActor(World world, GroundDescription groundDescription, String groundBlockAtlas)
    {
        super(world);

        this.ground = Box2dObjectBuilder.createBoxFixture(
                world, ConstantBox2dBodyType.GROUND,
                groundDescription.getPosition(),
                groundDescription.getWidth(), groundDescription.getHeight());
        this.ground.setUserData(this);

        float blockSize = 1.5f;

        int blockCountX = (int) (groundDescription.getWidth() / blockSize);
        int blockCountY = 1;

        final float startPosX = (GameConstant.METERS_X - groundDescription.getWidth()) / 2.f + blockSize / 2.f;
        float posX = startPosX;
        float posY = groundDescription.getPosition().y;

        groundSpriteList = new Array<Box2DSprite>(blockCountY * blockCountX);
        for (int i = 0; i < blockCountY; ++i)
        {
            for (int j = 0; j < blockCountX; ++j)
            {
                groundSpriteList.add(SpriteUtils.createRandomBox2d(groundBlockAtlas,
                        blockSize, blockSize, posX, posY));
                posX += blockSize;
            }
            posY += blockSize;
            posX = startPosX;
        }

    }

    @Override
    protected void doDraw(Batch batch, float parentAlpha)
    {
        for (Sprite sprite : groundSpriteList)
        {
            sprite.draw(batch);
        }
    }
}
