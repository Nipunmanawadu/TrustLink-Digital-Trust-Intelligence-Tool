package datastructure;

import java.util.ArrayList;

public class Graph {

    private ArrayList<Node> nodes;

    public Graph() {

        nodes = new ArrayList<>();

    }

    // Add new node
    public void addNode(Node node) {

        nodes.add(node);

    }

    // Connect two nodes
    public void addEdge(Node first, Node second) {

        first.addConnection(second);
        second.addConnection(first);

    }

    // Display graph connections
    public void displayGraph() {

        for (Node node : nodes) {

            System.out.print(node + " connects to: ");

            for (Node connection : node.getConnections()) {

                System.out.print(connection + " | ");

            }

            System.out.println();

        }

    }

    public ArrayList<Node> getNodes() {

        return nodes;

    }

}