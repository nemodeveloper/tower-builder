package ru.nemodev.runhero;

import com.badlogic.gdx.backends.iosrobovm.IOSApplication;
import com.badlogic.gdx.backends.iosrobovm.IOSApplicationConfiguration;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;

import ru.nemodev.towerbuilder.GameApp;
import ru.nemodev.towerbuilder.core.service.MockAdbService;
import ru.nemodev.towerbuilder.core.service.MockPlayService;

public class IOSLauncher extends IOSApplication.Delegate
{
    @Override
    protected IOSApplication createApplication()
    {
        IOSApplicationConfiguration config = new IOSApplicationConfiguration();
        return new IOSApplication(new GameApp(new MockPlayService(), new MockAdbService()), config);
    }

    public static void main(String[] argv)
    {
        NSAutoreleasePool pool = new NSAutoreleasePool();
        UIApplication.main(argv, null, IOSLauncher.class);
        pool.close();
    }
}