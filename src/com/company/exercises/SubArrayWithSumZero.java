package com.company.exercises;

import java.util.HashSet;
import java.util.Set;

public class SubArrayWithSumZero {

    public static Boolean isThereZeroSubArray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int num: nums) {
            sum += num * -1;
            if (num == 0 || set.contains(sum)) return true;
            set.add(sum);
        }
        return false;
    }

    public static void main(String[] args) {
        /*Input: {4, 2, -3, 1, 6}
        Output: true
        There is a subarray with zero sum from index 1 to 3.

        Input: {4, 2, 0, 1, 6}
        Output: true
        There is a subarray with zero sum from index 2 to 2.

        Input: {-3, 2, 3, 1, 6}
        Output: false
        There is no subarray with zero sum.*/
        int[] nums = new int[]{4, 2, -3, 1, 6};
        int[] nums1 = new int[]{4,2,0,1,6};
        int[] nums2 = new int[]{-3, 2, 3, 1, 6};
        System.out.print(isThereZeroSubArray(nums));
        System.out.print(isThereZeroSubArray(nums1));
        System.out.print(isThereZeroSubArray(nums2));
    }
}
