package smith.tuka.Gap;

public class MirrorBinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        /* print inorder traversal of the input tree */
        System.out.println("Inorder traversal of input tree is :");
        tree.inOrder();
        System.out.println("");

        /* convert tree to its mirror */
        tree.mirror();

        /* print inorder traversal of the minor tree */
        System.out.println("Inorder traversal of binary tree is : ");
        tree.inOrder();

    }
}

class Node {
    Node left, right;
    int value;

    Node(int value) {
        this.value = value;
        left = right = null;
    }
}

class BinaryTree {
    public Node root;

    public void mirror() {
        root = mirror(root);
    }

    private Node mirror(Node node) {
        if (null == node) return node;
        Node left = mirror(node.left);
        Node right = mirror(node.right);
        node.left = right;
        node.right = left;
        return node;
    }


    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node) {
        if(null==node){
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + ", ");
        inOrder(node.right);
    }

}
