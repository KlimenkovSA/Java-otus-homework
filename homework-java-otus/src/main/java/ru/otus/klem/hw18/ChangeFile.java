package ru.otus.klem.hw18;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ChangeFile {
    static private final List<File> fileСontent = new ArrayList<>();

    public static void searchFiles(File path) {
        if (path.isFile() && path.getPath().contains(".txt")) {
            fileСontent.add(path);
        } else if (path.isDirectory()) {
            for (File eachFile : path.listFiles()) {
                searchFiles(eachFile);
            }
        }
    }

    public static List<File> textFilesList(File path) {
        searchFiles(path);
        return fileСontent;
    }

    public static void fileContent(File file) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("не найден файл");
        }
        try (
                FileInputStream fileIn = new FileInputStream(file.getPath());
                BufferedInputStream bufferIn = new BufferedInputStream(fileIn);
                InputStreamReader in = new InputStreamReader(bufferIn)) {
            char[] buf = new char[1000];
            int n = in.read(buf);
            while (n > 0) {
                for (int i = 0; i < n; i++) {
                    System.out.print(buf[i]);
                }
                n = in.read(buf);
            }
            System.out.println();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(File fileToWrite, String data) {
        data = "\n" + data;
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fileToWrite, true))) {
            byte[] buffer = data.getBytes(StandardCharsets.UTF_8);
            out.write(buffer);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
