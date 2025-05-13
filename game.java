import java.util.Scanner;
import java.util.HashSet;

public class game {

	public static void printBoard(char[][] board) {
		System.out.println();
		System.out.println("=================================");
		System.out.println();
		
		for (int row = 0; row < board.length; row++) {
			System.out.print("           ");
			for (int column = 0; column < board[row].length; column++) {
				System.out.print(" " + board[row][column] + " ");
				if (column != 2) {
					System.out.print("|");
				}
				else {
					System.out.println();
					if (row == 2) {
						break;
					}
					System.out.println("           ---+---+---");
				}
			}
		}
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		boolean endGame = false;
		
		while (endGame == false) {
			char[][] board = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
			HashSet<Integer> spacesTaken = new HashSet<Integer>();
			
			boolean winner = false;
			int space;
			char turn;
			
			// Introduces game
			System.out.println("Welcome to Tic-Tac-Toe!");		
			
			// Asks user to choose which turn goes first
			do {
				System.out.print("Who would like to go first? X or O: ");
				turn = Character.toUpperCase(scnr.next().charAt(0));
				if (turn != 'X' && turn != 'O') {
					System.out.println("Invalid input. Please type \"X\" or \"O\"");
					System.out.println();
				}
			} while (turn != 'X' && turn != 'O');
			
			// Prints board
			System.out.println();
			System.out.println("Excellent!");
			System.out.println("Printing board...");
			
			printBoard(board);
			
			// Start game
			do {
				// Prompt user to make a valid move
				do {
					try {
						System.out.print("       " + turn + " - Make your move: ");
						space = scnr.nextInt();
						if ((spacesTaken.contains(space)) || (space < 1 || space > 9)) {
							System.out.println("Please choose an available space.");
							System.out.println();
							space = 0;
						}
						else {
							spacesTaken.add(space);
						}
					}
					catch (Exception e) {
						System.out.println("     Please make a valid move.");
						space = scnr.next().charAt(0);
					}
				} while (space < 1 || space > 9);
				
				// Inserts X or O into space
				switch(space) {
					case 1:
						board[0][0] = turn;
						break;
					case 2:
						board[0][1] = turn;
						break;
					case 3:
						board[0][2] = turn;
						break;
					case 4:
						board[1][0] = turn;
						break;
					case 5:
						board[1][1] = turn;
						break;
					case 6:
						board[1][2] = turn;
						break;
					case 7:
						board[2][0] = turn;
						break;
					case 8:
						board[2][1] = turn;
						break;
					case 9:
						board[2][2] = turn;
						break;
				}
				
				printBoard(board);
				
				// Check for winner
				if (board[1][1] == turn) {
					if (board[0][1] == turn && board[2][1] == turn) {
						winner = true;
						break;
					}
					if (board[1][0] == turn && board[1][2] == turn) {
						winner = true;
						break;
					}
					if (board[0][0] == turn && board[2][2] == turn) {
						winner = true;
						break;
					}
					if (board[0][2] == turn && board[2][0] == turn) {
						winner = true;
						break;
					}
				}
				
				if (board[0][0] == turn && board[0][1] == turn && board[0][2] == turn) {
					winner = true;
					break;
				}
				
				if (board[2][0] == turn && board[2][1] == turn && board[2][2] == turn) {
					winner = true;
					break;
				}
				
				if (board[0][0] == turn && board[1][0] == turn && board[2][0] == turn) {
					winner = true;
					break;
				}
				
				if (board[0][2] == turn && board[1][2] == turn && board[2][2] == turn) {
					winner = true;
					break;
				}
				
				// Checks for draw
				if (spacesTaken.size() == 9) {
					break;
				}
				
				// Switches turn
				if (turn == 'X') {
					turn = 'O';
				}
				else {
					turn = 'X';
				}
				
			} while (winner == false);
			
			// If winner, declare winner and end game; if draw, declare game as draw and end game
			if (winner == true) {
				System.out.println("       ===================");
				System.out.println("       " + turn + " IS YOUR WINNER!!!");
				System.out.println("       ===================");
			}
			else {
				System.out.println("         ===============");
				System.out.println("         Game is a draw.");
				System.out.println("         ===============");
			}
			
			System.out.println();
			System.out.println("=================================");
			System.out.println();
			
			// Ask if player wants to play again
			System.out.print("Would you like to play again? (y/n) - ");
			
			char playAgain;
			do {
				playAgain = Character.toUpperCase(scnr.next().charAt(0));
				if (playAgain != 'Y' && playAgain != 'N') {
					System.out.print("... ");
				}
			} while (playAgain != 'Y' && playAgain != 'N');
			
			System.out.println();
			
			// If yes, restart game; if not, end game
			if (playAgain == 'Y') {
				System.out.print("Restarting game...");
				try {
					Thread.sleep(1000); // delays for 1 second
				}
				catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
				for (int i = 0; i < 20; i++) {
					System.out.println();
				}
			}
			else {
				System.out.println("Goodbye...");
				endGame = true;
			}
			
		}
		
		System.exit(0);
		
	}

}
