package smith.tuka.fbtop40;

import java.util.stream.IntStream;

public class BinarySearchTree {

    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = this.right = null;
        }
    }

    Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void add(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    private void inOrderRec(Node root) {
        if (null != root) {
            inOrderRec(root.left);
            System.out.print(root.value + ", ");
            inOrderRec(root.right);

        }
    }
//    private void postOrderRec(Node root) {
//        if (null != root) {
//            inOrderRec(root.right);
//            System.out.println(root.value);
//            inOrderRec(root.left);
//
//        }
//    }

//    public void postOrder() {
//        postOrderRec(root);
//    }

    public void inOrder() {
        inOrderRec(root);
    }


}

class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
//        int[] testArray3 = {1, 2, 3, 7, 21, 215, 715, 610, 510, 71, 5, 0, -1, 71, 33, 66, 277, 56, 89, 91, 77, 101, 201, 111}; // 313
//        IntStream.of(testArray3).forEach(bst::add);
        bst.add(100);
        bst.add(10);
        bst.add(1);
        bst.inOrder();
    }
}
