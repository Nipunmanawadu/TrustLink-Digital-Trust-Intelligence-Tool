package controller;

import algorithm.BFS;
import algorithm.DFS;
import datastructure.Graph;
import datastructure.MaxHeap;
import datastructure.Node;
import model.Risk;

public class Test {

    public static void main(String[] args) {

        // Create Nodes
        Node website = new Node(
                "fake-bank-login.com",
                "Website"
        );

        Node email = new Node(
                "support@fakebank.com",
                "Email"
        );

        Node phone = new Node(
                "+94771234567",
                "Phone"
        );

        // Create Graph
        Graph graph = new Graph();

        graph.addNode(website);
        graph.addNode(email);
        graph.addNode(phone);

        graph.addEdge(website, email);
        graph.addEdge(email, phone);

        System.out.println("GRAPH CONNECTIONS");
        graph.displayGraph();

        // BFS
        System.out.println("\nBFS RESULT");

        BFS bfs = new BFS();
        bfs.traverse(website);

        // DFS
        System.out.println("\nDFS RESULT");

        DFS dfs = new DFS();
        dfs.traverse(website);

        // Max Heap
        System.out.println("\nRISK HEAP");

        MaxHeap heap = new MaxHeap();

        heap.insert(
                new Risk(
                        "Fake Website",
                        80
                )
        );

        heap.insert(
                new Risk(
                        "Scam Email",
                        70
                )
        );

        heap.insert(
                new Risk(
                        "Reported Phone",
                        90
                )
        );

        heap.displayHeap();

        System.out.println("\nHighest Risk");

        Risk highest = heap.removeMax();

        if (highest != null) {

            System.out.println(highest);

        }

    }

}