package com.jcpst.dungeon.lib;

public class Character {
    protected int life;
    protected String name;
    protected int maxLife;
    protected int hitChance;
    protected int block;

    public int getLife() {
        return life;
    }

    public void setLife(int value) {
        if (value <= maxLife) {
            this.life = value;
        } else {
            this.life = maxLife;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public void setMaxLife(int value) {
        this.maxLife = value;
    }

    public int getHitChance() {
        return hitChance;
    }

    public void setHitChance(int value) {
        this.hitChance = value;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int value) {
        this.block = value;
    }

    public int calcBlock() {
        return block;
    }

    public int calcHitChance() {
        return hitChance;
    }

    public int calcDamage() {
        return 0;
    }
}
