package com.company.datastructures;

// Adjacency List implementation. Another implementation is using Adjency Matrixes (NXN), where N is the vertices
// and each cell is the edge
public class Graph {
    Integer v;
    Node[] nodes;

    class Node {
        public String name;
        public Node[] children;
    }
}

