package ru.nemodev.towerbuilder.core.service;

public interface AdsService
{
    interface AdsListener
    {
        void adsShowed(boolean showed);
    }

    void showFullScreenBanner(AdsListener adsListener);
    void disable();

}
