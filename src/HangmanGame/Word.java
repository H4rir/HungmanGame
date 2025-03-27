package HangmanGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Word {
    private List<String> words;

    public Word() {
        this.words = loadWordsFromFile();
    }

    private List<String> loadWordsFromFile() {
        List<String> list = new ArrayList<>();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("HangmanGame/Word.txt").getFile());

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.length() >= 4) {
                    list.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return list;
    }

    public String getRandomWord() {
        if (words.isEmpty()) {
            throw new RuntimeException("Список слов пуст.");
        }
        int randomIndex = (int) (Math.random() * words.size());
        return words.get(randomIndex);
    }

    public List<String> getWordList() {
        return words;
    }

    public void addWord(String newWord) {
        words.add(newWord);
    }

    public void removeWord(String wordToRemove) {
        words.remove(wordToRemove);
    }
}