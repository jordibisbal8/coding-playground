package com.company.exercises;

public class maxSubArray {
    // Kadane's algorithm
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int current = nums[0];
        for (int i = 1; i < nums.length; i++){
            current = Math.max(nums[i], nums[i] + current);
            if (current > max) {
                max = current;
            }
        }
        return max;
    }

    /**
     *
     * Divide and Conquer: Recursively breaking down a problem into two or more subproblems of the same or related type
     * until these become simple enough to solve it directly (e.g. binary search or merge sort)
     * Problem: Find maximum contiguous sum in an array
     */

    public static int maxSubArrayDivideAndConquer(int[] nums) {
        return recurs(nums, 0, nums.length - 1);
    }

    private static int recurs(int[] nums, int i, int j) {
        if (i == j)
            return nums[i];
        int mid = (i + j) / 2;
        int l = recurs(nums, i, mid);
        int r = recurs(nums, mid + 1, j);
        int crossSum = middle(nums, i, mid, j);
        return Math.max(l , Math.max(r, crossSum));
    }

    private static int middle(int[] nums, int i , int m, int j) {
        int lside = Integer.MIN_VALUE;
        int ltemp = 0;
        for (int k = m; k >= i; k--) {
            ltemp += nums[k];
            if (ltemp > lside)
                lside = ltemp;
        }
        int rside = Integer.MIN_VALUE;
        int rtemp = 0;
        for (int k = m + 1; k <= j; k++) {
            rtemp += nums[k];
            if (rtemp > rside)
                rside = rtemp;
        }
        return Math.max(lside + rside, Math.max(lside, rside));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.print(maxSubArrayDivideAndConquer(nums));
    }
}
