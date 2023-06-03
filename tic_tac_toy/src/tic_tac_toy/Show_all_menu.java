package tic_tac_toy;

import java.util.Scanner;

public class Show_all_menu extends Board_of_tic_tay {
	static Board_of_tic_tay board = new Board_of_tic_tay();

	static Player_move player_move = new Player_move();

	public static void printmenu() {
		Scanner scanner = new Scanner(System.in);
		boolean playAgain = true;
		while (playAgain) {

			board.generete_maps();
			boolean gameFinished = false;

			while (!gameFinished) {
				System.out.println("+----------------------------+");
				System.out.println("|   Welcome to Tic Tac Toe!  |");
				System.out.println("|      project java UHD 🖥   |");
				System.out.print("+----------------------------+\n");
				System.out.println("\n");
				System.out.println("⚔️-------+ Menu +-------⚔️\n");

				System.out.println("1. Player 1 vs Player 2");
				System.out.println("2. Player vs Computer");
				System.out.println("3. Settings");
				System.out.println("4. Exit\n");

				System.out.print("Enter your choice :");
				int choice;
				choice = scanner.nextInt();
				scanner.nextLine();

				switch (choice) {
				case 1:
					player_move.Play_Against_Player();
					gameFinished = true;
					break;
				case 2:
					player_move.play_Against_Computer();
					gameFinished = true;
					break;
				case 3:
					System.out.println("wellcome to setting");
					break;
				case 4:
					System.out.println("Good bye ! have a nice day 🥶");
					System.exit(0);

					break;
				default:
					System.out.println("\nPlease enter the correct number between 1 - 4\n");
					break;
				}
				
				System.out.println("\nDo you want to play again? (Y/N)");
				String playAgainChoice = scanner.next();
				
				if (playAgain == playAgainChoice.equalsIgnoreCase("Y")) {				
					playAgain = true;

				} else {
					System.out.println("Good bye ! have a nice day 🥶");
					playAgain = false;
				}

			}
		}
	}

}
