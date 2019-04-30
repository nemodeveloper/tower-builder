package ru.nemodev.towerbuilder;

import com.badlogic.gdx.Screen;

import ru.nemodev.towerbuilder.core.app.BaseGame;
import ru.nemodev.towerbuilder.core.manager.resource.FontManager;
import ru.nemodev.towerbuilder.core.manager.resource.PhysicManager;
import ru.nemodev.towerbuilder.core.manager.resource.ResourceLoader;
import ru.nemodev.towerbuilder.core.manager.system.AppServiceManager;
import ru.nemodev.towerbuilder.core.service.AdsService;
import ru.nemodev.towerbuilder.core.service.PlayService;
import ru.nemodev.towerbuilder.screen.load.SplashScreen;


public final class GameApp extends BaseGame
{
	public GameApp(PlayService playService, AdsService adsService)
	{
		AppServiceManager.getInstance().setPlayService(playService);
		AppServiceManager.getInstance().setAdsService(adsService);
	}

	@Override
	public void dispose()
	{
		super.dispose();

		ResourceLoader.getInstance().dispose();
		PhysicManager.getInstance().dispose();
        FontManager.getInstance().dispose();
	}

	@Override
	protected Screen getStartScreen()
	{
		return new SplashScreen();
	}
}
