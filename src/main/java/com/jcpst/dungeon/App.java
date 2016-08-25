package com.jcpst.dungeon;

import java.util.Random;
import java.util.Scanner;
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
		Monster[] monsters = {
				new Gremlin(),
				new Gremlin("BIG Gremlin", 50, 50, 30, 50, "Big n Tuff", 5, 10, 3)
				};
		Random rand = new Random();
		int index = rand.nextInt(monsters.length);
		Monster monster = monsters[index];
		return monster;
	}
	
	private static Player GetPlayer() {
		Weapon weapon = new Weapon(10, true, "Light Saber", 2, 8);
		Player player = new Player("Dread Pirate Roberts", 40, 40, weapon, 70, 5, Race.Borg);
		return player;
	}

    public static void main(String[] args) {
		boolean exit = false;
		
		Player player = GetPlayer();
		
		System.out.print("\033[H\033[2J");  
	    System.out.flush(); 
        System.out.print("\033]0;DUNGEON OF DOOM\007");
	    System.out.println("Welcome to the Dungeon of Doom!");
        System.out.println("===============================");
        
		
		do {
			Monster monster = GetMonster();
			
			System.out.println();
			System.out.println(GetRoom());
			System.out.println();
			System.out.printf("In this room: %s\n", monster.getName());
			
			boolean repeatMenu = true;

			do {
				System.out.println();
				System.out.println("Please choose an action:");
				System.out.println("------------------------");
				System.out.println("A) Attack");
				System.out.println("R) Run away");
				System.out.println("C) Character Info");
				System.out.println("M) Monster Info");
				System.out.println("X) Exit");
				System.out.println("Enter your choice:");

				Scanner scanner = new Scanner(System.in);
				String userChoice = scanner.next();

				System.out.print("\033[H\033[2J");  
			    System.out.flush(); 
				
				switch (userChoice.toUpperCase()) {
				case "A":
					Combat.doBattleRound(player, monster);
					if (monster.getLife() <= 0) {
						System.out.printf("You defeated %s!", monster.getName());
						System.out.println();
						repeatMenu = false;
					}
					break;
				case "R":
					System.out.println("Run away!!!");
					Combat.doAttack(monster, player);
					repeatMenu = false;
					break;
				case "C":
					System.out.println(player);
					break;
				case "M":
					System.out.println(monster);
					break;
				case "X":
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

