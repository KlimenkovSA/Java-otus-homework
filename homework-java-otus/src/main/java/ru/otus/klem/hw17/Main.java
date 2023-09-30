package ru.otus.klem.hw17;

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
    static Tree tree = new Tree();
    public static void main(String[] args) {

        System.out.println(tree.getSortedList());
        System.out.println(tree.find(10));
        System.out.println(tree.find(18));


    }
}
