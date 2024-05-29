package com.Swiggy.MagicalArena;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MagicalArenaApplicationTests {

	@Test
	public void PlayerAWins() {
		Player playerA = new Player(100, 10, 20);
		Player playerB = new Player(100, 10, 5);

		Game game = new Game(playerA, playerB);
		game.start();

		assertEquals("Player A wins", game.getResult());
	}

	@Test
	public void PlayerBWins() {
		Player playerA = new Player(50, 5, 10);
		Player playerB = new Player(100, 10, 5);

		Game game = new Game(playerA, playerB);
		game.start();

		assertEquals("Player A wins", game.getResult());

	}


}
