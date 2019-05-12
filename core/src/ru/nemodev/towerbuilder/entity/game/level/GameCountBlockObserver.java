package ru.nemodev.towerbuilder.entity.game.level;

import ru.nemodev.towerbuilder.entity.game.location.level.strategy.WinStrategyDescription;
import ru.nemodev.towerbuilder.entity.game.tower.TowerBlockGenerator;

public class GameCountBlockObserver extends GameObserver
{
    public GameCountBlockObserver(WinStrategyDescription winStrategyDescription, TowerBlockGenerator towerBlockGenerator)
    {
        super(winStrategyDescription, towerBlockGenerator);
    }

    @Override
    public void playerDropBlock()
    {
        gameScoreActor.addEnableCount(-1);
    }
}
