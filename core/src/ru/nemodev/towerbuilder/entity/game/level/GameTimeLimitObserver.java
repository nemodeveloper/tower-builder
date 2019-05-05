package ru.nemodev.towerbuilder.entity.game.level;

import ru.nemodev.towerbuilder.entity.game.location.level.strategy.WinStrategyDescription;

public class GameTimeLimitObserver extends GameObserver
{
    public GameTimeLimitObserver(WinStrategyDescription winStrategyDescription)
    {
        super(winStrategyDescription, null);
    }
}
