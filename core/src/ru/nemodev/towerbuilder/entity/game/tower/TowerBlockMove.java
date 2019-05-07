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

public class TowerBlockMove extends Box2dActor
{
    private final TowerManager towerManager;
    private final Box2DSprite blockSpite;
    private final Fixture blockFixture;

    private final float size;
    private final Box2dBodyType box2dBodyType;

    private float moveToY;
    private boolean needMoveToY;

    public TowerBlockMove(World world,
                          TowerManager towerManager,
                          Box2DSprite blockSpite,
                          Fixture blockFixture,
                          float size,
                          Box2dBodyType box2dBodyType)
    {
        super(world);
        this.towerManager = towerManager;
        this.blockSpite = blockSpite;
        this.blockFixture = blockFixture;
        this.size = size;
        this.box2dBodyType = box2dBodyType;

        this.moveToY = 0.f;
        this.needMoveToY = false;
    }

    @Override
    protected void doAct(float delta)
    {
        updatePosition(delta);
        updateCamera(delta);
    }

    private void updatePosition(float delta)
    {
        float halfSize = size / 2.f;
        Vector2 position = blockFixture.getBody().getPosition();

        // Если движение по прямой проверяем границы и разворачиваем скорость
        // TODO бывает кубик заедает на границе - разобраться с этим
        if (position.x + halfSize >= GameConstant.METERS_X
                || position.x - halfSize <= 0.f)
        {
            blockFixture.getBody().setLinearVelocity(blockFixture.getBody().getLinearVelocity().x * -1.f, 0.f);
        }

        // TODO вращение по кругу
//        Vector2 centre = new Vector2(GameConstant.CENTRE_X, GameConstant.CENTRE_Y);
//
//        Vector2 radius = centre.cpy().sub(position);
//        Vector2 force = radius.rotate90(1).nor().scl(5.f);
//        blockFixture.getBody().setLinearVelocity(force.x, force.y);

        // делаем плавный сдвиг
        if (needMoveToY)
        {
            final float timeToMove = 0.1f;
            Vector2 curPos = blockFixture.getBody().getPosition();
            blockFixture.getBody().setTransform(curPos.x,
                    MathUtils.lerp(curPos.y, moveToY, timeToMove),
                    blockFixture.getBody().getAngle());

            // TODO нужно делать округление для сравнения
            if (blockFixture.getBody().getPosition().y == moveToY)
            {
                needMoveToY = false;
            }
        }
    }

    private void updateCamera(float delta)
    {
        Vector2 moveBlockPos = blockFixture.getBody().getPosition();
        Vector3 cameraPos = getScene().getCamera().position;
        final float timeToMove = 0.1f;

        // TODO нельзя завязываться на Y т/к он разный из-за ExtendViewPort - на разных экранах по разному отображается высота
        // подумать и реализовать более верный алгоритм передвижения камеры
        float candidatePosY = moveBlockPos.y - GameConstant.CENTRE_Y + size;
        if (candidatePosY > GameConstant.CENTRE_Y)
        {
            cameraPos.y = MathUtils.lerp(cameraPos.y, candidatePosY + size, timeToMove);
        }
        else
        {
            cameraPos.y = MathUtils.lerp(cameraPos.y, GameConstant.CENTRE_Y, timeToMove);
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

        Fixture towerBlockFixture = Box2dObjectBuilder.createBoxFixture(world, box2dBodyType,
                blockFixture.getBody().getPosition(),  size, size);

        TowerBlock towerBlock = new TowerBlock(world, blockSpite, towerBlockFixture);
        towerManager.addGameObject(towerBlock);

        return towerBlock;
    }

    public void setHeight(float height)
    {
        moveToY = height;
        needMoveToY = true;
    }

}
