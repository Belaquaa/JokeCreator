package JokeCreator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Scanner {
    public static String getPath() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Пожалуйста, укажите путь к папке:");
            return reader.readLine();
        } catch (IOException e) {
            System.err.println(STR."Ошибка при попытке чтения пути: \{e}");
            return null;
        }
    }
}