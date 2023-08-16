import java.io.IOException;
import java.util.Scanner;

public class GameProcess {
    private static char[] word;
    private char[] copyWord;
    private int countMistakes;
    private StringBuilder mistakes = new StringBuilder();
    private int unsolvedLetters;

    public void gamingProcess() {
        gameInitialising();
        while (countMistakes < 6 && unsolvedLetters > 0) {
            writeInConsole();
        }
        GameResult.gameResult(countMistakes, unsolvedLetters);
    }

    public void gameInitialising() {
        String word1;
            word1 = new Word().getWord();
        word = word1.toCharArray();
        copyWord = new char[word.length];
        unsolvedLetters = word.length;
        for (int i = 0; i < word.length; i++) {
            copyWord[i] = '_';
        }
    }

    public void changeState(String letter) {
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
    }

    public String inputLetter() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void writeInConsole() {
        System.out.println();
        for (char c : copyWord) {
            System.out.print(c + " ");
        }
        System.out.println();
        System.out.println("Write a letter: ");
        String letter = inputLetter();
        if (mistakes.indexOf(letter) == -1 && letter.matches("[а-яА-Я]+")) {
            changeState(letter);
        } else {
            System.out.println();
            System.out.println("the entered character must be a letter of the Russian alphabet," +
                    " which has not been used before");
        }
        System.out.println();
        System.out.println("mistakes (" + countMistakes + "): " + mistakes.toString());
        System.out.println();
        HangmanVisualization.drawHangman(countMistakes);
        System.out.println();
    }

    public static String getWord() {
        return new String(word);
    }
}
