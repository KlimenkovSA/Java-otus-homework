package ru.otus.klem.hw27;

import java.io.*;
import java.util.Scanner;
//Реализуйте метод, который подсчитывает сколько раз в текстовом файле (с кодировкой UTF-8) встречается указанная последовательность символов с учетом регистра;
//При запуске приложения пользователь вводит имя файла и искомую последовательность символов, программа должна выполнить расчет и напечатать результат в консоль.

public class Main {
    public static void main(String[] args) throws IOException {
        //.\src\main\java\ru\otus\klem\hw27\sometext.txt
        File file = new File("./src");
        for (File fileName : ReadAndCount.textFilesList(file)) {
            System.out.println("В директории ./src найден файл: " + fileName.getPath());
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла: " );
        String chosenFile = scanner.nextLine();
        System.out.println("Введите последовательность символов: ");
        String characters = scanner.nextLine();
        File fileForRead = new File(chosenFile);
        try {
            System.out.println("Найдено: " + ReadAndCount.findMatches(fileForRead, characters));
        } catch (FileNotFoundException fileNotFound) {
            System.out.println(fileNotFound.getMessage());
            scanner.close();
        }
    }
}


