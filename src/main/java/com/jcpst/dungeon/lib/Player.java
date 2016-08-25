package com.jcpst.dungeon.lib;

import java.util.concurrent.ThreadLocalRandom;

public class Player extends Character {
	private Weapon weapon;
	private Race race;
	
	public Player(String name, int life, int maxLife, Weapon weapon, int hitChance,
			int block, Race race) {
		this.maxLife = maxLife;
		this.name = name;
		this.life = life;
		this.weapon = weapon;
		this.hitChance = hitChance;
		this.block = block;
		this.race = race;
	}
	
	public int calcHitChance() {
		return this.hitChance + weapon.getBonusHitChance();
	}
	
	public int calcDamage() {
		int damage = ThreadLocalRandom.current()
				.nextInt(weapon.getMinDamage(), weapon.getMaxDamage() + 1);
		return damage;
	}
	
	public String toString() {
		String description = "";
		
		switch (race) {
		case Human:
			description = "A boring ol' human...";
            break;
        case Elf:
            description = "A tall pointy eared elf that is in the dungeon just to annoy Evan.";
            break;
        case Dwarf:
            description = "A bearded dwarf, even the females..";
            break;
        case Borg:
            description = "Borg... you will be assimilated.";
            break;
        case SuperNinja:
            description = "Not just any ninja... it's a super ninja!";
            break;
        default:
            break;
		}
		
		return String.format("-=-= Name: {0} =-=-\nLife: {1} of {2}\nHit Chance: {3}\tBlock: {6}\nWeapon:\n{4}\nDescription: {5}",
                this.name, this.life, this.maxLife, this.hitChance, this.weapon,
                description, this.block);
	}
	
	public Weapon getWeapon() {
		return weapon;
	}
	
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	public Race getRace() {
		return race;
	}
	
	public void setRace(Race race) {
		this.race = race;
	}
}
