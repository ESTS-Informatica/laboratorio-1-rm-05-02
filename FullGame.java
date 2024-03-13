public class FullGame {
    private WordGuessingGame game;
    private InputReader reader;

    public FullGame() {
        this.game = new WordGuessingGame();
        this.reader = new InputReader();
    }

    public void play() {
        do {
            game.play();
            System.out.println("Do you want to play again? (S/n)");
            char response = reader.getChar("");
            if (response != 'S' && response != 's') {
                break;
            }
            game.reset();
        } while (true);

        System.out.println("Thank you for playing!");
    }

    public static void main(String[] args) {
        FullGame fullGame = new FullGame();
        fullGame.play();
    }
}
