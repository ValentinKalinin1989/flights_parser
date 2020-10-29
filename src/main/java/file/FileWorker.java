package file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * class for work with file
 */
public class FileWorker {
    /**
     * read text as string from file
     *
     * @param path - path to file
     * @return - string
     */
    public static String readTextFromFile(String path) {
        String text = null;
        try {
            text = Files.readString(Path.of(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}
