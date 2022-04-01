package uaps;

import java.util.ArrayList;
import java.util.Comparator;


public class TreeSorter {
    BinaryNode root;
    int size;

    /**
     * Constructs an empty binary search tree.
     */
    public TreeSorter() {
        root = null;
        size = 0;
    }

    /**
     * Inserts the specified element in the tree if no duplicate exists.
     * @param x element to be inserted
     * @return true if the the element was inserted
     */
    public boolean add(int x) {
        if (root == null) {
            root = new BinaryNode(x);
            size++;
            return true;
        }
        return add(root, x);
    }

    private boolean add(BinaryNode parent, int x) {
        if (x == parent.element) {
            // Element is duplicate
            return false;
        } else if (x < parent.element) {
            // Element is smaller
            if (parent.left == null) {
                parent.left = new BinaryNode(x);
                size++;
                return true;
            } else {
                add(parent.left, x);
            }
        } else {
            // Element is larger
            if (parent.right == null) {
                parent.right = new BinaryNode(x);
                size++;
                return true;
            } else {
                add(parent.right, x);
            }
        }
        return false;
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

    private void print(BinaryNode x) {
        if (x != null) {
            print(x.left);
            System.out.println(x.element);
            print(x.right);
        }
    }

    /**
     * Adds all elements from the tree rooted at n in inorder to the sorted list.
     * @param n
     * @param list
     */
    public static void toList(BinaryNode n, ArrayList<Integer> list) {
        if (n != null) {
            toList(n.left, list);
            list.add(n.element);
            toList(n.right, list);
        }
    }

    public static void sort(int[] arr) {
        TreeSorter tree = new TreeSorter();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i : arr) {
            tree.add(i);
        }
        toList(tree.root, list);

        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
    }

    static class BinaryNode {
        int element;
        BinaryNode left;
        BinaryNode right;

        private BinaryNode(int element) {
            this.element = element;
        }
    }

}
