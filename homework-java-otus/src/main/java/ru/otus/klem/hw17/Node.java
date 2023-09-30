package ru.otus.klem.hw17;

public class Node {
    int value;
    Node left;
    Node right;

    @Override
    public String toString() {
        return "Node{" +
                "value = " + value +
                ", left child= " + left +
                ", right child= " + right +
                " }";
    }
}
