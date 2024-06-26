package com.kir138.lesson2Collection.MyLinkedListTask4;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.printList();

        System.out.println(list.get(1));

        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.isEmpty());
        System.out.println(list.size());
    }
}
