package ru.nemodev.towerbuilder.entity.game.level;

import ru.nemodev.towerbuilder.entity.game.description.mode.strategy.StrategyDescription;
import ru.nemodev.towerbuilder.entity.game.tower.TowerBlockGenerator;

public class GameCountBlockObserver extends GameObserver
{
    public GameCountBlockObserver(StrategyDescription strategyDescription, TowerBlockGenerator towerBlockGenerator)
    {
        super(strategyDescription, towerBlockGenerator);
    }

    @Override
    public void playerDropBlock()
    {
        gameScoreActor.addEnableCount(-1);
    }
}
