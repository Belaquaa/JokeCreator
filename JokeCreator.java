package JokeCreator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class JokeCreator {

    private static int filesChanged = 0;

    public static int getFilesCreate() {
        return filesChanged;
    }

    public static void createJokeFiles(File directory, boolean needCreate) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    if (needCreate) {
                        createJokeFileInDirectory(file);
                    } else {
                        deleteJokeFilesInDirectory(file);
                    }
                    createJokeFiles(file, needCreate); // продолжаем обход
                }
            }
        }
    }

    private static void createJokeFileInDirectory(File directory) {
        String jokeFilePath = STR."\{directory.getPath()}\{File.separator}joke.java";
        File jokeFile = new File(jokeFilePath);
        try {
            FileWriter writer = new FileWriter(jokeFile);
            writer.write(
                    "public class joke {\n" +
                            "\tpublic static void main(String[] args) {\n" +
                            "\t\tSystem.out.println(\"Hello, World! It's a joke #" + (filesChanged + 1) + "\");\n" +
                            "\t}\n" +
                            "}\n");
            writer.close();
            filesChanged++;

        } catch (FileNotFoundException e) {
            System.err.println(STR."Отказано в доступе: \{jokeFilePath}");
        } catch (IOException e) {
            System.err.println(STR."Ошибка при создании файла: \{jokeFilePath}");
            e.printStackTrace();
        }
    }

    private static void deleteJokeFilesInDirectory(File directory) {
        String jokeFilePath = STR."\{directory.getPath()}\{File.separator}joke.java";
        File jokeFile = new File(jokeFilePath);
        if (jokeFile.exists()) {
            boolean isDeleted = jokeFile.delete();
            if (isDeleted) {
                System.out.println(STR."Файл успешно удален: \{jokeFilePath}");
                filesChanged++;
            } else {
                System.err.println(STR."Не удалось удалить файл: \{jokeFilePath}");
            }
        }
    }
}