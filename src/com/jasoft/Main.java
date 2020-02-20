package com.jasoft;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        DijkstraAlgoritm dijkstraAlgoritm = new DijkstraAlgoritm();
//        List<Node> graph = new ArrayList<>();
        HashMap<Character, Node> setOfNodes = new HashMap<>();

        setOfNodes.put('A', new Node('A',
                Arrays.asList(new Node('B', 4), new Node('C', 3), new Node('E', 7))));
        setOfNodes.put('B', new Node('B',
                Arrays.asList(new Node('D', 5), new Node('C', 6), new Node('A', 4))));
        setOfNodes.put('C', new Node('C',
                Arrays.asList(new Node('A', 3), new Node('D', 11), new Node('E', 8), new Node('B', 6))));
        setOfNodes.put('E', new Node('E',
                Arrays.asList(new Node('A', 7), new Node('D', 2), new Node('G', 5), new Node('C', 8))));
        setOfNodes.put('D', new Node('D',
                Arrays.asList(new Node('B', 5), new Node('C', 11), new Node('E', 2), new Node('G', 10), new Node('F', 2))));
        setOfNodes.put('G', new Node('G',
                Arrays.asList(new Node('D', 10), new Node('E', 5), new Node('F', 3))));
        setOfNodes.put('F', new Node('F',
                Arrays.asList(new Node('D', 2), new Node('G', 3))));


        dijkstraAlgoritm.processDijkstraAlgoritm(setOfNodes, 'A', 'F');
    }

    static class DijkstraAlgoritm {
        private List<Character> visited = new ArrayList<>();
        private List<Character> noneVisited = new ArrayList<>();
        private Node startNode = null;
        private HashMap<Character, Node> graph = new HashMap<>();

        private Character current = '1';

        public List<Node> processDijkstraAlgoritm(HashMap<Character, Node> graph, Character firstNodeName, Character destNodeName) {
            this.graph = graph;
            setupGraph(graph, firstNodeName, destNodeName);
            processNode(startNode);
            System.out.println(graph);
            System.out.println(visited);

            current = destNodeName;
            while (current!=null){
                System.out.print(graph.get(current));
                current = graph.get(current).fromNode;
                System.out.println("^^^");
            }

            return null;
        }

        public void processNode(Node currentNode) {
            if (!visited.contains(currentNode.nodeName)) {
                if (noneVisited.size() == 0) {
                    return;
                } else {
//                    currentNode.connectTo.sort(new NodeVeghtSorter());
                    for (Node node : currentNode.connectTo) {
                        if (!visited.contains(node.nodeName)) {
                            if (graph.get(currentNode.nodeName).shortestLenght + node.veight < graph.get(node.nodeName).shortestLenght) {
                                graph.get(node.nodeName).shortestLenght = graph.get(currentNode.nodeName).shortestLenght + node.veight;
                                graph.get(node.nodeName).fromNode = currentNode.nodeName;
                            }
                        }
                    }

                    for (Node node : currentNode.connectTo) {
                        if (graph.get(currentNode.nodeName).shortestLenght + graph.get(node.nodeName).veight < graph.get(node.nodeName).shortestLenght) {
                            if (!visited.contains(currentNode.nodeName)) {
                                noneVisited.remove(currentNode.nodeName);
                                visited.add(currentNode.nodeName);
                            }
                            processNode(graph.get(node.nodeName));
                        }
                    }
                }
            }
        }

        public void setupGraph(HashMap<Character, Node> graph, Character firstNodeName, Character destNodeName) {
            for (Map.Entry<Character, Node> pair : graph.entrySet()) {
                if (pair.getKey().equals(firstNodeName)) {
                    startNode = pair.getValue();
                    pair.getValue().shortestLenght = 0;
                    noneVisited.add(firstNodeName);
                } else {
                    noneVisited.add(pair.getValue().nodeName);
                }
            }
        }
    }
}
