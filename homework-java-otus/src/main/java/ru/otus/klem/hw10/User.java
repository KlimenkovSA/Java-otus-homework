package ru.otus.klem.hw10;

public class User {
    private String name;
    private String lastName;
    private String surname;
    private int yearOfBirth;
    private String mail;


    public User(String name, String lastName, String surname, int yearOfBirth, String mail) {
        this.name = name;
        this.lastName = lastName;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
        this.mail = mail;

    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void info() {
        System.out.println("ФИО: " + lastName + " " + name + " " + surname);
        System.out.println("Год рождения: " + yearOfBirth);
        System.out.println("e-mail: " + mail);
        System.out.println("");
    }

}
