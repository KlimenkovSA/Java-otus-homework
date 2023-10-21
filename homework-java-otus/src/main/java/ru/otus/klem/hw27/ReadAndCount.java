package ru.otus.klem.hw27;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadAndCount {
    static private final List<File> files = new ArrayList<>();

    public static void searchFiles(File path) {
        if (path.isFile() && path.getPath().contains(".txt")) {
            files.add(path);
        } else if (path.isDirectory()) {
            for (File f : Objects.requireNonNull(path.listFiles())) {
                searchFiles(f);
            }
        }
    }
    public static List<File> textFilesList(File path) {
        files.clear();
        searchFiles(path);
        return files;
    }

    public static int findMatches(File file, String String) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("файл не найден");
        }
        Pattern pattern = Pattern.compile(String);
        int counterMatches = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file.getPath()))) {
            String row = reader.readLine();
            while (row != null) {
                Matcher matcher = pattern.matcher(row);
                while (matcher.find()) {
                    counterMatches++;
                }
                System.out.println(row);
                row = reader.readLine();
            }

            return counterMatches;
        } catch (
                java.io.IOException e) {
            e.printStackTrace();
        }
        return counterMatches;
    }
}
