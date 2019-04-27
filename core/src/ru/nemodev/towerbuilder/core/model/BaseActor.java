package ru.nemodev.towerbuilder.core.model;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;

import ru.nemodev.towerbuilder.core.scene.Scene;

public abstract class BaseActor implements GameObject
{
    private final Array<GameObject> childrenGameObjects;
    private Scene scene;

    private boolean visible;
    private boolean needRemove;

    public BaseActor()
    {
        this.childrenGameObjects = new Array<GameObject>();
        this.needRemove = false;
        this.visible = true;
    }

    public void setScene(Scene scene)
    {
        this.scene = scene;
        if (hasChildren())
        {
            for (GameObject children : childrenGameObjects)
            {
                children.setScene(getScene());
            }
        }
    }

    public void addGameObject(GameObject gameObject)
    {
        gameObject.setScene(getScene());
        childrenGameObjects.add(gameObject);
    }

    @Override
    public void update(float delta)
    {
        if (isNeedUpdate())
        {
            doAct(delta);
        }

        for (GameObject gameObject : childrenGameObjects)
        {
            if (gameObject.isNeedRemove())
            {
                childrenGameObjects.removeValue(gameObject, true);
            }
        }

        if (hasChildren())
        {
            for (GameObject gameObject : childrenGameObjects)
            {
                gameObject.update(delta);
            }
        }
    }

    protected boolean isNeedUpdate()
    {
        return true;
    }

    protected void doAct(float delta) { }

    @Override
    public void draw(Batch batch, float parentAlpha)
    {
        if (isVisible())
        {
            doDraw(batch, parentAlpha);
            if (hasChildren())
            {
                for (GameObject gameObject : childrenGameObjects)
                {
                    gameObject.draw(batch, parentAlpha);
                }
            }
        }
    }

    @Override
    public GameObject isTouch(float x, float y)
    {
        if (isVisible() && hasChildren())
        {
            for (GameObject children : childrenGameObjects)
            {
                GameObject candidate = children.isTouch(x, y);
                if (candidate != null)
                    return candidate;
            }
        }

        return null;
    }

    @Override
    public boolean touchDown(float x, float y)
    {
        return false;
    }

    @Override
    public void touchUp(float x, float y)
    {

    }

    protected final boolean hasChildren()
    {
        return childrenGameObjects.size > 0;
    }

    protected void doDraw(Batch batch, float parentAlpha) { }

    @Override
    public void dispose() { }

    @Override
    public Scene getScene()
    {
        return scene;
    }

    @Override
    public boolean isNeedRemove()
    {
        return needRemove;
    }

    public void remove()
    {
        dispose();
        this.needRemove = true;

        if (hasChildren())
        {
            for (GameObject children : childrenGameObjects)
            {
                children.remove();
                childrenGameObjects.removeValue(children, true);
            }
        }
    }

    @Override
    public boolean isVisible()
    {
        return visible;
    }

    public void setVisible(boolean visible)
    {
        this.visible = visible;
    }

    protected void drawSprite(Batch batch, Sprite sprite, float posX, float posY)
    {
        sprite.setPosition(posX, posY);
        sprite.draw(batch);
    }
}
