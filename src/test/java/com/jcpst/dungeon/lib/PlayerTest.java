package com.jcpst.dungeon.lib;

import junit.framework.TestCase;

public class PlayerTest extends TestCase {
    
    private Player player() {
        Weapon weapon = new Weapon(15, false, "Blade", 10, 20);
        return new Player("Bob", 40, 40, weapon, 70, 5, Race.Human);
    }

    public void testCalcHitChance() {
        Player player = player();
        
        // player.hitChance is 70,
        // weapon.bonusHitChance is 15
        assertEquals(player.calcHitChance(), 85);
    }

    public void testCalcDamage() {
        Player player = player();
        
        assertTrue(player.calcDamage() >= 10);
        assertTrue(player.calcDamage() <= 20);
    }

}
