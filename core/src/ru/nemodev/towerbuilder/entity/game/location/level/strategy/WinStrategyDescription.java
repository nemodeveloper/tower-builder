package ru.nemodev.towerbuilder.entity.game.location.level.strategy;

public class WinStrategyDescription
{
    private StrategyType type;
    private int count;

    private int towerHeight;

    public WinStrategyDescription()
    { }

    public StrategyType getType()
    {
        return type;
    }

    public void setType(StrategyType type)
    {
        this.type = type;
    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    public int getTowerHeight()
    {
        return towerHeight;
    }

    public void setTowerHeight(int towerHeight)
    {
        this.towerHeight = towerHeight;
    }
}
