package main_files;

public class Main_Script 
{
	public void Timeout()
	{
		try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
	public void Run_Intro()
	{
		System.out.println("Welcome to the game");
		Timeout();
		System.out.println("Use the 'w', 'a', 's', 'd', and 'enter' keys to play");
		Timeout();
		System.out.println("You are an adventurer looking for the treasure of a nearby cave full of monsters");
		Timeout();
		System.out.println("Do whatever it takes to retrieve it");
		Timeout();
		Game_Over();
	}
	public void Game_Over()
	{
		System.out.println("Game Over");
		System.exit(0);
	}
}
