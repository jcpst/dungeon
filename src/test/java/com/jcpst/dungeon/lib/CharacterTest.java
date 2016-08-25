package com.jcpst.dungeon.lib;

import junit.framework.TestCase;

public class CharacterTest extends TestCase {

    private Player player() {
        return new Player("Bob", 40, 40, new Weapon(), 70, 5, Race.Human);
    }

    public void testSetLifeGreaterThanMaxLife() {
        Player player = player();

        // Prepare
        player.setLife(50);

        // Act
        assertEquals(player.getMaxLife(), player.getLife());
    }

    public void testSetLifeLessThanMaxLife() {
        Player player = player();

        // Prepare
        player.setLife(30);

        // Act
        assertEquals(player.getLife(), 30);
    }

}
