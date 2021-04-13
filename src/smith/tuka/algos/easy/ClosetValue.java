package smith.tuka.algos.easy;

public class ClosetValue {
    public static int closestValueInBST(BST tree, int target) {
        return findValue(tree,target,tree.value);

    }
    private static int findValue(BST tree, int target, int closest){
        BST currentNode = tree;
     while (currentNode!=null){
         if(Math.abs(target-closest)>Math.abs(target-currentNode.value)){
         closest = currentNode.value;
         }
         if (target<currentNode.value){
             currentNode =currentNode.left;
         }else if(target>currentNode.value){
             currentNode = currentNode.right;
         }else break;
     }
     return closest;
    }

    static class BST {
        private int value;
        private BST left;
        private BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
