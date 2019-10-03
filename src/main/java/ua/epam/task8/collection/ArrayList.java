package ua.epam.task8.collection;

import java.util.Objects;

public class ArrayList<E> implements List<E> {
    private E[] array;
    private int capacity;
    private int size = 0;

    public ArrayList() {
        this.array = (E[]) new Object[10];
        this.capacity = array.length;
    }

    public ArrayList(int capacity) {
        this.array = (E[]) new Object[capacity];
        this.capacity = capacity;
    }

    public ArrayList(E[] array) {
        this.array = array;
        this.capacity = array.length;
        this.size = this.capacity;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void add(E element) {
        Objects.requireNonNull(element);

        ensureCapacity();
        this.array[this.size] = element;
        this.size += 1;
    }

    @Override
    public E getByIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }

        return this.array[index];
    }

    @Override
    public boolean remove(E element) {
        Objects.requireNonNull(element);

        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element)) {
                shrinkArr(i);
                this.size -= 1;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clean() {
        this.array = null;
        this.size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for ( int i = 0; i < this.size; i++) {
            sb.append(array[i]).append(" ");
        }
        return "ArrayList: " +
                 sb.toString();
    }

    private void shrinkArr(int i) {
        for(int j = i+1; j < array.length; j++) {
            array[j-1] = array[j];
        }
    }

    private void ensureCapacity() {
        if (this.size == this.capacity) {
            int newCapacity = (this.capacity * 3) / 2 + 1;
            E[] newArr = (E[]) new Object[capacity];

            System.arraycopy(this.array, 0, newArr, 0, this.array.length);

//            for ( int i = 0; i < this.array.length; i++ ) {
//                newArr[i] = this.array[i];
//            }

            this.array = newArr;
            this.capacity = newCapacity;
        }
    }
}
