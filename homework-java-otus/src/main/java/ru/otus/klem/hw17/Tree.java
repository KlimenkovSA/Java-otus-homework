package ru.otus.klem.hw17;

import java.util.ArrayList;
import java.util.*;

public class Tree implements SearchTree {

    private Node root;
    private final List<Node> sortedList = new ArrayList<>();

    public void nodeInsert(int value) {
        Node newNode = new Node();
        newNode.value = value;
        if (root == null) {
            root = newNode;
            sortedList.add(root);
        } else {
            Node currentNode = root;
            while (true) {
                if (currentNode.value == value) {
                    return;
                } else if (currentNode.value > value) {
                    if (currentNode.left == null) {
                        currentNode.left = newNode;
                        sortedList.add(currentNode.left);
                        return;
                    }
                    currentNode = currentNode.left;
                } else {
                    if (currentNode.right == null) {
                        currentNode.right = newNode;
                        sortedList.add(currentNode.right);
                        return;
                    }
                    currentNode = currentNode.right;
                }
            }
        }
    }

    @Override
    public Integer find(Integer element) {
        return get(root, element);
    }

    private Integer get(Node root, Integer element) {
        if (null == root) return null;
        int cmp = element.compareTo(root.value);
        if (0 > cmp) {
            return get(root.left, element);
        } else if (0 < cmp) {
            return get(root.right, element);
        } else {
            return root.value;
        }
    }
    @Override
    public List<Node> getSortedList() {
        List<Integer> listNumb = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
        int middleIndex = listNumb.size() / 2;
        this.nodeInsert(listNumb.get(middleIndex));
        for (Integer val : listNumb) {
            this.nodeInsert(val);
        }
        return sortedList;
    }


}
