package main_files;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StatsTest {
	Stats player = new Stats("Player", 1, 10, 3, 3, 2, 3);
	@Test
	public void Test_Calculate_Attack() {
		assertNotNull(player.Calculate_Attack(true));
		assertNotNull(player.Calculate_Attack(false));
	}
	@Test
	public void Test_Take_Damage() {
		//Test Magic Damage
		int initial_hp = player.current_hp;
		player.Take_Damage(3, true);
		int final_hp = player.current_hp;
		assertNotEquals(initial_hp, final_hp);
		assertEquals(9, final_hp);
		//Test Physical Damage
		player.current_hp = initial_hp;
		player.Take_Damage(3, false);
		final_hp = player.current_hp;
		assertNotEquals(initial_hp, final_hp);
		assertEquals(9, final_hp);
		//Test a Lot of Damage
		player.current_hp = initial_hp;
		player.Take_Damage(200, false);
		final_hp = player.current_hp;
		assertEquals(0, final_hp);
		//Reset HP
		player.current_hp = initial_hp;
	}

}
