package com.kir138.lesson2Collection.MyArrayListTask3;

    import java.util.Arrays;

    public class MyArrayList<T> {

        private Object[] elements;
        private int size = 0;
        private static final int DEFAULT_CAPACITY = 10;

        public MyArrayList() {
            elements = new Object[DEFAULT_CAPACITY];
        }

        public void add(T data) {
            if (size == elements.length) {
                ensureCapacity();
            }
            elements[size++] = data;
        }

        public T get(int index) {
            if (index >= size || index < 0) {
                throw new IndexOutOfBoundsException("Index: " + index);
            }
            return (T) elements[index];
        }

        private void ensureCapacity() {
            int newCapacity = elements.length * 2;
            elements = Arrays.copyOf(elements, newCapacity);
        }

        public T getFirst() {
            if (isEmpty()) {
                throw new ArrayIndexOutOfBoundsException("ArrayList is empty");
            }
            return (T) elements[0];
        }

        public T getLast() {
            if (isEmpty()) {
                throw new ArrayIndexOutOfBoundsException("ArrayList is empty");
            }
            return (T) elements[size - 1];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void printList() {
            for (int i = 0; i < size; i++) {
                System.out.print(elements[i] + " ");
            }
            System.out.println();
        }
    }
