public class GameResult {
    public void gameResult(int countMistakes, int unsolvedLetters, String word) {
        if (countMistakes == 6) {
            lostGame(word);
        } else if (unsolvedLetters == 0) {
            winGame(word);
        }
    }

    public void lostGame(String word) {
        System.out.println("\n" + "\n" + "\n");
        System.out.println("**************************************");
        System.out.println(            "Unfortunately");
        System.out.println(          "you lost the game");
        System.out.println(          "Word was " + word);
        System.out.println("**************************************");
        System.out.println("\n" + "\n" + "\n");
    }

    public void winGame(String word) {
        System.out.println("\n" + "\n" + "\n");
        System.out.println("**************************************");
        System.out.println(            "Congratulation");
        System.out.println(           "you won the game");
        System.out.println(          "Word was " + word);
        System.out.println("**************************************");
        System.out.println("\n" + "\n" + "\n");
    }
}
