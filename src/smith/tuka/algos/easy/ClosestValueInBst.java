package smith.tuka.algos.easy;

public class ClosestValueInBst {
    public static void main(String[] args) {
        System.out.println();
    }

    public static int findClosestValueInBst(BST tree, int target) {
        int previousDiff =0, currentDiff =0;

        while(currentDiff<previousDiff) {
            if (target == tree.value) return target;
            else {
                tree = Math.abs(target - tree.left.value) < Math.abs(target - tree.right.value) ? tree.left : tree.right;
                previousDiff = currentDiff;
                currentDiff = tree.value;
            }
        }
        return tree.value;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
