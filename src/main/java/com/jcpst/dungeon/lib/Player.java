package com.jcpst.dungeon.lib;

import java.util.concurrent.ThreadLocalRandom;

public class Player extends Character {
    private Weapon weapon;
    private Race race;

    public Player(String name, int life, int maxLife, Weapon weapon, int hitChance, int block, Race race) {
        this.maxLife = maxLife;
        this.name = name;
        this.life = life;
        this.weapon = weapon;
        this.hitChance = hitChance;
        this.block = block;
        this.race = race;
    }

    @Override
    public int calcHitChance() {
        return this.hitChance + weapon.getBonusHitChance();
    }

    @Override
    public int calcDamage() {
        int damage = ThreadLocalRandom.current().nextInt(weapon.getMinDamage(), weapon.getMaxDamage() + 1);
        return damage;
    }

    @Override
    public String toString() {
        String description = "";

        switch (race) {
        case Human:
            description = "A boring ol' human...";
            break;
        case Elf:
            description = "A tall pointy eared elf that is in the dungeon just to annoy Evan.";
            break;
        case Dwarf:
            description = "A bearded dwarf, even the females..";
            break;
        case Borg:
            description = "Borg... you will be assimilated.";
            break;
        case SuperNinja:
            description = "Not just any ninja... it's a super ninja!";
            break;
        default:
            break;
        }

        return String.format(
                "-=-= Name: %s =-=-\nLife: %d of %d\nHit Chance: %d\nBlock: %d\nWeapon: %s\nDescription: %s", this.name,
                this.life, this.maxLife, this.hitChance, this.block, this.getWeapon().getName(), description);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }
}
