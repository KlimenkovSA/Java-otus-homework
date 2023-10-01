package ru.otus.klem.hw17;

public class Node {
    int value;
    Node left;
    Node right;

    public Node(Integer val) {
        this.value = val;
        this.left = null;
        this.right = null;
    }
    @Override
    public String toString() {
        return "Node{" +
                "value = " + value +
                ", left child= " + left +
                ", right child= " + right +
                " }";
    }
}
