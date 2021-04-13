package smith.tuka.algos.easy;

import java.util.ArrayList;
import java.util.List;

public class BranchSum {
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        // Write your code here.
        List<Integer> sums = new ArrayList<>();
        calculateSum(root,0, sums);
        return sums;
    }

    private static void calculateSum(BinaryTree node, int runningSum, List<Integer> sums) {
       if(node==null)
           return;
       int newrunninSum = runningSum + node.value;
       if(node.left == null && node.right == null){
           sums.add(newrunninSum);
           return;
       }
        calculateSum(node.left,newrunninSum,sums);
        calculateSum(node.right,newrunninSum,sums);
    }
}
