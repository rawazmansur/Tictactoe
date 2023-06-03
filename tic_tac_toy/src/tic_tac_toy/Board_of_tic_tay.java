package tic_tac_toy;

import java.util.Iterator;
import java.util.Scanner;

public class Board_of_tic_tay {
	private boolean isGameOver;
	public static char board[][];
	public char currentPlayer;


	public Board_of_tic_tay() {

		board = new char[3][3];
		currentPlayer = 'X';
		
		generete_maps();
	}

	public void generete_maps() {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				board[row][col] = '-';
			}
		}
	}


	public void print_maps() {
		System.out.println("+-----------------------+");
		for (int row = 0; row < board.length; row++) {
			System.out.print("|");
			for (int col = 0; col < board[row].length; col++) {
				System.out.print("   " + board[row][col] + "   |");

			}
			System.out.println();
			if (board.length - 1 > row) {
				System.out.println("|-------+-------+-------|");

			}

		}
		System.out.println("+-----------------------+");
	}

	public boolean check_winner(char currentPlayer) {
		for (int row = 0; row < 3; row++) {
			if (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer) {
				return true;
			}
		}

		for (int col = 0; col < 3; col++) {
			if (board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer) {
				return true;
			}
		}

		if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)
				|| (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
			return true;
		}

		return false;
	}

	public boolean check_maps_is_full() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (board[row][col] == '-') {
					return false;
				}
			}
		}
		return true;
	}

	public boolean checkGameOver() {
		if (check_winner(currentPlayer) || check_maps_is_full()) {
			isGameOver = true;
		}
		return false;
	}

	public boolean isValidMove(int row, int col) {
		if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
			return board[row][col] == '-';
		}
		return false;
	}

}