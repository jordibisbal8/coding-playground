package com.company.exercises;

import java.util.*;

public class BuildMap {

    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : data) {
            if (!map.containsKey(x))
                map.merge(x, 1, Integer::sum);
        }
        // Inverted priority queue
        Queue<Integer> pqInversed = new PriorityQueue<>((x, y) -> y.compareTo(x));
        pqInversed.add(2);
        pqInversed.add(1);
        pqInversed.add(4);
        pqInversed.add(5);
        Iterator x = pqInversed.iterator();
        while (x.hasNext()) {
            System.out.print(x.next());
        }
    }
}
