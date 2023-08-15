import java.util.Scanner;

public class GameProcess {
    private char[] word;
    private char[] copyWord;
    private int countMistakes;
    private StringBuilder mistakes = new StringBuilder();
    private int unsolvedLetters;

    public void game() {
        System.out.println();
        System.out.println("Write a letter: ");
        Scanner scanner = new Scanner(System.in);
        String letter = scanner.nextLine();
        int tmp = unsolvedLetters;

        for (int i = 0; i < word.length; i++) {
            if (word[i] == letter.charAt(0)) {
                copyWord[i] = letter.charAt(0);
                unsolvedLetters--;
            }
        }

        if (tmp == unsolvedLetters) {
            if (mistakes.length() != 0) {
                mistakes.append(", ");
            }
            mistakes.append(letter);
            countMistakes++;
        }
        HangmanVisualization.drawHangman(countMistakes);

        for (char c : copyWord) {
            System.out.print(c + " ");
        }
        System.out.println();

        System.out.println("mistakes (" + countMistakes + "): " + mistakes.toString());
        System.out.println("letter:" + letter);
    }

    public void gameProcess() {
        String word1 = new Word().getWord();
        word = word1.toCharArray();
        copyWord = new char[word.length];
        unsolvedLetters = word.length;
        System.out.print("Word: ");
        for (int i = 0; i < word.length; i++) {
            copyWord[i] = '_';
            System.out.print(copyWord[i] + " ");
        }
        while (true) {
            game();
            if (countMistakes == 6) {
                gameLose();
            } else if (unsolvedLetters == 0) {
                gameWin();
            }
        }
    }

    public void gameLose() {
        System.out.println();
        System.out.println("**************************************");
        System.out.println(         "Unfortunately");
        System.out.println(        "you lost the game");
        System.out.println("**************************************");
        System.out.println("\n" + "\n" + "\n" + "\n" + "\n");
        SetupGame setupGame = new SetupGame();
        setupGame.setupGame();
    }

    public void gameWin() {
        System.out.println();
        System.out.println("**************************************");
        System.out.println(            "Congratulation");
        System.out.println(           "you won the game");
        System.out.println("**************************************");
        System.out.println("\n" + "\n" + "\n" + "\n" + "\n");
        SetupGame setupGame = new SetupGame();
        setupGame.setupGame();
    }
}
