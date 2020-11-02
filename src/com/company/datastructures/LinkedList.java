package com.company.datastructures;

public class LinkedList {
    Node head;
    int size;

    static class Node {
        int data;
        Node next;
        Node(int d, Node n) {
            data = d;
            next = n;
        }
    }

    public void insertNode(int data) {
        Node x = new Node(data, null);
        Node current = head;
        if (current == null) {
            head = x;
        }
        else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = x;
        }
        size ++;
    }

    public void deleteNode(int d) {
        Node current = head;
        if (current.data == d) {
            head = current.next;
            size--;
        }
        else {
            while (current.next != null) {
                if (current.next.data == d) {
                    current.next = current.next.next;
                    size--;
                }
                current = current.next;
            }
        }
    }

    public void deleteLastNode() {
        Node current = head;
        if (size == 1) {
            head = null;
            size = 0;
        }
        else {
            Node prev = null;
            while (current.next != null) {
                prev = current;
                current = current.next;
            }
            if (prev.next != null) prev.next = null;
            size--;
        }
    }
}
