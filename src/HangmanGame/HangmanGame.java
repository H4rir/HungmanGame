package HangmanGame;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HangmanGame {
    private Word word;
    private Set<Character> letterChar;
    private Set<Character> oldChar;
    private String sourceWord;
    private int maxAttempts;
    private int attemptsLeft;
    private Gallows gallows;
    private Scanner scanner;

    public HangmanGame() {
        this.word = new Word();
        this.letterChar = new HashSet<>();
        this.oldChar = new HashSet<>();
        this.maxAttempts = 6;
        this.attemptsLeft = maxAttempts;
        this.gallows = new Gallows();
        this.scanner = new Scanner(System.in);
    }

    public void play() {
        resetGame();
        sourceWord = word.getRandomWord();
        System.out.println("Загаданное слово: " + sourceWord);

        boolean isWordGuessed = false;

        while (!isWordGuessed && attemptsLeft > 0) {
            String starWord = createStarWord();
            System.out.println("Процесс разгадки: " + starWord);
            System.out.println("У вас осталось " + attemptsLeft + " попыток.");
            gallows.displayGallows(maxAttempts - attemptsLeft);

            System.out.print("Введите букву: ");
            String input = scanner.nextLine().toLowerCase();
            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Пожалуйста, введите одну букву.");
                continue;
            }
            if (!input.matches("[а-яёА-ЯЁ]")) {
                System.out.println("Пожалуйста, измените язык ввода на русский");
                continue;
            }

            char guessedLetter = input.charAt(0);
            if (oldChar.contains(guessedLetter)) {
                System.out.println("Вы уже вводили эту букву. Попробуйте другую.");
                continue;
            }

            oldChar.add(guessedLetter);

            if (sourceWord.indexOf(guessedLetter) >= 0) {
                letterChar.add(guessedLetter);
                System.out.println("Правильно!");
            } else {
                attemptsLeft--;
                System.out.println("Неправильно!");
            }
            if (createStarWord().equals(sourceWord)) {
                isWordGuessed = true;
                System.out.println("Поздравляем! Вы угадали слово: " + sourceWord);
            }
        }
        if (!isWordGuessed) {
            System.out.println("К сожалению, вы исчерпали все попытки. Загаданное слово было: " + sourceWord);
            gallows.displayGallows(maxAttempts);
        }
    }

    private String createStarWord() {
        StringBuilder starWord = new StringBuilder();
        for (char c : sourceWord.toCharArray()) {
            if (oldChar.contains(c)) {
                starWord.append(c);
            } else {
                starWord.append('*');
            }
        }
        return starWord.toString();
    }

    public boolean askToPlayAgain() {
        System.out.println("Хотите сыграть снова? (1 - да/ 2 - нет)");
        String response = scanner.nextLine().toLowerCase();
        return response.equals("1");
    }

    public void resetGame() {
        letterChar.clear();
        oldChar.clear();
        attemptsLeft = maxAttempts;
    }
}