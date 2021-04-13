package smith.tuka.algos.easy;

import java.util.Arrays;

public class Change {
    public static void main(String[] args) {
        int[] input = new int[] {5, 7, 1, 1, 2, 3, 22};
        System.out.println( nonConstractiveChange(input));
    }
    public static int nonConstractiveChange(int[] coins){
        Arrays.sort(coins);
        int changeCreated = 0;
        for(Integer coin: coins){
            if(coin> changeCreated+1){
                return changeCreated+1;
            }
            changeCreated+=coin;
        }
        return changeCreated+1;

    }
}
