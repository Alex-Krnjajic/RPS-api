package com.example.demo;

import java.util.Random;

public class RPS_Logic {
	static boolean start = false;
	static int scorePlayer = 0;
	static int scoreComp = 0;
	static int scoreBefore = 0;
	static int scoreAfter = 0;
	static String whoWon = "";
	static int loseStreak = 0;
	static String lastComp = "";

	public static String RPSplay(String player, String comp, Boolean AI) {


			player = player.toLowerCase();

			if (player.equals("1")) {
				player = "rock";
			}
			if (player.equals("2")) {
				player = "paper";
			}
			if (player.equals("3")) {
				player = "scissor";
			}
			
			comp = comp.toLowerCase();

			if (comp.equals("1")) {
				comp = "rock";
			}
			if (comp.equals("2")) {
				comp = "paper";
			}
			if (comp.equals("3")) {
				comp = "scissor";
			}

			while (!player.equals("rock") && !player.equals("paper") && !player.equals("scissor")) {


				return (player + "Not a valid input, try again");

			}
			if (AI) {
				comp = rpsAI(comp, whoWon);
				lastComp = comp;
			}

			System.out.println(player + "player1");
			System.out.println(comp + "player2");

			scoreBefore = scoreComp - scorePlayer;

			if (!player.equals(comp)) {

				switch (player) {

				case "rock":
					if (comp.equals("paper")) {
						scoreComp++;

					} else {
						scorePlayer++;

					}
					break;
				case "paper":
					if (comp.equals("scissor")) {
						scoreComp++;

					} else {
						scorePlayer++;

					}
					break;
				case "scissor":
					if (comp.equals("rock")) {
						scoreComp++;

					} else {
						scorePlayer++;

					}
					break;
				}
			}

			scoreAfter = scoreComp - scorePlayer;
			whoWon = "";

			if (scoreBefore == scoreAfter) {
				whoWon = "tie";
				loseStreak = 0;
				System.out.println("loseStreak break");
			} else if (scoreBefore == (scoreAfter - 1)) {
				whoWon = "comp";
				loseStreak = 0;
				System.out.println("loseStreak break");
			} else if (scoreBefore == (scoreAfter + 1)) {
				whoWon = "player";
				loseStreak++;
				System.out.println(loseStreak);
			} else {
				return "error no winner or tie";
			}
			return whoWon + " " + scorePlayer + " " + scoreComp;
		

	}

	public static String rpsAI(String comp, String whoWon) {
		String[] choice = { "rock", "paper", "scissor" };
		
		Random r = new Random();
		System.out.println(lastComp + " " +whoWon);
		if (loseStreak >= 2) {
			
			comp = choice[r.nextInt(3)];
			System.out.println(comp+"comp random");
			
		}
		else if (whoWon.equals("player")) {
			if (lastComp.equals("rock")) {
				comp = "scissor";
			} else if (lastComp.equals("paper")) {
				comp = "rock";
			} else {
				comp = "paper";
			}
		} else if (whoWon.equals("comp")) {
			if (lastComp.equals("rock")) {
				comp = "scissor";
			} else if (lastComp.equals("paper")) {
				comp = "rock";
			} else {
				comp = "paper";
			}
			
		} else if (whoWon.equals("tie")) {
			if (lastComp.equals("rock")) {
				comp = "paper";
			} else if (lastComp.equals("paper")) {
				comp = "scissor";
			} else {
				comp = "rock";
			}
			
		}else {
			comp = "scissor";
		}

		return comp;
	}
}
