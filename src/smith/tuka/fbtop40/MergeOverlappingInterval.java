package smith.tuka.fbtop40;
//You are given an array (list) of interval pairs as input where each interval has a start and end timestamp.
// The input array is sorted by starting timestamps. You are required to merge overlapping
// intervals and return a new output array.
//Consider the input array below. Intervals (1, 5), (3, 7), (4, 6), (6, 8) are overlapping
// so they should be merged to one big interval (1, 8). Similarly, intervals (10, 12) and (12, 15)
// are also overlapping and should be merged to (10, 15).

import java.util.ArrayList;
import java.util.List;

public class MergeOverlappingInterval {
    public static void main(String[] args) {

        Pair p1 = new Pair(1, 5);
        Pair p2 = new Pair(3, 7);
        Pair p3 = new Pair(4, 6);
        Pair p4 = new Pair(6, 8);
        List<Pair> intervalList = List.of(p1, p2, p3, p4);
        List<Pair> ans = mergeIntervals(intervalList);
        for (Pair pair : ans) {
//            System.out.printf("[%d, %d] ", pair.x, pair.y);
        }

        ArrayList<Pair> v = new ArrayList<>();

        v.add(new Pair(1, 5));
        v.add(new Pair(3, 7));
        v.add(new Pair(4, 6));
        v.add(new Pair(6, 8));
        v.add(new Pair(10, 12));
        v.add(new Pair(11, 15));

        List<Pair> result = mergeIntervals(v);

        for (Pair pair : result) {
            System.out.printf("[%d, %d] ", pair.x, pair.y);
        }
    }

    public static List<Pair> mergeIntervals(List<Pair> input) {
        if (input == null || input.size() < 1) {
            return null;
        }

        List<Pair> results = new ArrayList<>();
        results.add(new Pair(input.get(0).x, input.get(0).y));
        for (int i = 1; i < input.size(); i++) {
            int x1 = input.get(i).x;
            int y1 = input.get(i).y;

            int y2 = input.get(results.size() - 1).y;

            if (y2 >= x1) {
                results.get(results.size() - 1).y = Math.max(y1, y2);
            } else {
                results.add(new Pair(x1, y1));
            }
        }
        return results;
    }
}

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

