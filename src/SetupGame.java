import java.util.Scanner;

public class SetupGame {

    public void setupGame() {
        System.out.println("Welcome to Hangman!");
        System.out.println();
        System.out.println("**************************************");
        System.out.println();
        System.out.println("Write 'start' to start the game");
        System.out.println();
        System.out.println("**************************************");
        System.out.println();
        System.out.println("Write 'exit' to exit the game");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if(input.equals("exit")) {
            System.exit(0);
        }
        if (input.equals("start")) {
            GameProcess gameProcess = new GameProcess();
            gameProcess.gameProcess();
        }
    }

    public static void main(String[] args) {
        SetupGame setupGame = new SetupGame();
        setupGame.setupGame();

    }
}