package HangmanGame;

public class Gallows {
    private String[] stages;

    public Gallows() {
        this.stages = new String[] {
                "  +---+\n" +
                        "      |\n" +
                        "      |\n" +
                        "      |\n" +
                        "    ===",

                "  +---+\n" +
                        "  O   |\n" +
                        "      |\n" +
                        "      |\n" +
                        "    ===",

                "  +---+\n" +
                        "  O   |\n" +
                        "  |   |\n" +
                        "      |\n" +
                        "    ===",

                "  +---+\n" +
                        "  O   |\n" +
                        " /|   |\n" +
                        "      |\n" +
                        "    ===",

                "  +---+\n" +
                        "  O   |\n" +
                        " /|\\  |\n" +
                        "      |\n" +
                        "    ===",

                "  +---+\n" +
                        "  O   |\n" +
                        " /|\\  |\n" +
                        " /    |\n" +
                        "    ===",

                "  +---+\n" +
                        "  O   |\n" +
                        " /|\\  |\n" +
                        " / \\  |\n" +
                        "    ==="
        };
    }

    public void displayGallows(int wrongAttempts) {
        System.out.println(stages[wrongAttempts]);
    }
}