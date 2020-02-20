package com.jasoft;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public Character nodeName;
    public int shortestLenght = Integer.MAX_VALUE;
    public int veight = 0;
    public List<Node> connectTo = new ArrayList<>();
    public Character fromNode;

    public Node(Character nodeName) {
        this.nodeName = nodeName;
    }

    public Node(Character nodeName, int veight) {
        this.nodeName = nodeName;
        this.veight = veight;
    }

    public Node(Character nodeName, int shortestLenght, Character fromNode) {
        this.nodeName = nodeName;
        this.shortestLenght = shortestLenght;
        this.fromNode = fromNode;
    }

    public Node(Character nodeName, int shortestLenght, List<Node> connectTo) {
        this.nodeName = nodeName;
        this.shortestLenght = shortestLenght;
        this.connectTo = connectTo;
    }

    public Node(Character nodeName, List<Node> connectTo) {
        this.nodeName = nodeName;
        this.connectTo = connectTo;
    }

    @Override
    public String toString() {
        return nodeName +
                ":" + shortestLenght +
                ":" + fromNode + "\n";
    }
}
