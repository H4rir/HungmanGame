package HangmanGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HangmanGame hangmanGame = new HangmanGame();
        System.out.println("Добро пожаловать в игру 'Виселица'!");//Приветствие

        while (true) {
            System.out.println("Нажмите 1, чтобы начать игру.");
            System.out.println("Нажмите 2, чтобы выйти.");

            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                while (true) {
                    hangmanGame.play();

                    if (!hangmanGame.askToPlayAgain()) {
                        System.out.println("Спасибо за игру! До свидания!");
                        scanner.close();
                    }
                }
            } else if (choice.equals("2")) {
                System.out.println("Спасибо за игру! До свидания!");
                break;
            } else {
                System.out.println("Неверный ввод. Пожалуйста, выберите 1 или 2.");
            }
        }

        scanner.close();
    }
}