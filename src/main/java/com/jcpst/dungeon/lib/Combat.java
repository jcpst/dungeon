package com.jcpst.dungeon.lib;

import java.util.Random;

public class Combat {
    public static void doBattleRound(Player player, Monster monster) {
        if (!player.getWeapon().isSlow()) {
            doAttack(player, monster);
            if (monster.getLife() > 0) {
                doAttack(monster, player);
            }
        } else {
            doAttack(monster, player);
            if (player.getLife() > 0) {
                doAttack(player, monster);
            }
        }
    }

    public static void doAttack(Character attacker, Character defender) {
        Random rand = new Random();
        int diceRoll = rand.nextInt(101);

        if (diceRoll < (attacker.calcHitChance() - defender.calcBlock())) {
            int life = defender.getLife();
            int damage = attacker.calcDamage();
            defender.setLife(life - damage);
            System.out.printf("%s hit %s for %d damage!", attacker.getName(), defender.getName(), damage);
            System.out.println();
        } else {
            System.out.printf("%s missed!", attacker.getName());
            System.out.println();
        }
    }
}
