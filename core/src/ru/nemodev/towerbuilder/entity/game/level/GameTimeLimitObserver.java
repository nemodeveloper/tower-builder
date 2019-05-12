package ru.nemodev.towerbuilder.entity.game.level;

import ru.nemodev.towerbuilder.entity.game.description.mode.strategy.StrategyDescription;

public class GameTimeLimitObserver extends GameObserver
{
    private float oneSecTimer;

    public GameTimeLimitObserver(StrategyDescription strategyDescription)
    {
        super(strategyDescription, null);
        this.oneSecTimer = 0.f;
    }

    @Override
    protected void doAct(float delta)
    {
        oneSecTimer += delta;
        if (oneSecTimer >= 1.f)
        {
            oneSecTimer = 0.f;
            gameScoreActor.addEnableCount(-1);
        }
    }
}
