package com.game.guess;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


class Player {
	private int guessNum;
	private int playerId;

	public Player(int playerId) {
		this.playerId = playerId;
	}
	
	public Player(int playerId,int guessNum) {
		this.playerId = playerId;
		this.guessNum = guessNum;

	}
	public int guessNum() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("Player %d please guess the number..", playerId);
		guessNum = sc.nextInt();
		return guessNum;
	}

	public int getId() {
		return this.playerId;
	}

	public int getGuess() {
		return this.guessNum;
	}
}

class Umpire {
	Player a;
	Player b;
	Player c;
	Player x;

	public Umpire(Player x,Player a, Player b, Player c ) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.x = x;
	}

	Umpire() {
		a = new Player(1);
		b = new Player(2);
		c = new Player(3);
		x = new Player(0);//player 0 is guesser
	}

	void collectNumberFromGuesser() {
		x.guessNum();
	}

	void collectNumberFromPlayers() {
		a.guessNum();
		b.guessNum();
		c.guessNum();
	}

	List<Integer>  findWinnerFromTwo(Player x, Player a, Player b) {
		if (x.getGuess() == a.getGuess() && x.getGuess() == b.getGuess()) {
			System.out.printf("Player %d & %d winners \n", a.getId(), b.getId());
			return Arrays.asList(a.getId(),b.getId());//todo.. return array of 2 ids.. coded to satisfy junit

		} else if (x.getGuess() == a.getGuess()) {

			System.out.printf("Player %d winner", a.getId());
			return Arrays.asList(a.getId());

		} else if (x.getGuess() == b.getGuess()) {

			System.out.printf("Player %d winner", b.getId());
			return Arrays.asList(b.getId());

		} else {
			System.out.println("No winners");
			return Arrays.asList(-1);
		}
	}
	
	List<Integer>   findOneWinnerFromThree(Player x, Player a, Player b,Player c) {
		int winnerId=-1;
		if (x.getGuess() == a.getGuess() ) {
			winnerId =a.getId();
			System.out.printf("Player %d is winners \n", winnerId);

		} else if (x.getGuess() == b.getGuess() ) {
			winnerId =b.getId();

			System.out.printf("Player %d is winners \n", b.getId());

		}else if (x.getGuess() == c.getGuess() ) {
			winnerId =c.getId();

			System.out.printf("Player %d is winners \n", c.getId());

		}
		return  Arrays.asList(winnerId);
	}
	List<Integer>  compare() {
		List<Integer> winnerId;
		if (x.getGuess() == a.getGuess() && x.getGuess() == b.getGuess() && x.getGuess() == c.getGuess()) {
			System.out.printf("Player %d,%d,%d winners\n", a.getId(), b.getId(), c.getId());
			winnerId = Arrays.asList(a.getId(),b.getId(),c.getId());a.getId();
		} else if (x.getGuess() == a.getGuess() && x.getGuess() == b.getGuess()) {
			winnerId = findWinnerFromTwo(x, a, b);
		} else if (x.getGuess() == b.getGuess() && x.getGuess() == c.getGuess()) {
			winnerId =findWinnerFromTwo(x, b, c);
		} else if (x.getGuess() == a.getGuess() && x.getGuess() == c.getGuess()) {
			winnerId =findWinnerFromTwo(x, a, c);
		} else if (x.getGuess() == a.getGuess() || x.getGuess() == b.getGuess() || x.getGuess() == c.getGuess()) {
			winnerId = findOneWinnerFromThree(x, a,b, c);
		} else {
			System.out.println("No winners ");
			winnerId = Arrays.asList(-1);
		}
		return  winnerId;
	}
}

public class UmprireGame {
	public static void main(String[] args) {
		Umpire umpire = new Umpire();
		System.out.println("U can make 3 guesses .. Player 0 is guesser");
		for (int i = 1; i <= 3; i++) {
			umpire.collectNumberFromGuesser();
			umpire.collectNumberFromPlayers();
			umpire.compare();
			System.out.printf("Try %d again\n", (3 - i));
		}
	}
}

