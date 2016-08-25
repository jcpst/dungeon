package com.jcpst.dungeon.lib;

public class Weapon {
	private int bonusHitChance;
	private boolean slow;
	private String name;
	private int minDamage;
	private int maxDamage;
	
	public Weapon() {}
	
	public Weapon(int bonusHitChance, boolean slow, String name,
			int minDamage, int maxDamage) {
		this.maxDamage = maxDamage;
		this.bonusHitChance = bonusHitChance;
		this.slow = slow;
		this.name = name;
		this.minDamage = minDamage;
	}
	
	@Override
	public String toString() {
		return String.format("%s\t%d to %d Damage\nBonus Hit: %d\tIs slow? %s",
				this.name, this.minDamage, this.maxDamage,
				this.bonusHitChance, this.slow);
	}
	
	public int getBonusHitChance() {
		return bonusHitChance;
	}
	
	public void setBonusHitChance(int bonusHitChance) {
		this.bonusHitChance = bonusHitChance;
	}
	
	public boolean isSlow() {
		return slow;
	}
	
	public void setSlow(boolean slow) {
		this.slow = slow;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getMinDamage() {
		return minDamage;
	}
	
	public void setMinDamage(int minDamage) {
		this.minDamage = minDamage;
	}
	
	public int getMaxDamage() {
		return maxDamage;
	}
	
	public void setMaxDamage(int maxDamage) {
		this.maxDamage = maxDamage;
	}
}
