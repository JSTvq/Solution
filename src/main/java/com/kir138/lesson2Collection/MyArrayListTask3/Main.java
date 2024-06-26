package com.kir138.lesson2Collection.MyArrayListTask3;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);

        list.printList();

        System.out.println(list.get(2));
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.isEmpty());
        System.out.println(list.size());
    }
}
