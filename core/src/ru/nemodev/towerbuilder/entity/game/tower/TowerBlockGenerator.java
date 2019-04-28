package ru.nemodev.towerbuilder.entity.game.tower;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;

import net.dermetfan.gdx.graphics.g2d.Box2DSprite;

import ru.nemodev.towerbuilder.constant.GameConstant;
import ru.nemodev.towerbuilder.constant.texture.TowerBlockTextureConstant;
import ru.nemodev.towerbuilder.core.model.Box2dActor;
import ru.nemodev.towerbuilder.core.util.Box2dObjectBuilder;
import ru.nemodev.towerbuilder.core.util.SpriteUtils;
import ru.nemodev.towerbuilder.entity.game.ConstantBox2dBodyType;

public class TowerBlockGenerator extends Box2dActor
{
    public TowerBlockGenerator(World world)
    {
        super(world);
    }

    public TowerBlockMove generate()
    {
        float speed = 8.5f;
        float size = 1.f;

        Fixture towerBlockFixture = Box2dObjectBuilder.createBoxFixture(world, ConstantBox2dBodyType.TOWER_BLOCK_MOVE,
                new Vector2(MathUtils.random(1.f, GameConstant.METERS_X - 1.f), GameConstant.METERS_Y - 2.f),  size, size);
        towerBlockFixture.getBody().setLinearVelocity(MathUtils.randomBoolean() ? speed : -speed, 0.f);
        towerBlockFixture.setSensor(true);

        Box2DSprite towerBlockSprite = SpriteUtils.createBox2d(TowerBlockTextureConstant.SIMPLE_BLOCK_ATLAS,
                TowerBlockTextureConstant.TYPE_LIST[MathUtils.random(0, TowerBlockTextureConstant.TYPE_LIST.length - 1)]);

        return new TowerBlockMove(world, towerBlockSprite, towerBlockFixture);
    }
}
