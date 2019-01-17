package org.xiuyuan.example.algorithms.ds.tree;

/**
 * created by helanzhou
 * Date: 2019-01-14
 * Time: 10:49
 */
public class RBNode<T extends Comparable<T>> {

    boolean   color;
    T         key;
    RBNode<T> left;
    RBNode<T> right;
    RBNode<T> parent;

    private RBNode<T> root;

    public RBNode(T key, boolean color, RBNode<T> parent, RBNode<T> left, RBNode<T> right) {
        this.key = key;
        this.color = color;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public T getKey() {
        return key;
    }

    public String toString() {
        return "" + key + (this.color ? "R" : "B");
    }

    private void leftRotate(RBNode<T> x) {
        RBNode<T> y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else {
            if (x == x.parent.left) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
        }
        y.left = x;
        x.parent = y;
    }

    private void rightRotate(RBNode<T> y) {
        RBNode<T> x = y.left;
        y.left = x.right;
        if (x.right != null) {
            x.right.parent = y;
        }
        x.parent = y.parent;
        if (y.parent == null) {
            this.root = x;
        } else {
            if (y == y.parent.left) {
                y.parent.left = x;
            } else {
                y.parent.right = x;
            }
        }
        x.right = y;
        y.parent = x;
    }

    public void insert(T key) {
        RBNode<T> node = new RBNode<>(key, true, null, null, null);
        if (node != null) {
            insert(node);
        }

    }

    private void insert(RBNode<T> node) {
        RBNode<T> current = null;
        RBNode<T> x = this.root;

        while (x != null) {
            current = x;
            int cmp = node.key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        node.parent = current;
        if (current != null) {
            int cmp = node.key.compareTo(current.key);
            if (cmp < 0) {
                current.left = node;
            } else {
                current.right = node;
            }
        } else {
            this.root = node;
        }

        insertFixUp(node);
    }

    private void insertFixUp(RBNode<T> node) {

    }


}
