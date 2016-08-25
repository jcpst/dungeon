package com.jcpst.dungeon.lib;

import junit.framework.TestCase;

public class MonsterTest extends TestCase {
    
    private Monster monster() {
        return new Monster();
    }

    public void testSetMinDamageGreaterThanMaxDamage() {
        
        // Prepare
        Monster monster = monster();
        monster.setMinDamage(5);
        
        // Act
        assertEquals(monster.getMinDamage(), 3);
    }
    
    public void testSetMinDamageLessThanMaxDamage() {
        
        // Prepare
        Monster monster = monster();
        monster.setMinDamage(2);
        
        // Act
        assertEquals(monster.getMinDamage(), 2);
    }

}
