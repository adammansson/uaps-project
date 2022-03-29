package uaps;

import java.util.Comparator;


public class BinarySearchTree<E> {
    BinaryNode<E> root;
    int size;
    private Comparator<E> ccomparator;

    /**
     * Constructs an empty binary search tree.
     */
    public BinarySearchTree() {
        root = null;
        size = 0;
        ccomparator = (a, b) -> ((Comparable<E>) a).compareTo(b);
    }

    /**
     * Constructs an empty binary search tree, sorted according to the specified comparator.
     */
    public BinarySearchTree(Comparator<E> comparator) {
        root = null;
        size = 0;
        ccomparator = comparator;
    }

    /**
     * Inserts the specified element in the tree if no duplicate exists.
     * @param x element to be inserted
     * @return true if the the element was inserted
     */
    public boolean add(E x) {
        if (root == null) {
            root = new BinaryNode<E>(x);
            size++;
            return true;
        }

        return add(root, x);
    }

    private boolean add(BinaryNode<E> parent, E x) {
        int compResult = ccomparator.compare(x, parent.element);

        if (compResult == 0) {
            // Element is duplicate
            return false;
        } else if (compResult < 0) {
            // Element is smaller
            if (parent.left == null) {
                parent.left = new BinaryNode<E>(x);
                size++;
                return true;
            } else {
                add(parent.left, x);
            }
        } else if (compResult > 0) {
            // Element is larger
            if (parent.right == null) {
                parent.right = new BinaryNode<E>(x);
                size++;
                return true;
            } else {
                add(parent.right, x);
            }
        }
        return false;
    }

    /**
     * Computes the height of tree.
     * @return the height of the tree
     */
    public int height() {
        if (root == null) return 0; // Tree is empty

        return height(root);
    }

    private int height(BinaryNode<E> x) {
        if (x == null) return 0;

        return Math.max(height(x.left), height(x.right)) + 1;
    }

    /**
     * Returns the number of elements in this tree.
     * @return the number of elements in this tree
     */
    public int size() {
        return size;
    }

    /**
     * Removes all of the elements from this list.
     */
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * Print tree contents in inorder.
     */
    public void printTree() {
        print(root);
    }

    private void print(BinaryNode<E> x) {
        if (x != null) {
            print(x.left);
            System.out.println(x.element);
            print(x.right);
        }
    }

    /**
     * Adds all elements from the tree rooted at n in inorder to the list sorted.
     * @param n
     * @param sorted
     */
    private void toArray(BinaryNode<Integer> n, int[] sorted) {
        if (n != null) {
            toArray(n.left, sorted);
            sorted[sorted.length] = n.element;
            toArray(n.right, sorted);
        }
    }

    public static void sort(int[] arr) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        for (int i : arr) {
            tree.add(i);
        }

        arr = new int[arr.length];
        tree.toArray(tree.root, arr);
    }

    static class BinaryNode<E> {
        E element;
        BinaryNode<E> left;
        BinaryNode<E> right;

        private BinaryNode(E element) {
            this.element = element;
        }
    }

}
