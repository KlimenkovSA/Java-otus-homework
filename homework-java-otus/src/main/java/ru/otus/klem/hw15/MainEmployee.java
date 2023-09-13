package ru.otus.klem.hw15;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий список их имен;
//Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный возраст, и возвращающий список сотрудников, возраст которых больше либо равен указанному аргументу;
//Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный средний возраст, и проверяющий что средний возраст сотрудников превышает указанный аргумент;
//Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий ссылку на самого молодого сотрудника.
public class MainEmployee {
    public static void main(String[] args) {
        List<Employee> personList = new ArrayList<>();
        personList.add(new Employee("Kirk", 67));
        personList.add(new Employee("Sergey", 35));
        personList.add(new Employee("Mike", 54));
        personList.add(new Employee("Carl", 21));
        personList.add(new Employee("Jayson", 44));

        System.out.println(getListNames(personList));
        System.out.println(getAges(personList, 40));
        System.out.println(middleAges(personList, 45));
        System.out.println(mostYoungEmpl(personList));
    }

    public static List<String> getListNames(List<Employee> personList) {
        //вариант1
//        List<String> arrForNames = new ArrayList<>();
//        for (int i = 0; i < personList.size(); i++) {
//            arrForNames.add(personList.get(i).getName());
//        }
        //вариант2
        List<String> arrForNames = new ArrayList<>();
        Iterator<Employee> iterator = personList.iterator();
        while (iterator.hasNext()) {
            arrForNames.add(iterator.next().getName());
        }
        return arrForNames;
    }

    public static List<String> getAges(List<Employee> personList, int minAge) {
        List<String> newList = new ArrayList<>();
        for (Employee employee : personList) {
            if (employee.getAge() >= minAge) {
                newList.add(employee.getName());
            }
        }
        return newList;
    }

    public static boolean middleAges(List<Employee> personList, int minMiddleAge) {
        int sumOfages = 0;
        for (Employee employee : personList) {
            sumOfages += employee.getAge();
        }
        int rezMiddleAge = sumOfages / personList.size();
        System.out.println(rezMiddleAge);
        return rezMiddleAge < minMiddleAge;
    }

    public static Employee mostYoungEmpl(List<Employee> personList) {
        int first = personList.get(0).getAge();
        int nameIndex = 0;
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getAge() < first) {
                first = personList.get(i).getAge();
                nameIndex = i;
            }
        }
        return personList.get(nameIndex);
    }

}
