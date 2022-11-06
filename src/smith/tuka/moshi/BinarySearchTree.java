package smith.tuka.moshi;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {


    private class Node {
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    Node root;

    // inserting data

    private Node insertRec(Node root, int value) {
        if (null == root) {
            root = new Node(value);
            return root;
        }
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        }
        if (value > root.value) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    // traverse in order
    public void inOrder() {
        traverseInOrder(root);
        System.out.println();
    }

    private void traverseInOrder(Node root) {
        if (root == null) return;
        traverseInOrder(root.left);
        System.out.print(root.value + " ,"); // visit
        traverseInOrder(root.right);
    }

    public boolean find(Node root, int value) {
        if (root != null) {
            if (root.value == value) {
                return true;
            } else if (value < root.value) {
                return find(root.left, value);
            } else {
                return find(root.right, value);
            }
        }
        return false;


    }

    public int max() {
        return (root == null) ? -1 :
                findMax(root);
    }

    private int findMax(Node root) {
        if (root.right != null) {
            return findMax(root.right);
        }
        return root.value;

    }

    public int min() {
        return root == null ? Integer.MIN_VALUE : findMin(root);
    }

    private int findMin(Node root) {
        if (root.left != null) {
            return findMin(root.left);
        }
        return root.value;
    }

    public void preOrder() {
        preOrderTraversal(root);
        System.out.println();
    }

    private void preOrderTraversal(Node root) {
        if (root == null) return;
        System.out.print(root.value + ", ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void find(int value) {
        System.out.println(find(root, value));
    }

    public void postOrder() {
//        System.out.println();
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + ", ");
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null) {
            return -1;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public boolean isEqual(BinarySearchTree tree) {
        if (tree == null) return false;
        return isEqual(root, tree.root);
    }

    private boolean isEqual(Node root, Node root2) {
        if (root == root2 && root == null) return true;
        return root.value == root2.value &&
                isEqual(root.left, root2.left) &&
                isEqual(root.right, root2.right);
    }

    private boolean isBinarySearchTree() {
        if (root == null) {
            return true;
        }
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, int minValue, int maxValue) {
        if (root == null) return true;
        if (root.value < minValue || root.value > maxValue) return false;
        return isBinarySearchTree(root.left, Integer.MIN_VALUE, root.value - 1)
                && isBinarySearchTree(root.right, root.value + 1, Integer.MAX_VALUE);
    }

    public List<Integer> nodeAtKDistance(int k) {
        List<Integer> results = new ArrayList();
        nodeAtKDistance(root, results, k);
        // breadthFirst
        return results;
    }

    private void nodeAtKDistance(Node root, List<Integer> results, int k) {
        if (root == null) return;
        if (k == 0) {
//            System.out.print(" , " + root.value);
            results.add(root.value);
            return;
        }
        nodeAtKDistance(root.left, results, k - 1);
        nodeAtKDistance(root.right, results, k - 1);
    }

    public void breadthFirstTraversal() {
        for (int i = 0; i <= height(); i++) {
            System.out.println();
            List<Integer> list = nodeAtKDistance(i);
            for (Integer element : list) System.out.print(element + " ");
        }
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        BinarySearchTree bst2 = new BinarySearchTree();
        int[] input = {7, 4, 9, 1, 6, 8, 10};
        int[] input2 = {70, 4, 9, 1, 6, 8, 11};
        int[] input3 = {20, 10, 30, 21, 4, 3, 8};
        int[] arr = {100, 50, 30, 26, 8, 2, 1, -1, -2, -3, -4, -5};

        for (int x : input) {
            binarySearchTree.insert(x);
        }
        for (int x : arr) {
            bst2.insert(x);
        }

//        binarySearchTree.inOrder();

//        binarySearchTree.find(19);
//        System.out.println(binarySearchTree.max());
//        System.out.println(binarySearchTree.min());
//        binarySearchTree.preOrder();
//        binarySearchTree.postOrder();

//        System.out.println(binarySearchTree.height());

//        System.out.println(binarySearchTree.isEqual(bst2));
//        System.out.println(binarySearchTree.isBinarySearchTree());
//        System.out.println(bst2.isBinarySearchTree());
        System.out.println((bst2.nodeAtKDistance(5)));
//        bst2.breadthFirstTraversal();
        // breadthFirst Traversal
        System.out.println(bst2.height());




    }

    // delete operation on a BST


}

