package repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Работа с файлом
 */
public class UserDao implements IFileDao {

    public static UserDao INSTANCE = new UserDao();

    private UserDao() {
    }

    /**
     * Запись данных в файл
     *
     * @param data данные из элементов
     */
    @Override
    public void saveToFile(String data) {
        File file = new File("users.txt");
        if (!file.exists()) {
            try {
                //noinspection ResultOfMethodCallIgnored
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(data + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Чтение строки (элементов) данных
     *
     * @return коллекция данных
     */
    @Override
    public List<String> readFromFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("users.txt"))) {
            return bufferedReader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    /**
     * Удаление файла
     */
    @Override
    public void deleteFile() {
        File file = new File("users.txt");
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert writer != null;
        writer.print("");
        writer.close();
    }
}
