package Model;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Registry {
    Charset UTF_8 = StandardCharsets.UTF_8;
    private final String file;

    public Registry(String file) {
        this.file = file;
    }

    public List<String> loadTextFromFile() {
        List<String> loadedList = Collections.emptyList();
        try {
            loadedList = Files.readAllLines(Paths.get(file));
        } catch (IOException e) {
            return null;
        }

        return loadedList;
    }

    public void saveTextToFile(List<String> listToSave) {
        try {
            Files.write(Paths.get(file), listToSave, UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
