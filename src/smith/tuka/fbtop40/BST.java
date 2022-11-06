package smith.tuka.fbtop40;

public class BST {
    Node root;

    public BST() {
        this.root = null;
    }

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
        }
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    public void add(int value) {
        root = insertRec(root, value);
    }

    public void inOrderTraverse() {
        inorder(root);
    }

    private void inorder(Node root) {
        if (null != root) {
            inorder(root.left);
            System.out.print(root.value + ", ");
            inorder(root.right);

        }
    }

    public boolean search(int value) {
        boolean result = search(root, value);
        System.out.println(result);
        return result;
    }

    private boolean search(Node root, int value) {
        if (root != null) {
            if (root.value == value) return true;
        } else if (value < root.value) {
            return search(root.left, value);
        }
        return search(root.right, value);


    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.add(100);
        bst.add(99);
        bst.add(10);
        bst.add(12);
        bst.add(1);

//        bst.inOrderTraverse();
        bst.search(101);
    }

}
