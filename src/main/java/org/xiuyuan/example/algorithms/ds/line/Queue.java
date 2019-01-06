package org.xiuyuan.example.algorithms.ds.line;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * created by helanzhou
 * Date: 2019-01-06
 * Time: 17:27
 */
public class Queue<Item> implements Iterable<Item> {

    private Node<Item> first;
    private Node<Item> last;
    private int        n;

    public Queue() {
        first = null;
        last = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }

        return first.item;
    }

    public void enqueue(Item item) {
        Node<Item> oldLast = last;
        last = new Node<>();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        n++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        this.forEach(item -> {
            builder.append(item);
            builder.append(' ');
        });

        return builder.toString();
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    private static class Node<Item> {

        private Item       item;
        private Node<Item> next;
    }

    private class ListIterator<Item> implements Iterator<Item> {

        private Node<Item> current;

        @Override
        public boolean hasNext() {
            return current == null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

            throw new UnsupportedOperationException();
        }
    }
}
