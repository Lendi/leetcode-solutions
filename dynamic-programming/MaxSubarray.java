/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

*/

public class Solution {
    public int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE, sum = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(sum < 0)
                sum = nums[i];
            else
                sum += nums[i];

            if(max < sum)
                max = sum;
        }
        return max;
    }
}
