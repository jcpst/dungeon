package com.jcpst.dungeon.lib;

import java.util.Random;

public class Combat {
	public static void doBattleRound(Player player, Monster monster) {
		if (!player.getWeapon().isSlow()) {
			
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
