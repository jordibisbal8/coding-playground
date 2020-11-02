package com.company.exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 */
public class topKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] output = new int[k];
        for (int x: nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        Queue<Integer> q = new PriorityQueue<>(
                (n1, n2) -> map.get(n1) - map.get(n2));

        for (int n: map.keySet()) {
            q.add(n);
            if (q.size() > k) q.poll();
        }

        for(int i = k - 1; i >= 0; i--) {
            output[i] = q.poll();
        }
        return output;
    }
}
