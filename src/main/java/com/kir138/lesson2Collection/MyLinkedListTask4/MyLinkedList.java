package com.kir138.lesson2Collection.MyLinkedListTask4;

public class MyLinkedList<T> {
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    public void add(T element) {
        Node newNode = new Node(element);
        if (tail != null) {
            tail.next = newNode;
        } else {
            head = newNode;
        }
        tail = newNode;
        size++;
    }

    public T get(int index) {
        Node current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current.data;
            }
            count++;
            current = current.next;
        }
        throw new IndexOutOfBoundsException("Index: " + index);
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("LinkedList is empty");
        }
        return head.data;
    }

    public T getLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("LinkedList is empty");
        }
        return tail.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
