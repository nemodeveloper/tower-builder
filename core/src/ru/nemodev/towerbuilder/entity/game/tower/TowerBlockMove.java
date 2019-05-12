package ru.nemodev.towerbuilder.entity.game.tower;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;

import net.dermetfan.gdx.graphics.g2d.Box2DSprite;

import ru.nemodev.towerbuilder.constant.GameConstant;
import ru.nemodev.towerbuilder.core.model.Box2dActor;
import ru.nemodev.towerbuilder.core.util.Box2dObjectBuilder;
import ru.nemodev.towerbuilder.entity.game.Box2dBodyType;
import ru.nemodev.towerbuilder.entity.game.location.level.block.MoveBlockDescription;
import ru.nemodev.towerbuilder.entity.game.location.level.block.MoveType;

public class TowerBlockMove extends Box2dActor
{
    private final TowerManager towerManager;
    private final Box2DSprite blockSpite;
    private final Fixture blockFixture;

    private final MoveBlockDescription moveBlockDescription;

    private final TowerManager.TowerEventListener towerEventListener;

    private final float size;
    private final float halfSize;
    private float speed;
    private final Box2dBodyType box2dBodyType;

    private final MoveType moveType;
    private final Vector2 centre;
    private float angle;

    public TowerBlockMove(World world,
                          TowerManager towerManager,
                          Box2DSprite blockSpite,
                          Fixture blockFixture,
                          MoveBlockDescription moveBlockDescription,
                          TowerManager.TowerEventListener towerEventListener)
    {
        super(world);
        this.towerManager = towerManager;
        this.blockSpite = blockSpite;
        this.blockFixture = blockFixture;
        this.moveBlockDescription = moveBlockDescription;
        this.towerEventListener = towerEventListener;

        this.size = moveBlockDescription.getStartSize();
        this.halfSize = size / 2.f;
        this.speed = moveBlockDescription.getStartSpeed();
        this.box2dBodyType = moveBlockDescription.getPhysicDescription().getBox2dBodyType();

        this.moveType = moveBlockDescription.getMoveType();
        this.centre = new Vector2(GameConstant.HALF_X, blockFixture.getBody().getPosition().y);

        if (moveType == MoveType.line)
        {
            blockFixture.getBody().setLinearVelocity(MathUtils.randomBoolean() ? speed : -speed, 0.f);
        }
        else
        {
            if (MathUtils.randomBoolean())
            {
                this.angle = moveBlockDescription.getMinAngle();
            }
            else
            {
                this.angle = moveBlockDescription.getMaxAngle();
                this.speed *= -1;
            }
        }

        blockFixture.setSensor(true);
    }

    @Override
    protected void doAct(float delta)
    {
        updatePosition(delta);
        updateCamera(delta);
    }

    private void updatePosition(float delta)
    {
        final Vector2 position = blockFixture.getBody().getPosition();

        if (moveType == MoveType.line)
        {
            // TODO бывает кубик заедает на границе - разобраться с этим
            if (position.x + halfSize >= GameConstant.METERS_X
                    || position.x - halfSize <= 0.f)
            {
                blockFixture.getBody().setLinearVelocity(blockFixture.getBody().getLinearVelocity().x * -1.f, 0.f);
            }
        }
        else
        {
            angle += 1.f * speed;
            float x = centre.x + MathUtils.cosDeg(angle) * (GameConstant.HALF_X - halfSize);
            float y = centre.y + MathUtils.sinDeg(angle) * GameConstant.HALF_X;
            if (angle >= moveBlockDescription.getMaxAngle()
                    || angle <= moveBlockDescription.getMinAngle())
            {
                speed *= -1;
            }

            blockFixture.getBody().setTransform(x, y, 0.f);
        }

        // делаем плавный сдвиг
        final float timeToMove = 0.1f;
        Vector2 curPos = blockFixture.getBody().getPosition();
        blockFixture.getBody().setTransform(curPos.x,
                MathUtils.lerp(curPos.y, centre.y, timeToMove),
                blockFixture.getBody().getAngle());
    }

    private void updateCamera(float delta)
    {
        Vector2 moveBlockPos = blockFixture.getBody().getPosition();
        Vector3 cameraPos = getScene().getCamera().position;
        final float timeToMove = 0.1f;

        // TODO нельзя завязываться на Y т/к он разный из-за ExtendViewPort - на разных экранах по разному отображается высота
        // подумать и реализовать более верный алгоритм передвижения камеры
        float candidatePosY = moveBlockPos.y - GameConstant.HALF_Y + size;
        if (candidatePosY > GameConstant.HALF_Y)
        {
            cameraPos.y = MathUtils.lerp(cameraPos.y, candidatePosY + size, timeToMove);
        }
        else
        {
            cameraPos.y = MathUtils.lerp(cameraPos.y, GameConstant.HALF_Y, timeToMove);
        }

        getScene().getCamera().update();
    }

    @Override
    protected void doDraw(Batch batch, float parentAlpha)
    {
        drawSprite(batch, blockSpite, blockFixture);
    }

    @Override
    public void remove()
    {
        world.destroyBody(blockFixture.getBody());
        super.remove();
    }

    public TowerBlock dropBlock()
    {
        setVisible(false);
        setNeedRemove(true);
        towerEventListener.setReadyForDropBlock(false);

        Fixture towerBlockFixture = Box2dObjectBuilder.createBoxFixture(world, box2dBodyType,
                blockFixture.getBody().getPosition(),  size, size);

        TowerBlock towerBlock = new TowerBlock(world, blockSpite, towerBlockFixture, towerEventListener);
        towerManager.addGameObject(towerBlock);

        return towerBlock;
    }

    public void setHeight(float height)
    {
        centre.y = height;
    }

}
