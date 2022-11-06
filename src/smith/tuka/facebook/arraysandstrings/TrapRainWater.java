package smith.tuka.facebook.arraysandstrings;

public class TrapRainWater {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(maximumWaterCollected(height));
        System.out.println(maxWater(height));
        System.out.println(maxRain(height));
    }

    //    O(n) time, O(1) space
    private static int maximumWaterCollected(int[] height) {

        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else ans += (left_max - height[left]);
                ++left;
            } else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else ans += (right_max - height[right]);
                --right;
            }
        }
        return ans;
    }

    //    O(n) space, O(n) time
    public static int maxWater(int[] height) {
        int ans = 0;
        int[] maxRight = new int[height.length];
        int[] maxLeft = new int[height.length];
//        int[] waterTrapped = new int[height.length];
        int i = 1;
        int maxL = 0;
        int maxR = 0;
        maxLeft[0] = 0;
        maxRight[height.length - 1] = 0;
        while (i < height.length) {
            if (height[i] >= maxL) maxL = height[i];
            maxLeft[i] = maxL;
            i++;
        }

        i = height.length - 2;
        while (i > 0) {
            if (height[i] >= maxR) maxR = height[i];
            maxRight[i] = maxR;
            i--;
        }
        int minLR;
        for (int j = 0; j < height.length; j++) {
            minLR = Math.min(maxLeft[j], maxRight[j]);
            if (minLR - height[j] > 0) ans += (minLR - height[j]);
        }

        return ans;
    }

    public static int maxRain(int[] height) {
        int left = 0, right = height.length - 1;
        int maxL = height[left];
        int maxR = height[right];
        int ans = 0;

        while (left < right) {
            if (maxL < maxR) {
                maxL = Math.max(height[left], maxL);
                ans += Math.max(maxL - height[left], 0);
                left++;
            } else {
                maxR = Math.max(maxR, height[right]);
                ans += Math.max(maxR - height[right], 0);
                right--;
            }
        }
        return ans;

    }
}
//Given n non-negative integers representing an elevation map where the width of each bar is 1,
// compute how much water it can trap after raining.
