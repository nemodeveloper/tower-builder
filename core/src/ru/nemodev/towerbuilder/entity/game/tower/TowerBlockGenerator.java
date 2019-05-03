package ru.nemodev.towerbuilder.entity.game.tower;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;

import net.dermetfan.gdx.graphics.g2d.Box2DSprite;

import ru.nemodev.towerbuilder.constant.GameConstant;
import ru.nemodev.towerbuilder.core.model.Box2dActor;
import ru.nemodev.towerbuilder.core.util.Box2dObjectBuilder;
import ru.nemodev.towerbuilder.core.util.SpriteUtils;
import ru.nemodev.towerbuilder.entity.game.ConstantBox2dBodyType;
import ru.nemodev.towerbuilder.entity.game.location.level.block.MoveBlockDescription;

public class TowerBlockGenerator extends Box2dActor
{
    private final TowerManager towerManager;
    private final MoveBlockDescription moveBlockDescription;

    public TowerBlockGenerator(World world, TowerManager towerManager, MoveBlockDescription moveBlockDescription)
    {
        super(world);
        this.towerManager = towerManager;
        this.moveBlockDescription = moveBlockDescription;
    }

    public TowerBlockMove generate()
    {
        float speed = moveBlockDescription.getStartVelocityX();
        float size = moveBlockDescription.getStartSize();

        Fixture towerBlockFixture = Box2dObjectBuilder.createBoxFixture(world,
                ConstantBox2dBodyType.TOWER_BLOCK_MOVE,
                new Vector2(
                        MathUtils.random(1.f, GameConstant.METERS_X - 1.f),
                        moveBlockDescription.getStartPosition().y),
                size, size);
        towerBlockFixture.getBody().setLinearVelocity(MathUtils.randomBoolean() ? speed : -speed, 0.f);
        towerBlockFixture.setSensor(true);

        Box2DSprite towerBlockSprite = SpriteUtils.createRandomBox2d(moveBlockDescription.getAtlasTexture());

        return new TowerBlockMove(world,
                towerManager,
                towerBlockSprite,
                towerBlockFixture,
                size,
                moveBlockDescription.getPhysicDescription().getBox2dBodyType());
    }
}
