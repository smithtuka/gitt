package smith.tuka.moshi;

import java.util.*;

public class Graph {
    Map<String, Node> nodes = new HashMap<>();
    Map<Node, List<Node>> adjacencyList = new HashMap<>();

    class Node {
        String label;

        Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    public void addNode(String label) {
        Node newNode = new Node(label);
        nodes.putIfAbsent(label, newNode);
    }

    public void removeNode(String label) {
        Node node = findNode(label);
        if (null != node)
            nodes.remove(label);
//        clearEdges(label); // clear the adjacencyList
    }

    public void addEdge(String from, String to) {
        Node fromNode = findNode(from);
        Node toNode = findNode(to);
        List<Node> connections;
        if (null != fromNode && null != to) {
            connections = adjacencyList.getOrDefault(fromNode, new ArrayList<>());
            connections.add(toNode);
            adjacencyList.put(fromNode, connections);
        }
    }

    private void removeEdge(String from, String to) {
        Node fromNode = findNode(from);
        Node toNode = findNode(to);
        List<Node> connections;
        if (null != fromNode) {
            connections = adjacencyList.getOrDefault(from, new ArrayList<>());
            if (null != to) connections.remove(toNode);
            adjacencyList.put(fromNode, connections);

        }
    }

    public void traverseDepthFirst(String root) {
        traverseDepthFirst(nodes.get(root), new HashSet<>());
    }

    private void traverseDepthFirst(Node root, Set<String> visited) {
        List<Node> toVisit = adjacencyList.get(nodes.get(root.label));
        visited.add(root.label);
        for (Node node : toVisit) {
            if (!visited.contains(root.label)) {
                System.out.print(node.label + ", ");
                traverseDepthFirst(node, visited);

            } else return;
        }
    }

    // iterative
    public void breadthFirstSearch(String root){
        Node node = nodes.get(root);
        if(node==null) return;
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()){
            Node current = queue.remove();
            if(!visited.contains(current)) {
                System.out.println(current.label);
                visited.add(current);
                queue.addAll(adjacencyList.get(current));
            }

        }
    }

    private void print() {
        for (Node node : adjacencyList.keySet()) {
            StringBuffer sb = new StringBuffer(node.label + " is connected to ");
            System.out.println(node.label + " is connected to " + adjacencyList.get(node));
        }

    }

    private Node findNode(String label) {
        return nodes.getOrDefault(label, null);
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("C", "D");
        graph.addEdge("B", "C");
        graph.addEdge("D", "A");

//        graph.print();

//        graph.removeEdge("D", "A");
//
        graph.print();
        graph.traverseDepthFirst("A");

    }


}
