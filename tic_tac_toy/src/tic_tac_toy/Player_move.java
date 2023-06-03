package tic_tac_toy;

import java.util.Scanner;

import java.util.Random;

public class Player_move extends Board_of_tic_tay {
	Random random = new Random();

	public boolean move_players(int row, int col) {

		if (row >= 0 && row < 3 && col >= 0 && col < 3) {
			board[row][col] = currentPlayer;
			return true;

		}
		return false;

	}

	public void switchPlayer() {
		if (currentPlayer == 'X') {
			currentPlayer = 'O';
		} else {
			currentPlayer = 'X';
		}
	}

	public void Play_Against_Player() {
		Scanner scanner = new Scanner(System.in);

		int conuter = 1;
		while (!checkGameOver()) {
			print_maps();
			System.out.println("Player " + currentPlayer + " Please choose  row and column (0-2): ");
			int row = scanner.nextInt();
			int col = scanner.nextInt();

			if (isValidMove(row, col)) {
				move_players(row, col);
				checkGameOver();
				switchPlayer();
			} else {
				System.out.println("Invalid move! Try again.");
			}
			if (check_winner('X')) {
				System.out.println("Player X wins!");
				print_maps();
				break;

			} else if (check_winner('O')) {
				System.out.println("Player O wins!");
				print_maps();
				break;
			} else if (conuter > 8) {
				System.out.println("It's a draw!");
				print_maps();
				break;
			}

			conuter++;
		}

	}

	public void aiMove() {
		while (true) {
			int row = random.nextInt(3);
			int col = random.nextInt(3);

			if (board[row][col] == '-') {
				move_players(row, col);
				break;
			}

		}
	}

	public void play_Against_Computer() {
		Scanner scanner = new Scanner(System.in);
		int conuter = 1;
		while (!checkGameOver()) {
			if (currentPlayer == 'X') {
				print_maps();
				System.out.println("Player X Please choose  row and column (0-2): ");
				int row = scanner.nextInt();
				int col = scanner.nextInt();

				if (isValidMove(row, col)) {
					move_players(row, col);
					checkGameOver();
					switchPlayer();
				} else {
					System.out.println("Invalid move! Try again.");
				}
			} else {
				aiMove();
				checkGameOver();
				switchPlayer();
			}

			if (check_winner('O')) {
				print_maps();
				System.out.println("Computer is winner");
				break;
			} else if (check_winner('X')) {
				print_maps();
				System.out.println("Player X wins!");
				break;

			} else if (conuter > 8) {
				System.out.println("It's a draw!");
				break;
			}
			conuter++;
		}

	}

}
