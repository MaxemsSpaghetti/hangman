import java.util.Scanner;

public class GameProcess {
    private char[] word;
    private char[] copyWord;
    private int countMistakes;
    private StringBuilder mistakes = new StringBuilder();
    private int unsolvedLetters;

    public void gamingProcess() {
        gameInitialising();
        while (countMistakes < 6 && unsolvedLetters > 0) {
            changeState();
        }
        GameResult.gameResult(countMistakes, unsolvedLetters);
    }

    public void gameInitialising() {
        String word1 = new Word().getWord();
        word = word1.toCharArray();
        copyWord = new char[word.length];
        unsolvedLetters = word.length;
        System.out.print("Word: ");
        for (int i = 0; i < word.length; i++) {
            copyWord[i] = '_';
            System.out.print(copyWord[i] + " ");
        }
    }

    public void changeState() {
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
        writeInConsole(letter);
    }

    public void writeInConsole(String letter) {
        HangmanVisualization.drawHangman(countMistakes);

        for (char c : copyWord) {
            System.out.print(c + " ");
        }

        System.out.println();
        System.out.println("mistakes (" + countMistakes + "): " + mistakes.toString());
        System.out.println("letter:" + letter);

    }
}
