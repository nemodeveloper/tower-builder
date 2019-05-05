package ru.nemodev.towerbuilder.entity.game.location.level;

import ru.nemodev.towerbuilder.constant.SoundConstant;
import ru.nemodev.towerbuilder.entity.game.location.level.background.BackgroundDescription;
import ru.nemodev.towerbuilder.entity.game.location.level.block.MoveBlockDescription;
import ru.nemodev.towerbuilder.entity.game.location.level.ground.GroundDescription;
import ru.nemodev.towerbuilder.entity.game.location.level.strategy.WinStrategyDescription;

public class LevelDescription
{
    private Integer levelNumber;
    private String levelName;

    private String mainMusic;

    private WinStrategyDescription winStrategyDescription;
    private MoveBlockDescription moveBlockDescription;
    private GroundDescription groundDescription;
    private BackgroundDescription backgroundDescription;

    public LevelDescription()
    { }

    public Integer getLevelNumber()
    {
        return levelNumber;
    }

    public void setLevelNumber(Integer levelNumber)
    {
        this.levelNumber = levelNumber;
    }

    public String getLevelName()
    {
        return levelName;
    }

    public void setLevelName(String levelName)
    {
        this.levelName = levelName;
    }

    public MoveBlockDescription getMoveBlockDescription()
    {
        return moveBlockDescription;
    }

    public void setMoveBlockDescription(MoveBlockDescription moveBlockDescription)
    {
        this.moveBlockDescription = moveBlockDescription;
    }

    public GroundDescription getGroundDescription()
    {
        return groundDescription;
    }

    public void setGroundDescription(GroundDescription groundDescription)
    {
        this.groundDescription = groundDescription;
    }

    public BackgroundDescription getBackgroundDescription()
    {
        return backgroundDescription;
    }

    public void setBackgroundDescription(BackgroundDescription backgroundDescription)
    {
        this.backgroundDescription = backgroundDescription;
    }

    public String getMainMusic()
    {
        return mainMusic;
    }

    public void setMainMusic(String mainMusic)
    {
        this.mainMusic = SoundConstant.BASE_SOUND_PATH + mainMusic;
    }

    public WinStrategyDescription getWinStrategyDescription()
    {
        return winStrategyDescription;
    }

    public void setWinStrategyDescription(WinStrategyDescription winStrategyDescription)
    {
        this.winStrategyDescription = winStrategyDescription;
    }
}
