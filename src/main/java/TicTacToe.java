import controller.ControllerTicTacToe;
import model.ModelTicTacToe;
import view.ViewTicTacToe;

public class TicTacToe {
  public static void main(String[] args) {
    System.out.println("Игра крестики-нолики, играют 2 игрока, ходят последовательно,");
    System.out.println("пользоваться нужно только NumPad, представьте свой NumPad как доску 3х3");
    System.out.println("нажмите на цифру, куда хотите поставить свой знак, после нажмите Enter.");
    System.out.println("Игрок 1 - ходит X, Игрок 2 ходит O");
    ModelTicTacToe model = new ModelTicTacToe();
    ViewTicTacToe view = new ViewTicTacToe();
    ControllerTicTacToe controller = new ControllerTicTacToe(model, view);
    System.out.println();

    while (controller.startGame());
  }
}
