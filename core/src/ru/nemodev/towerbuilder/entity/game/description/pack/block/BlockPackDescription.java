package ru.nemodev.towerbuilder.entity.game.description.pack.block;

import java.util.List;

import ru.nemodev.towerbuilder.constant.texture.TowerBlockTextureConstant;

public class BlockPackDescription
{
    private String staticAtlas;
    private List<String> animationAtlas;

    public BlockPackDescription() { }

    public String getStaticAtlas()
    {
        return staticAtlas;
    }

    public void setStaticAtlas(String staticAtlas)
    {
        this.staticAtlas = TowerBlockTextureConstant.BASE_BLOCK_PATH + staticAtlas;
    }

    public List<String> getAnimationAtlas()
    {
        return animationAtlas;
    }

    public void setAnimationAtlas(List<String> animationAtlas)
    {
        this.animationAtlas = animationAtlas;
    }
}
