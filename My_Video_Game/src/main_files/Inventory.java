package main_files;

public class Inventory //for now exists simply to track the potions the player is using
{
	int potion_bag = 0;
	public boolean Use_Potion() //will give confirmation potion has been used
	{
		if(potion_bag == 0)
		{
			System.out.println("You do not have enough potions");
			return false;
		}
		else
		{
			potion_bag = potion_bag - 1;
			System.out.println("Used Potion. You now have: " + potion_bag);
			return true;
		}
	}
	public boolean Gain_Potion() //will give confirmation potion has been added to the bag
	{
		potion_bag = potion_bag + 1;
		System.out.println("Potion has been added to the bag. You now have: " + potion_bag);
		return true;
	}
}
