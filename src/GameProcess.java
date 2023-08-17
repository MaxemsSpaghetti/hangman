import java.util.ArrayList;
import java.util.List;

public class GameProcess {
    private List<String> word;
    private List<String> copyWord = new ArrayList<>();
    private int countMistakes;
    private StringBuilder mistakes = new StringBuilder();
    private int unsolvedLetters;

    public void gamingProcess() {
        gameInitialising();
        while (!isGameOver()) {
            writeInConsole();
        }
        new GameResult().gameResult(countMistakes, unsolvedLetters, String.join("", word));
    }

    public void gameInitialising() {
        Dictionary dictionary = new Dictionary();
        dictionary.createFilteredDictionary();
        word = dictionary.createRandomWord();
        unsolvedLetters = word.size();
        for (int i = 0; i < word.size(); i++) {
            copyWord.add("_");
        }
    }

    public boolean isGameOver() {
        return countMistakes == 6 || unsolvedLetters == 0;
    }

    public void changeState(String letter) {
        int tmp = unsolvedLetters;

        for (int i = 0; i < word.size(); i++) {
            if (word.get(i).equals(letter)) {
                copyWord.set(i, letter);
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

    public void writeInConsole() {
        for (String c : copyWord) {
            System.out.print(c + " ");
        }
        System.out.println();
        System.out.println("Write a letter: ");
        String letter = Hangman.getScanner();
        if (copyWord.stream().anyMatch(c -> c.equals(letter)) || mistakes.indexOf(letter) != -1) {
            System.out.println();
            System.out.println("The entered letter has already been used");
            System.out.println();
        } else if (letter.matches("[^а-яА-Я]") || letter.length() != 1) {
            System.out.println();
            System.out.println("The entered character must be one letter of the Russian alphabet");
            System.out.println();
        } else {
            changeState(letter);
        }
        System.out.println("mistakes (" + countMistakes + "): " + mistakes.toString());
        HangmanVisualization.drawHangman(countMistakes);
    }
}

