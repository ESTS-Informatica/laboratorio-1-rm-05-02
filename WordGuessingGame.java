public class WordGuessingGame {
    private String hiddenWord;
    private String guessedWord;
    private int numberOfTries;
    private InputReader reader;
    private WordGenerator wordGenerator;

    public WordGuessingGame() {
        this.wordGenerator = new WordGenerator();
        this.hiddenWord = wordGenerator.generateWord();
        initializeGuessedWord();
        this.numberOfTries = 0;
        this.reader = new InputReader();
    }

    public void reset() {
        this.hiddenWord = wordGenerator.generateWord();
        initializeGuessedWord();
        this.numberOfTries = 0;
    }

    public String getHiddenWord() {
        return hiddenWord;
    }

    public String getGuessedWord() {
        return guessedWord;
    }

    public int getNumberOfTries() {
        return numberOfTries;
    }

    private void initializeGuessedWord() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.hiddenWord.length(); i++) {
            sb.append("_");
        }
        this.guessedWord = sb.toString();
    }

    private void showWelcome() {
        System.out.println("Welcome to the Word Guessing Game!");
    }

    public void showGuessedWord() {
        System.out.println(this.guessedWord);
    }

    private void guess(char letter) {
        boolean hasGuessedCorrectly = false;
        StringBuilder newGuessedWord = new StringBuilder(this.guessedWord);

        for (int i = 0; i < this.hiddenWord.length(); i++) {
            if (this.hiddenWord.charAt(i) == letter && this.guessedWord.charAt(i) == '_') {
                newGuessedWord.setCharAt(i, letter);
                hasGuessedCorrectly = true;
            }
        }

        if (hasGuessedCorrectly) {
            this.guessedWord = newGuessedWord.toString();
        } else {
            this.numberOfTries++;
        }
    }

    private void showResult() {
        System.out.println("Congratulations! You've guessed the word \"" + this.hiddenWord + "\" with " + this.numberOfTries + " incorrect guesses.");
    }

    public void play() {
        showWelcome();

        while (!this.guessedWord.equals(this.hiddenWord)) {
            showGuessedWord();
            char guessedChar = this.reader.getChar("Guess a letter: ");
            guess(guessedChar);
        }

        showGuessedWord();
        showResult();
    }

    public static void main(String[] args) {
        WordGuessingGame game = new WordGuessingGame();
        game.play();
    }
}
