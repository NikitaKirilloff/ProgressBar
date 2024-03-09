package model;

public class ModelTicTacToe {
  public char[][] board = new char[5][11];
  public String[] player = new String[]{"Игрок 1", "Игрок 2"};
  private int movesCounter = 0;

  public ModelTicTacToe() {
    this.board = fillingArray();

  }

  public char[][] fillingArray() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (i == 0 || i == 2 || i == 4) {
          if (j == 3 || j == 7) {
            board[i][j] = '|';
          } else {
            board[i][j] = ' ';
          }
        }
        if (i == 1 || i == 3) {
          board[i][j] = '_';
        }
      }
    }
    return board;
  }

  public boolean makeMove(int digit, String currentPlayer) {
    char symbol = currentPlayer.equals("Игрок 1") ? 'X' : 'O';
    int line = indexLineArray(digit);
    int column = indexColumnArray(digit);

    for (int i = 0; i < board.length; i += 2) {
      for (int j = 1; j < board[i].length; j += 4) {
        if (board[line][column] == ' ') {
          board[line][column] = symbol;
          ++movesCounter;
          return true;
        }
      }
    }
    return false;
  }

  public boolean checkWin(String currentPlayer) {
    char symbol = currentPlayer.equals("Игрок 1") ? 'X' : 'O';
    if (movesCounter == 9 && !checkSymbolForWin(symbol)) {
      return false;
    } else if (movesCounter > 4) {
      return checkSymbolForWin(symbol);
    }
    return false;
  }

  public int checkDraw() {
    if (movesCounter == 9) {
      return movesCounter;
    }
    return -1;
  }

  private boolean checkSymbolForWin(char symbol) {
    int count = 0;
    for (int i = 0; i < board.length; i += 2) {
      for (int j = 1; j < board[i].length; j += 4) {
        if (board[i][j] == symbol && count < 3) {
          count++;
        }
        if (count == 3) {
          return true;
        }
      }
      count = 0;
    }
    for (int i = 1; i < board[0].length; i += 4) {
      for (int j = 0; j < board.length; j += 2) {
        if (board[j][i] == symbol && count < 3) {
          count++;
        }
        if (count == 3) {
          return true;
        }
      }
      count = 0;
    }
    for (int i = 0; i < 1; i++) {
      if (board[i][i + 1] == symbol) {
        if (board[i + 2][i + 5] == symbol) {
          count++;
        }
        if (board[i + 4][i + 9] == symbol) {
          count++;
        }
        count++;
      }
      if (board[i][i + 9] == symbol) {
        if (board[i + 2][i + 5] == symbol) {
          count++;
        }
        if (board[i + 4][i + 1] == symbol) {
          count++;
        }
        count++;
      }
      if (count >= 3) {
        return true;
      }
    }
    return false;
  }

  private int indexLineArray(int digit) {
    if (digit > 6 && digit < 10) {
      return 0;
    } else if (digit > 3 && digit < 7) {
      return 2;
    } else if (digit > 0 && digit < 4) {
      return 4;
    }
    return -1;
  }

  private int indexColumnArray(int digit) {
    if (digit == 7 || digit == 4 || digit == 1) {
      return 1;
    } else if (digit == 8 || digit == 5 || digit == 2) {
      return 5;
    } else if (digit == 9 || digit == 6 || digit == 3) {
      return 9;
    }
    return -1;
  }
}