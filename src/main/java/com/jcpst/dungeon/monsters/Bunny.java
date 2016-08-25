package com.jcpst.dungeon.monsters;

import com.jcpst.dungeon.lib.Monster;

public class Bunny extends Monster {
    private boolean fluffy;

    public Bunny() {
        super();
        this.setName("bunny");
        this.setDescription("just a tiny bunny");
    }

    public Bunny(String name, int life, int maxLife, int hitChance, int block, String description, int minDamage,
            int maxDamage, boolean fluffy) {
        super(name, life, maxLife, hitChance, block, description, minDamage, maxDamage);
        this.setFluffy(false);
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nIs Fluffy? " + this.fluffy;
    }
    
    @Override
    public int calcBlock() {
        int calculatedBlock = this.block;
        if (this.fluffy) {
            calculatedBlock *= 2;
        }
        return calculatedBlock;
    }

    public boolean isFluffy() {
        return fluffy;
    }

    public void setFluffy(boolean fluffy) {
        this.fluffy = fluffy;
    }
}
