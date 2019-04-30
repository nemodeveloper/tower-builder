package ru.nemodev.runhero.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import ru.nemodev.towerbuilder.GameApp;
import ru.nemodev.towerbuilder.core.service.MockAdsService;
import ru.nemodev.towerbuilder.core.service.MockPlayService;

public class DesktopLauncher
{
	public static void main (String[] arg)
	{
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.vSyncEnabled = false;
		new LwjglApplication(new GameApp(new MockPlayService(), new MockAdsService()), config);
	}
}
