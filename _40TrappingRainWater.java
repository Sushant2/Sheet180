//Leetcode - 42 - Trapping Rain Water

//brute force - for every index, we've to find the amount of water that can stored & we've to sumup that
// so sum += Math.min(maxLeftMostWall, maxRightMostWall) - arr[i]

//time comp - O(n*n) - space comp -  O(1)

class Solution {
    public int trap(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int leftMostMaxWall = 0, rightMostMaxWall = 0;
            int j = 0;
            while (j <= i) {
                leftMostMaxWall = Math.max(leftMostMaxWall, arr[j]);
                j++;
            }
            j = i;
            while (j < arr.length) {
                rightMostMaxWall = Math.max(rightMostMaxWall, arr[j]);
                j++;
            }
            sum += Math.min(leftMostMaxWall, rightMostMaxWall) - arr[i];
        }
        return sum;
    }
}