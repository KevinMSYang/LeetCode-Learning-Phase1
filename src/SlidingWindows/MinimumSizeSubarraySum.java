//Question: 209
//Given an array of positive integers nums and a positive integer target, return the minimal length of a 
//subarray
// whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
//
// 
//
//Example 1:
//
//Input: target = 7, nums = [2,3,1,2,4,3]
//Output: 2
//Explanation: The subarray [4,3] has the minimal length under the problem constraint.
//Example 2:
//
//Input: target = 4, nums = [1,4,4]
//Output: 1
//Example 3:
//
//Input: target = 11, nums = [1,1,1,1,1,1,1,1]
//Output: 0

package SlidingWindows;

public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int target, int[] nums) {
		int l = 0; 
		int r = 0;
		int minSize = Integer.MAX_VALUE;
		int sum = 0;
		
		while (r < nums.length) {
			sum += nums[r];
			while (target <= sum) {
				minSize = Math.min(minSize, r - l +1);
				sum -= nums[l];
				l++;
			}
			r++;
		}
		
		return sum == Integer.MAX_VALUE? 0 : minSize;
	}
}
