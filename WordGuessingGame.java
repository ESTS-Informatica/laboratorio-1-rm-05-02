
public class WordGuessingGame {
    private String hiddenWord;
    private String guessedWord;
    private int numberOfTries;
    private InputReader reader; // Nivel 2

    public WordGuessingGame() {
        this.hiddenWord = "abc";
        this.guessedWord = "___";
        this.numberOfTries = 0;
        this.reader = new InputReader(); // Nivel 2
    }

    public static void main(String[] args) {
        WordGuessingGame game = new WordGuessingGame();
        game.showGuessedWord();
    }

    public void play() { // Nivel 2
        showWelcome();
        while (!this.guessedWord.equals(this.hiddenWord)) {
            showGuessedWord();
            char guessedWorld = this.reader.getChar("Guess a ?");
        }
        showGuessedWord();
        showResult();
    }

    public void guess(char letter) { // Nivel 2
        boolean hasGuessedCorrectly = false;
        StringBuilder newGuessedWord = new StringBuilder(this.guessedWord);

        for (int i = 0; i < this.hiddenWord.length(); i++) {
            if (this.hiddenWord.charAt(i) == letter && this.guessedWord.charAt(i) == '_') {
                newGuessedWord.setCharAt(i, letter);
                hasGuessedCorrectly = true;
            }
        }

        this.guessedWord = newGuessedWord.toString();

        if (!hasGuessedCorrectly) {
            this.numberOfTries++;
        }
    }

    public void showGuessedWord() {
        System.out.println(this.guessedWord);
    }
    public void showWelcome () { // Nivel 2
        System.out.println("Welcome the Gme");
    }

    public void showGuessedWorld() { // Nivel 2
        System.out.println("Congratulation for the game" + this.hiddenWord);
    }

    public void showResult() { //Nivel 2
        System.out.println("Nice game :)" + this.hiddenWord + "With" + this.numberOfTries + "Incorrect question");
    }

    public String getGuessedWord() {
        return guessedWord;
    }

    public  String getHiddenWord() {
        return hiddenWord;
    }

    public int getNumberOfTries() {
        return numberOfTries;
    }

}
