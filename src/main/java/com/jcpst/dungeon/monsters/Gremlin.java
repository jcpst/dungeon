package com.jcpst.dungeon.monsters;

import com.jcpst.dungeon.lib.Monster;

public class Gremlin extends Monster {
    private int hourChangesBack;

    public Gremlin() {
        super("Mogwai", 25, 25, 40, 0, "Cute little mogwai.. makes cute noises...", 1, 8);
        this.hourChangesBack = 6;
    }

    public Gremlin(String name, int life, int maxLife, int hitChance, int block, String description, int minDamage,
            int maxDamage, int hourChangesBack) {
        super(name, life, maxLife, hitChance, block, description, minDamage, maxDamage);
        this.hourChangesBack = hourChangesBack;
    }

    public int getHourChangesBack() {
        return hourChangesBack;
    }

    public void setHourChangesBack(int hourChangesBack) {
        this.hourChangesBack = hourChangesBack;
    }
}
