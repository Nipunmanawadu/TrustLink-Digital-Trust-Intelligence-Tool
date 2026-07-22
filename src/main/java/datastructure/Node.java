package datastructure;

import java.util.ArrayList;

public class Node {

    private String data;
    private String type;

    private ArrayList<Node> connections;

    public Node(String data,
                String type) {

        this.data = data;
        this.type = type;

        connections = new ArrayList<>();

    }

    public String getData() {

        return data;

    }

    public String getType() {

        return type;

    }

    public ArrayList<Node> getConnections() {

        return connections;

    }

    public void addConnection(Node node) {

        connections.add(node);

    }

    @Override
    public String toString() {

        return type + ": " + data;

    }

}