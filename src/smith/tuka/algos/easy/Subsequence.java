package smith.tuka.algos.easy;

import java.util.*;

public class Subsequence {
    public static void main(String[] args) {
           /* Given two non-empty arrays of integers, write a function that determines
        whether the second array is a subsequence of the first one.
                A subsequence of an array is a set of numbers that aren't necessarily
        adjacent in the array but that are in the same order as they appear
        in the array. For instance, the numbers [1,3,4] form a subsequence of the array
[1,2,3,4], and so do the numbers [2,4]. note that a single number in an array and the array
        itself are both valid subsequences of the array.
        Sample Input
        array = [5,1,22,25,6,-1,8,10]
        sequence = [1,6,-1,10]
        Hint 1
        you can solve this question by iterating through the main input array once.
                */
//        List<Integer> array = Arrays.asList(5,1,22,25,6,-1,8,10);
//        List<Integer> sequence = Arrays.asList(90,6,-1,10);
        int [] array ={1, 2, 3, 5, 6, 8, 9};
        System.out.println(Arrays.toString(sortedSquaredArray(array)));

        }
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here.
         int index = 0;
         for(Integer val:array){
             if(sequence.get(index).equals(val) ){
                 index++;
             }
         }

        return index == sequence.size();
    }

    public static int[] sortedSquaredArray(int[] array) {
        // Write your code here.
        int [] sorted = new int [array.length];
        int smallvalueidx = 0;
        int largevalueindx = array.length-1;
        for( int i = array.length-1; i>=0; i--){
            int smallvalue = array[smallvalueidx];
            int largevalue = array[largevalueindx];
            if(Math.abs(smallvalue)>Math.abs(largevalue)){
                sorted[i] =smallvalue*smallvalue;
                smallvalueidx++;
            }else {
                sorted[i] = largevalue*largevalue;
                largevalueindx--;

            }
        }
        return sorted;


    }
    public String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        // Write your code here.
         Map<String,Integer> scores = new HashMap<>();
         String currentTestTeam = "";
         int bestTeamPoint = 1;
         scores.put(currentTestTeam,0);
         for (int i = 0; i<competitions.size();i++){
             ArrayList<String> competition = competitions.get(i);
             int result = results.get(i);
             String homeTeam = competition.get(0);
             String awayTeam = competition.get(1);
             String winningTeam =(result==bestTeamPoint)? homeTeam : awayTeam;
             updatePoints(winningTeam,3,scores);

             if(scores.get(winningTeam)>scores.get(currentTestTeam)){
                 currentTestTeam =winningTeam;
             }
         }

        return currentTestTeam;
    }
    private void updatePoints(String team, int points, Map<String,Integer> teamppoints){
        if(!teamppoints.containsKey(team)){
            teamppoints.put(team,0);
        }
        teamppoints.put(team,teamppoints.get(team)+points);


    }

}
