import java.util.Scanner;

public class Hangman {

    private static Scanner scanner;

    public static String getScanner() {
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to Hangman!");
            System.out.println();
            System.out.println("the game contains only Russian nouns in the nominative case");
            System.out.println("**************************************");
            System.out.println();
            System.out.println("Write '1' to start the game");
            System.out.println();
            System.out.println("**************************************");
            System.out.println();
            System.out.println("Write '0' to exit the game");
            System.out.println();
            System.out.println("**************************************");
            System.out.println();
            String input = getScanner();
            if (input.equals("1")) {
                GameProcess gameProcess = new GameProcess();
                gameProcess.gamingProcess();
            }
            if (input.equals("0")) {
                System.exit(0);
            }
        }
    }
}