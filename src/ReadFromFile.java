import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile {

    private static final int TOTAL_LETTERS = 52; // 26 заглавные + 26 строчные

    public static int[] readFromFile(String path_to_file) {
        StringBuilder result = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(path_to_file))) {
            String line;
            while ((line = br.readLine()) != null) {
                result.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return countLetters(result.toString());
    }

    // Функция которая считает сколько раз встречается каждая буква
    private static int[] countLetters(String str) {
        int[] englishLetters = new int[TOTAL_LETTERS];
        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                englishLetters[c - 'A']++;
            } else if (c >= 'a' && c <= 'z') {
                englishLetters[c - 'a' + 26]++;
            }
        }
        return englishLetters;
    }
}
