package com.yachtclub.technicalservices.persistence;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class TextFileDataBase {
    Charset UTF_8 = StandardCharsets.UTF_8;
    private final String fileName;

    public TextFileDataBase(String fileName) {
        this.fileName = fileName;
    }

    public List<String> loadTextFromFile() {
        List<String> loadedList = Collections.emptyList();
        try {
            loadedList = Files.readAllLines(Paths.get(fileName), UTF_8);
        } catch (IOException e) {
            return null;
        }

        return loadedList; // todo
    }

    public void saveTextToFile(List<String> listToSave) {
        try {
            Files.write(Paths.get(fileName), listToSave, UTF_8);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
