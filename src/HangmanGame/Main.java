package HangmanGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в игру 'Виселица'!");
        while (true) {
            System.out.println("Нажмите 1, чтобы начать игру.");
            System.out.println("Нажмите 2, чтобы выйти.");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                while (true) {
                    HangmanGame hangmanGame = new HangmanGame();
                    hangmanGame.play();
                    if (!hangmanGame.askToPlayAgain()) {
                        System.out.println("Спасибо за игру! До свидания!");
                        scanner.close();
                        return;
                    }
                }
            } else if (choice.equals("2")) {
                System.out.println("Спасибо за игру! До свидания!");
                scanner.close();
                return;
            } else {
                System.out.println("Неверный ввод. Пожалуйста, выберите 1 или 2.");
            }
        }
    }
}
