package ru.nemodev.towerbuilder.core.model;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;

import java.util.Iterator;

import ru.nemodev.towerbuilder.core.scene.Scene;

public abstract class BaseActor implements GameObject
{
    private final Array<GameObject> childrenList;
    private Scene scene;

    private boolean visible;
    private boolean needRemove;

    public BaseActor()
    {
        this(16);
    }

    public BaseActor(int initialChildrenSize)
    {
        this.childrenList = new Array<GameObject>(initialChildrenSize);
        this.needRemove = false;
        this.visible = true;
    }

    public void setScene(Scene scene)
    {
        this.scene = scene;
        if (hasChildren())
        {
            for (GameObject children : new Array.ArrayIterator<GameObject>(childrenList))
            {
                children.setScene(getScene());
            }
        }
    }

    public void addGameObject(GameObject gameObject)
    {
        gameObject.setScene(getScene());
        childrenList.add(gameObject);
    }

    @Override
    public void update(float delta)
    {
        if (isNeedUpdate() && !isNeedRemove())
        {
            doAct(delta);

            for (GameObject gameObject : new Array.ArrayIterator<GameObject>(childrenList))
            {
                if (gameObject.isNeedRemove())
                {
                    childrenList.removeValue(gameObject, true);
                }
            }

            if (hasChildren())
            {
                for (GameObject gameObject : new Array.ArrayIterator<GameObject>(childrenList))
                {
                    gameObject.update(delta);
                }
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
                for (GameObject gameObject : new Array.ArrayIterator<GameObject>(childrenList))
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
            for (GameObject children : new Array.ArrayIterator<GameObject>(childrenList))
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
        return childrenList.size > 0;
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

    public void setNeedRemove(boolean needRemove)
    {
        this.needRemove = needRemove;
    }

    public void remove()
    {
        this.needRemove = true;
        dispose();

        if (hasChildren())
        {
            Iterator<GameObject> iterator = new Array.ArrayIterator<GameObject>(childrenList);
            while (iterator.hasNext())
            {
                GameObject children = iterator.next();
                children.remove();
                iterator.remove();
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
