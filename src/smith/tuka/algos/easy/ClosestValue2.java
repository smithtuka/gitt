package smith.tuka.algos.easy;

public class ClosestValue2 {
    static class BST{
        public static int findClosestValueInBst(BST tree, int target) {
            return findValue(tree,target,tree.value);

        }

        private static int findValue(BST tree, int target, int closest) {
            if (Math.abs(target-tree.value)< Math.abs(target-closest)){
                closest = tree.value;}
              if(target>tree.value && tree.right!=null){
                  return findValue(tree.right,target,closest);}
              else if(target< tree.value && tree.left !=null) {
                  return findValue(tree.left, target, closest);
              }
              else{
                  return closest;}
        }

        private int value;
        private BST left;
        private BST right ;
    }
}
