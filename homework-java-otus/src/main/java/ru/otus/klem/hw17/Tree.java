package ru.otus.klem.hw17;

import java.util.ArrayList;
import java.util.*;

public class Tree implements SearchTree {
    private Node root;
    public List<Integer> sortedList = new ArrayList<>();

    public Tree(List<Integer> list) {
        Collections.sort(list);
        if (list.isEmpty()) {
            root = null;
        }
        root = nodeInsert(list, 0, list.size() - 1);
    }

    private Node nodeInsert(List<Integer> list, int first, int last) {
        if (first > last) {
            return null;
        }
        int middle = (first + last) / 2;
        Node newNode = new Node(list.get(middle));
        newNode.left = nodeInsert(list, first, middle - 1);
        newNode.right = nodeInsert(list, middle + 1, last);
        return newNode;
    }

    @Override
    public Integer find(Integer element) {
        return get(root, element);
    }

    private Integer get(Node root, Integer element) {
        if (null == root) return null;
        int cmp = element.compareTo(root.value);
        if (cmp < 0) {
            return get(root.left, element);
        } else if (cmp > 0) {
            return get(root.right, element);
        } else {
            return root.value;
        }
    }

    public static List<Integer> rangeFilling(int min, int max) {
        List<Integer> arrayList = new ArrayList<>();
        for (int i = min; i <= max; i += 1) {
            arrayList.add(i);
        }
        return arrayList;
    }

    @Override
    public List<Integer> getSortedList() {
        Collections.sort(sortedList);
        return sortedList;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "root=" + root +
                '}';
    }
}
