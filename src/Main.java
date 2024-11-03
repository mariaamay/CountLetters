import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Enter the title of the .txt file from /InputFiles without extension to read from:");
        Scanner in = new Scanner(System.in);
        String filename = in.nextLine().trim() + ".txt";
        String pathToFile = "./InputFiles/" + filename;


        System.out.println("Enter the title of the .txt file from /OutputFiles without extension to write to:");
        Scanner to = new Scanner(System.in);
        String fileToWriteTo = to.nextLine().trim() + ".txt";
        String pathToWrite = "./OutputFiles/" + fileToWriteTo;

        int[] letters;
        
        try {
            CheckFileExistsInInputFilesAndReadable(pathToFile); // существует ли?
            letters = ReadFromFile.readFromFile(pathToFile); // читаем
            CheckFileExistsInOutputFilesAndWritable(pathToWrite); // создаем файл для записи если его нет
            WriteToFile.writeToFile(pathToWrite, letters); // записываем

        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

    }

    // Функция для проверки существования и наличия прав чтения файла в /InputFiles
    public static void CheckFileExistsInInputFilesAndReadable(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found. Please make sure " + file.getName() + " is in /InputFiles");
        } else if (!file.canRead()) {
            throw new IOException("Cannot read the file: " + file.getName());
        }
    }

    /* Функция для проверки существования файла в /OutputFiles и наличия прав на запись в него,
    если файла не существует - создаем его */
    public static void CheckFileExistsInOutputFilesAndWritable(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        } else if (!file.canWrite()) {
            throw new IOException("Cannot write to file: " + file.getName());
        }
    }
}