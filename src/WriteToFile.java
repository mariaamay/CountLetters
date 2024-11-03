import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    // Если буква встретилась 0 раз - не записываем это в файл
    public static void writeToFile(String filename, int[] letters) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < letters.length; i++) {
                if (letters[i] > 0) {
                    char letter = (char) (i < 26  ? 'A' + i : 'a' + (i - 26));
                    bw.write(letter + ": " + letters[i]);
                    bw.newLine();
                }

            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        System.out.println("Success! File written to " + filename);
    }
}
