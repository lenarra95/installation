import java.io.*;

public class Main {
    public static void main (String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] dirsForGames = {"src", "res", "savegames", "temp"};
        String[] dirsForSrc = {"main", "test"};
        String[] filesForMain = {"Main.java", "Utils.java"};
        String[] dirsForRes = {"drawables", "vectors", "icons"};
        String[] tempFile = {"temp.txt"};
        for (String dir : dirsForGames) {
            stringBuilder.append(createDir("", dir));
        }
        for (String dir : dirsForSrc) {
            stringBuilder.append(createDir("src", dir));
        }
        for (String file : filesForMain) {
            stringBuilder.append(createFile("src/main", file));
        }
        for (String dir : dirsForRes) {
            stringBuilder.append(createDir("res", dir));
        }
        for (String dir : tempFile) {
            stringBuilder.append(createFile("temp", dir));
        }
        addInfoIntoTempFile(stringBuilder.toString());
    }

    public static void addInfoIntoTempFile (String info) {
        try (BufferedWriter dw = new BufferedWriter(new FileWriter("Games/temp/temp.txt", true))) {
            dw.write(info);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String createDir (String parentDir, String newDirPath) {
        File newDir = new File("Games/" + parentDir, newDirPath);
        return newDir.mkdir() ? "Папка '" + newDir.getName() + "' создалась успешно!\n" :
                "Папка '" + newDir.getName() + "'  НЕ создалась\n";
    }

    public static String createFile (String parentDir, String newFilePath) {
        File newDir = new File("Games/" + parentDir, newFilePath);
        try {
            return newDir.createNewFile() ? "Файл '" + newDir.getName() + "' создалась успешно!\n" :
                    "Файл '" + newDir.getName() + "'  НЕ создалась\n";
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}
