package ru.otus.klem.hw16;

import java.util.*;

public class PhoneBook {

    private final Map<String, HashSet<String>> phoneBook = new HashMap<>();

    public void add(String name, String phone) {
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phone);
            System.out.println("Добавлен еще один номер к имени: " + name + " - " + phone);
        } else {
            phoneBook.put(name, new HashSet<>(Set.of(phone)));
            System.out.println("Добавлен в записную книжку: " + name + " - " + phone);
        }
    }

    public Set<String> find(String name) {
        return phoneBook.get(name);
    }

    public boolean containsPhoneNumber(String phone) {
        for (Map.Entry<String, HashSet<String>> numb : phoneBook.entrySet()) {
            for (String o : numb.getValue()) {
                if (o.equals(phone)) {
                    return true;
                }
            }
        }
        return false;
    }
}
