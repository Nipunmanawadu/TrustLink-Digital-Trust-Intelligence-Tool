package algorithm;

import datastructure.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public void traverse(Node startNode) {

        ArrayList<Node> visited = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();

        queue.add(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {

            Node current = queue.poll();

            System.out.println(current);

            for (Node neighbour : current.getConnections()) {

                if (!visited.contains(neighbour)) {

                    visited.add(neighbour);
                    queue.add(neighbour);

                }

            }

        }

    }

}