package com.jcpst.dungeon.lib;

import java.util.Random;

public class Combat {
	public static void doBattleRound(Player player, Monster monster) {
		if (!player.getWeapon().isSlow()) {
			doAttack(player, monster);
			if (monster.getLife() > 0) {
				doAttack(monster, player);
			} else {
				doAttack(monster, player);
				if (player.getLife() > 0) {
					doAttack(player, monster);
				}
			}
		}
	}
	
	public static void doAttack(Character attacker, Character defender) {
		Random rand = new Random();
		int diceRoll = rand.nextInt(101);
		if (diceRoll < (attacker.calcHitChance() - defender.calcBlock())) {
			int damage = attacker.calcDamage();
			defender.life -= damage;
			System.out.printf("%s hit %s for %d damage!", attacker.getName(),
					defender.getName(), damage);
		} else {
			System.out.printf("%d missed!", attacker.getName());
		}
	}
}
