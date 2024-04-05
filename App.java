package JokeCreator;

import java.io.File;

public class App {

    private static final boolean needCreate = true;
    // true  - создать файлы
    // false - удалить созданные файлы

    static class DirExists {
        public static File dirExists(String path) {
            if (path == null) return null;
            File directory = new File(path);
            if (directory.exists() || directory.isDirectory()) return directory;
            return null;
        }
    }

    public static void main(String[] args) {
        String path = Scanner.getPath();
        File directory = DirExists.dirExists(path);

        if (directory == null) {
            System.err.println("Указанного пути не существует!");
        } else {
            JokeCreator.createJokeFiles(directory, needCreate);
            System.out.println(needCreate ?
                    STR."Файлов создано: \{JokeCreator.getFilesCreate()}" :
                    STR."Файлов удалено: \{JokeCreator.getFilesCreate()}");
        }
    }
}
