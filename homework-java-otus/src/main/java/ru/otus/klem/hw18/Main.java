package ru.otus.klem.hw18;
//Реализуйте приложение, позволяющее работать с текстовыми файлами
//При старте приложения, в консоль выводится список текстовых файлов из корневого каталоге проекта
//Далее программа запрашивает имя файла, с которым хочет работать пользователь
//Содержимое файла выводится в консоль
//Затем любую введенную пользователем строку необходимо записывать в указанный файл

import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("./src/main/java/ru/otus/klem/hw18/txtFile");
        System.out.println("файлы: ");
        for (File fileName : ChangeFile.textFilesList(file)) {
            System.out.println(fileName.getPath());
            //System.out.println(fileName.getName());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Какой файл читать ?");
        String readFile = scanner.nextLine();
        File fileToReadWrite = new File(readFile);
        try {
            ChangeFile.fileContent(fileToReadWrite);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            scanner.close();
            return;

        }

        System.out.println("Что добавить в файл");
        String whatToWriteString = scanner.nextLine();
        ChangeFile.writeToFile(fileToReadWrite, whatToWriteString);
        System.out.println("Файл переписан");
        scanner.close();
    }

}