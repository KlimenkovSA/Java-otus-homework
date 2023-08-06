package ru.otus.klem.hw10;

import java.util.Date;

//Создайте класс Пользователь (User) с полями: фамилия, имя, отчество, год рождения, email;
//Реализуйте у класса конструктор, позволяющий заполнять эти поля при создании объекта;
//В классе Пользователь реализуйте метод, выводящий в консоль информацию о пользователе в виде:
//ФИО: фамилия имя отчество
//Год рождения: год рождения
//e-mail: email
//В методе main() Main класса создайте массив из 10 пользователей и заполните его объектами и с помощью цикла выведите информацию только о пользователях старше 40 лет.
//Попробуйте реализовать класс по его описания: объекты класса Коробка должны иметь размеры и цвет. Коробку можно открывать и закрывать. Коробку можно перекрашивать.
//Изменить размер коробки после создания нельзя. У коробки должен быть метод, печатающий информацию о ней в консоль. В коробку можно складывать предмет (если в ней нет предмета),
//или выкидывать его оттуда (только если предмет в ней есть), только при условии что коробка открыта (предметом читаем просто строку). Выполнение методов должно сопровождаться выводом сообщений в консоль.
public class MainApplication {
    public static void main(String[] args) {
        User[] users = {
                new User("Sergey", "Klimenkov", "Anatolevich", 1987, "klem72@mail.ru"),
                new User("Rob", "Truhilio", "Andreevich", 1977, "Bass2@mail.ru"),
                new User("Jason", "Newsted", "Aristarhovich", 1966, "Bass1@mail.ru"),
                new User("Lars", "Ylrich", "Vladimirovich", 1985, "Drums@mail.ru"),
                new User("James", "Hatfield", "Dmitrievicb", 1963, "Vocal@mail.ru"),
                new User("Kirk", "Hammet", "Ivanovich", 1967, "Guitar@mail.ru"),
        };

        Date dt = new Date();
        int year = dt.getYear();
        int current_Year = year + 1900;

        for (int i = 0; i < users.length; i++) {
            if (users[i].getYearOfBirth() <= current_Year - 40) {
                users[i].info();
            }
        }

        Box Box = new Box(3, 4, "черный", false, "");

        Box.setBoxCondition(true);
        Box.setColor("белый");
        Box.setItem("кот");
        Box.setItem("собака");
        Box.delItem();
        Box.info();
    }

}
