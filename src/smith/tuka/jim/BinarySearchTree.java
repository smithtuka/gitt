package smith.tuka.jim;

public class BinarySearchTree {
    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

    }

    Node root;

    public BinarySearchTree() {
    }

    public void insert(int value) {
//        if (root == null) {
//            root = new Node(value);
//        } else {
//            Node newNode = new Node(value);
        root = insert(root, value);
//        }
    }

    private Node insert(Node root, int value) {

        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.value) {
            root.left = insert(root.left, value);
        } else if (value > root.value) {
            root.right = insert(root.right, value);
        }

        return root;
    }

    public void traverse() {
        traverse(root);
    }

    // in order
    private void traverse(Node root) {
        if (root != null) {
            traverse(root.left);
            System.out.print(root.value + ", "); // visit
            traverse(root.right);

        }

    }

//    tree height

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null) return -1;
        if (root.left == null && root.right == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
//        int[] arr = {10, 5, 3, 6, 8, 2, 1, -1, -2, -3, -4, -5};
        int[] arr = {100, 50, 30, 26, 8, 2, 1, -1, -2, -3, -4, -5};
        for (int x : arr) {
            bst.insert(x);
        }

        bst.traverse();
        System.out.println("\nHeight : " + bst.height());
    }


}
