package algorithm;

import datastructure.Node;
import java.util.ArrayList;

public class DFS {

    public void traverse(Node startNode) {

        ArrayList<Node> visited = new ArrayList<>();

        dfsRecursive(startNode, visited);

    }

    private void dfsRecursive(Node node, ArrayList<Node> visited) {

        visited.add(node);

        System.out.println(node);

        for (Node neighbour : node.getConnections()) {

            if (!visited.contains(neighbour)) {

                dfsRecursive(neighbour, visited);

            }

        }

    }

}