package org.xiuyuan.example.algorithms.ds.bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * created by helanzhou
 * Date: 2019-01-06
 * Time: 17:07
 */
public class Bag<T> implements Iterable<T> {

    private Node<T> first;
    private int     n;

    public Bag() {
        this.first = null;
        this.n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void add(T item) {
        Node<T> oldFirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>(first);
    }

    private static class Node<T> {

        private T       item;
        private Node<T> next;
    }

    private class ListIterator<T> implements Iterator<T> {

        private Node<T> current;

        public ListIterator(Node<T> first) {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
