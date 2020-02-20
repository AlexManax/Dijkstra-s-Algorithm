package com.jasoft;

import java.util.Comparator;

public class NodeVeghtSorter implements Comparator<Node> {
    @Override
    public int compare(Node o1, Node o2) {
        return o1.veight-o2.veight;
    }
}
