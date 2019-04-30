package ru.nemodev.towerbuilder.core.service;

public class MockAdsService implements AdsService
{
    @Override
    public void showFullScreenBanner(AdsListener adsListener)
    {
        adsListener.adsShowed(true);
    }

    @Override
    public void disable()
    {

    }
}
