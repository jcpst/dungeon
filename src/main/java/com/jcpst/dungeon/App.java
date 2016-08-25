package com.jcpst.dungeon;

import java.io.IOException;
import java.util.Random;
import com.jcpst.dungeon.lib.*;
import com.jcpst.dungeon.monsters.*;

public class App {
	private static String GetRoom() {
		String[] rooms = {
			"The room is dark and musty with the smell of lost souls.",
			"You enter a pretty pink powder room and instantly get glitter on you.",
			"You arrive in a room filled with chairs and a ticket stub machine... DMV."
		};
		Random rand = new Random();
		int index = rand.nextInt(rooms.length);
		String room = rooms[index];
		return room;
	}
	
	private static Monster GetMonster() {
		Gremlin gremlin = new Gremlin();
		Gremlin bigGremlin = new Gremlin("BIG Gremlin", 50, 50, 30, 50, "Big n Tuff", 5, 10, 3);
		Monster[] monsters = { gremlin, bigGremlin };
		Random rand = new Random();
		int index = rand.nextInt(monsters.length);
		Monster monster = monsters[index];
		return monster;
	}

    public static void main(String[] args) {
        System.out.println("Welcome to the Dungeon of Doom!");
		boolean exit = false;
		Weapon weapon = new Weapon(10, true, "Light Saber", 2, 8);
		Player player = new Player("Dread Pirate Roberts", 40, 40, weapon, 70, 5, Race.Borg);
		
		do {
			System.out.print(GetRoom());

			Monster monster = GetMonster();
			
			System.out.printf("In this room: %s", monster.getName());
			
			boolean repeatMenu = true;
			
			do {
				System.out.println("\nPlease choose an action: \nA) Attack\nR) Run away\nC) Character Info\nM) Monster Info\nX) Exit\nEnter your choice:");
				
				char userChoice = 0;
				
				try {
					userChoice = (char) System.in.read();
				} catch (IOException e) {
					e.printStackTrace();
				}

				switch (java.lang.Character.toUpperCase(userChoice)) {
				case 'A':
					Combat.doBattleRound(player, monster);
					if (monster.getLife() <= 0) {
						System.out.printf("You defeated %s", monster.getName());
						repeatMenu = false;
					}
					break;
				case 'R':
					System.out.println("Run away!!!");
					Combat.doAttack(monster, player);
					repeatMenu = false;
					break;
				case 'C':
					System.out.println(player);
					break;
				case 'M':
					System.out.println(monster);
					break;
				case 'X':
					System.out.println("Thanks for playing, but no one likes a quitter");
					exit = true;
					break;
				default:
					System.out.println("Invalid choice. Try again.");
					break;
				}
				
				if (player.getLife() <= 0) {
					System.out.println("You died.");
					exit = true;
				}
				
			} while (repeatMenu && !exit);
		} while (!exit);
    }
}

