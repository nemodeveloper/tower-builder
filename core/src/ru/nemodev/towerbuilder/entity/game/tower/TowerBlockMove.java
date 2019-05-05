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
    }

    @Override
    protected void doAct(float delta)
    {
        float size = 0.5f;
        Vector2 position = blockFixture.getBody().getPosition();

        if (position.x + size >= GameConstant.METERS_X || position.x - size <= 0.f)
        {
            blockFixture.getBody().setLinearVelocity(blockFixture.getBody().getLinearVelocity().x * -1.f, 0.f);
        }

        updateCamera(delta);
    }

    private void updateCamera(float delta)
    {
        Vector2 moveBlockPos = blockFixture.getBody().getPosition();
        Vector3 cameraPos = getScene().getCamera().position;

        float candidatePosY = moveBlockPos.y - GameConstant.CENTRE_Y + size;
        if (candidatePosY > GameConstant.CENTRE_Y)
        {
            cameraPos.y = MathUtils.lerp(cameraPos.y, candidatePosY + size, delta * 3.f);
        }
        else
        {
            cameraPos.y = GameConstant.CENTRE_Y;
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
        Vector2 curPos = blockFixture.getBody().getPosition();
        blockFixture.getBody().setTransform(curPos.x, height, blockFixture.getBody().getAngle());
    }

}
