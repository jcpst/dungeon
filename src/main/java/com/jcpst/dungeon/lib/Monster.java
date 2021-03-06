package com.jcpst.dungeon.lib;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Monster extends Character {
    private int minDamage;
    private int maxDamage;
    private String description;

    public Monster() {
        this("goon", 5, 5, 20, 20, "lil goon", 1, 3);
    }

    public Monster(String name, int life, int maxLife, int hitChance, int block, String description, int minDamage,
            int maxDamage) {
        this.maxLife = maxLife;
        this.maxDamage = maxDamage;
        this.name = name;
        this.life = life;
        this.hitChance = hitChance;
        this.block = block;
        this.description = description;
        this.minDamage = minDamage;
    }
    
    @Override
    public int calcDamage() {
        int damage = ThreadLocalRandom.current().nextInt(minDamage, maxDamage + 1);
        return damage;
    }

    @Override
    public String toString() {
        return String.format(
                "-=-= Name: %s =-=-\nLife: %d of %d\nDamage: %d to %d\nHit Chance: %d\nBlock: %d\nDescription: %s",
                this.name, this.life, this.maxLife, this.minDamage, this.maxDamage, this.hitChance, this.block,
                this.description);
    }

    public int getMinDamage() {
        return minDamage;
    }

    public void setMinDamage(int minDamage) {
        if (minDamage <= this.maxDamage) {
            this.minDamage = minDamage;
        } else {
            this.minDamage = this.maxDamage;
        }
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
