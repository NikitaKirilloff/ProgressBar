package view;

public class ViewTicTacToe {
  public void printBoard(char[][] board) {
    System.out.println();
    for (int i = 0; i < board.length; i++) {
      System.out.println(board[i]);
    }
    System.out.println();
  }

  public void printMessage(String message) {
    System.out.println(message);
  }
}