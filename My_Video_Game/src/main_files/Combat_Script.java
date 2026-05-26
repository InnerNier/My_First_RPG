package main_files;

import java.util.Random;

public class Combat_Script 
{
	Random random_calculator = new Random();
	
	public void Encounter(Stats player, Inventory player_inventory)
	{
		int chosen_enemy = random_calculator.nextInt(6);
		Stats enemy;
		switch(chosen_enemy)
		{
			case 1:
				enemy = new Stats("Orc", 3, 14, 5, 1, 2, 12);
				break;
			case 2:
				enemy = new Stats("Slime", 2, 10, 3, 12, 1, 1);
				break;
			case 3:
				enemy = new Stats("Wolf", 4, 15, 7, 1, 15, 2);
				break;
			default:
				enemy = new Stats("Goblin", 1, 7, 2, 1, 1, 1);
				break;
		}
		System.out.println(enemy.name + " appears");
		//loop between the player and enemy turns
		//give player experience
		//check for level up
		//level up if true
	}
	public void Boss_Fight(Stats player, Inventory player_inventory)
	{
		Stats bear = new Stats("Bear", 10, 70, 21, 1, 17, 17);
		//loop between the player and enemy turns
		//give player experience
		//check for level up
		//level up if true
	}
	public void Player_Turn()
	{
		
	}
	public void Enemy_Turn()
	{
		
	}
}
