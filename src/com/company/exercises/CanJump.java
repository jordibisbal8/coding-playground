package com.company.exercises;

/**
 * Problem: Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Input: nums = [3,2,1,0,4]
 * Output: false
 */

/**
 * This is a dynamic programming question. Usually, solving and fully understanding a dynamic programming problem is a 4 step process:
 *
 * 1. Start with the recursive backtracking solution
 * 2. Optimize by using a memoization table (top-down dynamic programming)
 * 3. Remove the need for recursion (bottom-up dynamic programming)
 * 4. Apply final tricks to reduce the time / memory complexity (greedy algorithm)
 */
public class CanJump {

    /** 1. Backtracking is an algorithmic-technique for solving problems recursively by trying to build a solution incrementally, one piece at a time,
    * removing those solutions that fail to satisfy the constraints of the problem at any point of time. If fails, backtrack**/
    public boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }

    public boolean canJumpBacktracking(int[] nums) {
        return canJumpFromPosition(0, nums);
    }

    /**
     * 2. Top-down Dynamic Programming can be thought of as optimized backtracking.
     * It relies on the observation that once we determine that a subsolution, this result will never change (it can be stored)
     */

    /** 3. Just remove recursion (bottom-up approach)*/

    /** 4. Greedy algorithm: Makes the choice that looks best at the moment, for leading to a global optimal solution*/
    public boolean canJump(int[] nums) {
        if (nums.length == 0) return false;
        int last = nums.length - 1;
        for (int i = nums.length -1 ; i >= 0; i--) {
            if (nums[i] + i >= last) {
                last = i;
            }
        }
        return (last == 0);
    }

}
