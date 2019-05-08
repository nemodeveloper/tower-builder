package ru.nemodev.towerbuilder.entity.game.tower;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;

import net.dermetfan.gdx.graphics.g2d.Box2DSprite;

import ru.nemodev.towerbuilder.constant.GameConstant;
import ru.nemodev.towerbuilder.core.model.Box2dActor;
import ru.nemodev.towerbuilder.core.model.GameObject;
import ru.nemodev.towerbuilder.core.util.Box2dObjectBuilder;
import ru.nemodev.towerbuilder.core.util.SpriteUtils;
import ru.nemodev.towerbuilder.entity.game.ConstantBox2dBodyType;
import ru.nemodev.towerbuilder.entity.game.location.level.block.MoveBlockDescription;


public class TowerBlockGenerator extends Box2dActor
{
    private final TowerManager towerManager;
    private final MoveBlockDescription moveBlockDescription;

    private float currentBlockSize;
    private float currentSpeed;
    private float currentPosY;
    private final float minDistanceY;

    private TowerBlockMove lastTowerBlockMove;

    public TowerBlockGenerator(World world, TowerManager towerManager, MoveBlockDescription moveBlockDescription)
    {
        super(world);
        this.towerManager = towerManager;
        this.moveBlockDescription = moveBlockDescription;
        this.currentBlockSize = moveBlockDescription.getStartSize();
        this.currentSpeed = moveBlockDescription.getStartSpeed();
        this.currentPosY = GameConstant.HALF_Y;
        this.minDistanceY = moveBlockDescription.getMinDistanceY();

        setVisible(false);
    }

    @Override
    public GameObject isTouch(float x, float y)
    {
        return null;
    }

    @Override
    protected boolean isNeedUpdate()
    {
        return false;
    }

    public float getCurrentPosY()
    {
        return currentPosY;
    }

    public TowerBlockMove generate()
    {
        Vector2 position = new Vector2(
                MathUtils.randomBoolean()
                        ? 1.f
                        : GameConstant.METERS_X - 1.f,
                currentPosY);

        Fixture towerBlockFixture = Box2dObjectBuilder.createBoxFixture(world,
                ConstantBox2dBodyType.TOWER_BLOCK_MOVE, position,
                currentBlockSize, currentBlockSize);

        Box2DSprite towerBlockSprite = SpriteUtils.createRandomBox2d(moveBlockDescription.getStaticBlockAtlas());

        lastTowerBlockMove = new TowerBlockMove(world,
                towerManager,
                towerBlockSprite,
                towerBlockFixture,
                moveBlockDescription);

        return lastTowerBlockMove;
    }

    public void changeHeightPos(TowerBlock towerBlock)
    {
        OrthographicCamera camera = getScene().getCamera();

        currentPosY = towerBlock.getPosition().y + minDistanceY;
        if (lastTowerBlockMove != null && !lastTowerBlockMove.isNeedRemove())
        {
            lastTowerBlockMove.setHeight(currentPosY);
        }

        camera.update();
    }
}
