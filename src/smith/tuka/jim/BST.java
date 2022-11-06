package smith.tuka.jim;

public class BST {
    class Node {
        private Node right;
        private Node left;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }

    Node root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node root, int value) {
        if (null == root) {
            root = new Node(value);
            return root;
        }
        if (value < root.value) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public void print() {
        traverse(root);
    }

    private void traverse(Node root) {
        if (root == null) return;
        traverse(root.left);
        System.out.println(root.value);
        traverse(root.right);
    }
}
