package ua.epam.task8.collection;

import java.awt.*;
import java.util.Objects;

public class MyLinkedList<E> implements List<E> {
    private Node<E> head;
    private Node<E> current;

    private int size = 0;

    public MyLinkedList() {
        this.head = new Node<>(null, null, null);
        this.current = new Node<>(null, null, null);
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

        if ( head.next == null ) {
            current.prev = head;
            current.next = head;
            current.value = element;

            head.next = current;
        } else {
            final Node<E> buffer = new Node<>(element, current, head);

            current.next = buffer;
            current.next.prev = current;

            current = buffer;
        }

        this.size += 1;
    }

    @Override
    public E getByIndex(int index) {
        if ( index < 0 || index >= size ) {
            throw new IndexOutOfBoundsException();
        }

        if ( !isEmpty() ) {
            Node<E> result = this.head.next;
            for ( int i = 0; i < index; i++) {
                result = result.next;
            }

            return result.value;
        }

        return null;
    }

    @Override
    public boolean remove(E element) {
        Node<E> result = this.head.next;
        for ( int i = 0; i < this.size; i++) {
            if ( result.value.equals(element) ) {
                result.next.prev = result.prev;
                result.prev.next = result.next;
                result.value = null;
                size -= 1;
                return true;
            }
            result = result.next;
        }

        return false;
    }

    @Override
    public void clean() {
        for (Node<E> it = this.head; it != null; ) {
            Node<E> next = it.next;

            it.value = null;
            it.prev = null;
            it.next = null;
            it = next;
        }
        this.head = this.current = null;
        this.size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node<E> start = this.head;
        for (int i = 0; i < this.size; i++ ) {
            start = start.next;

            sb.append(start.value.toString()).append(" ");
        }
        return "LinkedList:" + sb.toString();
    }

    private static class Node<E> {
        private E value;
        private Node<E> prev;
        private Node<E> next;

        public Node(E value, Node<E> prev, Node<E> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}
