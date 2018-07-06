/*
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.


*/


public class Solution {
    public int maxProduct(int[] nums) {

        if(nums.length == 1) return nums[0];

        if(nums.length == 0) return 0;

        int pos[] = new int[nums.length];
        int neg[] = new int[nums.length];

        if(nums[0] == 0){
            pos[0] = 0;
            neg[0] = 0;
        }

        if(nums[0] > 0)
        pos[0] = nums[0];

        else
        neg[0] = nums[0];

        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] == 0) // zero
            {
                pos[i] = 0;
                neg[i] = 0;
            }

            if(nums[i] > 0) // positive
            {

                if(pos[i-1] > 0)
                {
                    pos[i] = nums[i] * pos[i-1];
                }
                else{
                    pos[i] = nums[i];
                }

                if(neg[i-1] < 0)
                {
                    neg[i] = neg[i-1] * nums[i];
                }
                else neg[i] = 0;
            }

            if(nums[i] < 0) // negative
            {
                if(neg[i-1] < 0)
                {
                    pos[i] = nums[i] * neg[i-1];
                }
                else pos[i] =0;

                if(pos[i-1] > 0){
                    neg[i] = pos[i-1] * nums[i];
                }
                else neg[i] = nums[i];
            }
        }

        int pos_max = pos[0];

        for(int i = 1; i < pos.length; i++)
        {

            if(pos_max < pos[i]){
                pos_max = pos[i];

            }
        }

        return pos_max;
    }
}
