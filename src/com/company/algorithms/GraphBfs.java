package com.company.algorithms;

import com.company.datastructures.Bag;

import java.util.LinkedList;
import java.util.Queue;

public class GraphBfs {
    Integer v;
    Bag<Integer>[] adj;

    public GraphBfs(int V) {
        v = V;
        adj = (Bag<Integer>[]) new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[v] = new Bag<>();
        }
    }

    void BFS(int s, int dst) {
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        while (queue.size() != 0) {
            s = queue.poll();
            for (int n : adj[s]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}
