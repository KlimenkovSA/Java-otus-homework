package ru.otus.klem.hw16;

import java.util.*;

//Реализуйте класс PhoneBook, который хранит в себе список имен (фио) и телефонных номеров;
//Метод add() должен позволять добавлять запись имя-телефон;
//Метод find() выполнять поиск номер(-а, -ов) телефона по имени;
//Под одним именем может быть несколько телефонов (в случае однофамильцев, или наличии у одного человека нескольких номеров), тогда при запросе такой фамилии должны выводиться все телефоны;
//Метод containsPhoneNumber должен проверять наличие телефона в справочнике.
public class Main {
    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Rob", "892611133366");
        phoneBook.add("Lars", "890911122233");
        phoneBook.add("Kirk", "822277700011");
        phoneBook.add("Rob", "892611133300");
        phoneBook.add("Lars", "890911122211");

        String Name = "Lars";           //запрос имени
        String Phone = "899900055521";  //запрос телефона

        Set<String> rez = phoneBook.find(Name);
        if (rez == null) {
            System.out.println("Имя не найдено");
        } else {
            System.out.println("По запрашиваемому имени найдены номера: " + rez);
        }

        boolean rezPhoneNumb = phoneBook.containsPhoneNumber(Phone);
        if (!rezPhoneNumb) {
            System.out.println("Запрашиваемый номер не найден");
        } else {
            System.out.println("Запрашиваемый номер найден");
        }
    }
}
