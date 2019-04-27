package ru.nemodev.towerbuilder.core.manager.resource;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.utils.Disposable;

import java.util.HashMap;
import java.util.Map;

import ru.nemodev.towerbuilder.core.physic.BodyEditorLoader;

/**
 * created by NemoDev on 08.05.2018 - 20:45
 */
public final class PhysicManager implements Disposable
{
    private static volatile PhysicManager instance = new PhysicManager();

    private Map<String, BodyEditorLoader> bodyEditorLoaderMap;

    private PhysicManager()
    {
        Box2D.init();
    }

    public static PhysicManager getInstance()
    {
        return instance;
    }

    public void preparePhysicBodies()
    {
        bodyEditorLoaderMap = new HashMap<String, BodyEditorLoader>();
    }

    public void loadPhysicBody(String loaderName, String bodyName, Body body, FixtureDef fixtureDef, float scale)
    {
        bodyEditorLoaderMap.get(loaderName).attachFixture(body, bodyName, fixtureDef, scale);
    }

    @Override
    public void dispose()
    { }
}
