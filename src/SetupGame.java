import java.util.Scanner;

public class SetupGame {

    public void setupGame() {
        while (true) {
            System.out.println("Welcome to Hangman!");
            System.out.println();
            System.out.println("**************************************");
            System.out.println();
            System.out.println("Write '1' to start the game");
            System.out.println();
            System.out.println("**************************************");
            System.out.println();
            System.out.println("Write '0' to exit the game");
            System.out.println("**************************************");
            System.out.println();
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if(input.equals("0")) {
                System.exit(0);
            }
            if (input.equals("1")) {
                GameProcess gameProcess = new GameProcess();
                gameProcess.gamingProcess();
            }
        }
    }

    public static void main(String[] args) {
        SetupGame setupGame = new SetupGame();
        setupGame.setupGame();

    }
}