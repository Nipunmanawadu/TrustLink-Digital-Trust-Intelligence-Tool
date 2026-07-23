/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datastructure;

import model.Risk;
import java.util.ArrayList;

public class MaxHeap {

    private ArrayList<Risk> heap;

    public MaxHeap() {

        heap = new ArrayList<>();

    }

    // Insert risk
    public void insert(Risk risk) {

        heap.add(risk);

        int index = heap.size() - 1;

        while (index > 0) {

            int parent = (index - 1) / 2;

            if (heap.get(parent).getScore()
                    < heap.get(index).getScore()) {

                Risk temp = heap.get(parent);

                heap.set(parent, heap.get(index));

                heap.set(index, temp);

                index = parent;

            } else {

                break;

            }

        }

    }

    // Remove highest risk
    public Risk removeMax() {

        if (heap.isEmpty()) {

            return null;

        }

        Risk max = heap.get(0);

        Risk last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {

            heap.set(0, last);

            heapify(0);

        }

        return max;

    }

    private void heapify(int index) {

        int largest = index;

        int left = 2 * index + 1;

        int right = 2 * index + 2;

        if (left < heap.size()
                && heap.get(left).getScore()
                > heap.get(largest).getScore()) {

            largest = left;

        }

        if (right < heap.size()
                && heap.get(right).getScore()
                > heap.get(largest).getScore()) {

            largest = right;

        }

        if (largest != index) {

            Risk temp = heap.get(index);

            heap.set(index, heap.get(largest));

            heap.set(largest, temp);

            heapify(largest);

        }

    }

    public void displayHeap() {

        for (Risk risk : heap) {

            System.out.println(risk);

        }

    }

}