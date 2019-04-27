package ru.nemodev.towerbuilder.core.physic.collision;


import ru.nemodev.towerbuilder.entity.game.ContactType;

public interface Contactable
{
    void beginContact(Contactable contactable);

    void endContact(Contactable contactable);

    ContactType getContactType();
}
