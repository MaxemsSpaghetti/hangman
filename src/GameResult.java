public class GameResult {
    public static void gameResult(int countMistakes, int unsolvedLetters) {
        if (countMistakes == 6) {
            lostGame();
        } else if (unsolvedLetters == 0) {
            winGame();
        }
    }

    public static void lostGame() {
        System.out.println("\n" + "\n" + "\n");
        System.out.println("**************************************");
        System.out.println(            "Unfortunately");
        System.out.println(          "you lost the game");
        System.out.println(          "Word was " + GameProcess.getWord());
        System.out.println("**************************************");
        System.out.println("\n" + "\n" + "\n");
    }

    public static void winGame() {
        System.out.println("\n" + "\n" + "\n");
        System.out.println("**************************************");
        System.out.println(            "Congratulation");
        System.out.println(           "you won the game");
        System.out.println(          "Word was " + GameProcess.getWord());
        System.out.println("**************************************");
        System.out.println("\n" + "\n" + "\n");
    }
}
