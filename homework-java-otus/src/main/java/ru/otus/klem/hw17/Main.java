package ru.otus.klem.hw17;

import java.util.List;

import static ru.otus.klem.hw17.Tree.rangeFilling;

//Из Предварительно отсортированного списка (List) сформировать двоичное дерево поиска
//Написать рекурсивную функцию поиска в сформированном дереве
//Класс должен имплементировать следующий интерфейс
//public interface SearchTree {
///**
// @param element to find
// @return element if exists, otherwise - null
// /
// T find(T element);
// List getSortedList();
// }
public class Main {
    public static void main(String[] args) {
        List<Integer> list = rangeFilling(1, 17);
        SearchTree searchTree = new Tree(list);
        System.out.println(searchTree.find(11));
        System.out.println(searchTree.find(18));
    }
}
