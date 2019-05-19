package ru.nemodev.towerbuilder.entity.game.description.mode.strategy;

public class StrategyDescription
{
    private int countBlock;
    private int towerHeight;

    public StrategyDescription()
    { }

    public int getCountBlock()
    {
        return countBlock;
    }

    public void setCountBlock(int countBlock)
    {
        this.countBlock = countBlock;
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
