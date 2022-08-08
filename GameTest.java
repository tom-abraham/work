package com.game.guess;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class GameTest {

	@Test
	void testOneWinner() {
		Umpire umpire ;
		umpire= new Umpire(new Player(0, 1), new Player(1, 1), new Player(2, 3), new Player(3, 4));
		assertEquals(Arrays.asList(1), umpire.compare());

		umpire= new Umpire(new Player(0, 5), new Player(1, 2), new Player(2, 5), new Player(3, 1));
		assertEquals(Arrays.asList(2), umpire.compare());

		umpire= new Umpire(new Player(0, 1), new Player(1, 2), new Player(2, 3), new Player(3, 1));
		assertEquals(Arrays.asList(3), umpire.compare());
		
	}
	@Test
	void testTwoWinner() {
		Umpire umpire ;
		umpire= new Umpire(new Player(0, 1), new Player(1, 1), new Player(2, 3), new Player(3, 1));
		assertEquals(Arrays.asList(1,3), umpire.compare());
		umpire= new Umpire(new Player(0, 3), new Player(1, 1), new Player(2, 3), new Player(3, 3));
		assertEquals(Arrays.asList(2,3), umpire.compare());
		umpire= new Umpire(new Player(0, 5), new Player(1, 5), new Player(2, 5), new Player(3, 1));
		assertEquals(Arrays.asList(1,2), umpire.compare());
	}
	
	@Test
	void testThreeWinners() {
		Umpire umpire ;
		umpire= new Umpire(new Player(0, 1), new Player(1, 1), new Player(2, 1), new Player(3, 1));
		assertEquals(Arrays.asList(1,2,3), umpire.compare());
		umpire= new Umpire(new Player(0, 5), new Player(1, 5), new Player(2, 5), new Player(3, 5));
		assertEquals(Arrays.asList(1,2,3), umpire.compare());
		umpire= new Umpire(new Player(0, 7), new Player(1, 7), new Player(2, 7), new Player(3, 7));
		assertEquals(Arrays.asList(1,2,3), umpire.compare());
	}

}
