package ru.otus.klem.hw17;

import java.util.List;

public interface SearchTree {
    Integer find(Integer element);
    List<Node> getSortedList();
}