package ru.nemodev.towerbuilder.entity.game.level;

import ru.nemodev.towerbuilder.core.model.BaseActor;
import ru.nemodev.towerbuilder.core.model.GameObject;
import ru.nemodev.towerbuilder.entity.game.location.level.strategy.WinStrategyDescription;
import ru.nemodev.towerbuilder.entity.game.player.PlayerActor;
import ru.nemodev.towerbuilder.entity.game.tower.TowerBlock;
import ru.nemodev.towerbuilder.entity.game.tower.TowerBlockGenerator;
import ru.nemodev.towerbuilder.entity.game.tower.TowerManager;


public abstract class GameObserver extends BaseActor implements TowerManager.TowerEventListener, PlayerActor.PlayerEventListener
{
    protected final WinStrategyDescription winStrategyDescription;
    protected final TowerBlockGenerator towerBlockGenerator;

    protected int droppedBlock;

    public GameObserver(WinStrategyDescription winStrategyDescription, TowerBlockGenerator towerBlockGenerator)
    {
        this.winStrategyDescription = winStrategyDescription;
        this.towerBlockGenerator = towerBlockGenerator;
        this.droppedBlock = 0;
    }

    @Override
    public void maxHeightChange(TowerBlock towerBlock)
    {
        // TODO реализовать проверку на победу
//        if (towerBlock.getPosition().y >= winStrategyDescription.getTowerHeight())
//        {
//            GameManager.getInstance().setGameStatus(GameStatus.GAME_WIN);
//        }
//        else
//        {
            towerBlockGenerator.changeHeightPos(towerBlock);
//        }
    }

    @Override
    public void playerDropBlock()
    {
        ++droppedBlock;
    }

    @Override
    public GameObject isTouch(float x, float y)
    {
        return null;
    }

    @Override
    public boolean isVisible()
    {
        return false;
    }
}