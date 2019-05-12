package ru.nemodev.towerbuilder.entity.game.description.mode;

import ru.nemodev.towerbuilder.entity.game.description.mode.block.MoveBlockDescription;
import ru.nemodev.towerbuilder.entity.game.description.mode.ground.GroundDescription;
import ru.nemodev.towerbuilder.entity.game.description.mode.strategy.StrategyDescription;

public class ModeDescription
{
    private ModeType modeType;
    private String staticTexture;

    private StrategyDescription strategyDescription;
    private MoveBlockDescription moveBlockDescription;
    private GroundDescription groundDescription;

    public ModeDescription()
    { }

    public ModeType getModeType()
    {
        return modeType;
    }

    public void setModeType(ModeType modeType)
    {
        this.modeType = modeType;
    }

    public String getStaticTexture()
    {
        return staticTexture;
    }

    public void setStaticTexture(String staticTexture)
    {
        this.staticTexture = staticTexture;
    }

    public MoveBlockDescription getMoveBlockDescription()
    {
        return moveBlockDescription;
    }

    public void setMoveBlockDescription(MoveBlockDescription moveBlockDescription)
    {
        this.moveBlockDescription = moveBlockDescription;
    }

    public StrategyDescription getStrategyDescription()
    {
        return strategyDescription;
    }

    public void setStrategyDescription(StrategyDescription strategyDescription)
    {
        this.strategyDescription = strategyDescription;
    }

    public GroundDescription getGroundDescription()
    {
        return groundDescription;
    }

    public void setGroundDescription(GroundDescription groundDescription)
    {
        this.groundDescription = groundDescription;
    }

}
