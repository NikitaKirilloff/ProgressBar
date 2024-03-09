package controller;

import model.ModelTicTacToe;
import view.ViewTicTacToe;

import java.util.Scanner;

public class ControllerTicTacToe {
  private ModelTicTacToe model;
  private ViewTicTacToe view;
  private Scanner scanner;
  private int movesCounter = 0;
  private boolean player = true;

  public ControllerTicTacToe(ModelTicTacToe model, ViewTicTacToe view) {
    this.model = model;
    this.view = view;
    this.scanner = new Scanner(System.in);
  }

  public boolean startGame() {
    view.printBoard(model.board);
    return processMove();
  }

  private boolean processMove() {

    String currentPlayer = player ? this.model.player[0] : this.model.player[1];
    if (player) {
      view.printMessage("Ходит " + currentPlayer);
    } else {
      view.printMessage("Ходит " + currentPlayer);
    }
    String move = scanner.nextLine();
    int digit = checkMove(move);
    if (digit != -1) {
      if (model.makeMove(digit, currentPlayer)) {
        player = !currentPlayer.equals("Игрок 1");
        movesCounter++;
      } else {
        view.printMessage("Клетка заполнена, поставить знак на неё уже нельзя");
      }
    }
    if (model.checkWin(currentPlayer)) {
      view.printMessage("Победил " + currentPlayer + " поздравляем!");
      view.printBoard(model.board);
      return oneMoreGame();
    } else if (movesCounter == 9 && !model.checkWin(currentPlayer)) {
      view.printBoard(model.board);
      view.printMessage("Ничья!");
      return oneMoreGame();
    }
    return true;
  }

  private int checkMove(String move) {
    int intMove;
    try {
      intMove = Integer.parseInt(move);
      if (intMove < 1 || intMove > 9) {
        view.printMessage("Для игры используйте цифры от 1 до 9, лучше играть на NumPad");
        return -1;
      }
      return intMove;
    } catch (NumberFormatException e) {
      return -1;
    }
  }

  private boolean oneMoreGame() {
    view.printMessage("Если хотите сыграть ещё раз, введите Y, иначе введите любой символ");
    if (scanner.nextLine().equals("Y")) {
      model.fillingArray();
      movesCounter = 0;
      return true;
    } else {
      scanner.close();
      return false;
    }
  }
}