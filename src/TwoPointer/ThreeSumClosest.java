//Question:16
//Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
//
//Return the sum of the three integers.
//
//You may assume that each input would have exactly one solution.
//
// 
//
//Example 1:
//
//Input: nums = [-1,2,1,-4], target = 1
//Output: 2
//Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
//Example 2:
//
//Input: nums = [0,0,0], target = 1
//Output: 0
//Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).

package TwoPointer;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		
		int gap = Integer.MAX_VALUE;
		int ans = 0;
		
		for (int i = 0; i < nums.length; i++) {
			int l = i + 1;
			int r = nums.length -1;
			
			while (l < r) {
				int currentSum = nums[i] + nums[l] + nums[r];
				int currentGap = Math.abs(currentSum - target);
				if (currentSum == target) {
					return target;
				}
				else if (currentSum < target) {
					l++;
				}
				else {
					r--;
				}
				if (currentGap < gap) {
					gap = currentGap;
					ans = currentSum;
				}
			}
		}
		return ans;
	}
//	
//    public int threeSumClosest(int[] nums, int target) {
//    	Arrays.sort(nums);
//		int temp = nums[0] + nums[1] + nums[2];
//		
//		for (int i = 0; i < nums.length - 2; i++)
//		{
//			if (i > 0 && nums[i] == nums[i-1])
//			{
//				continue;
//			}
//			int index_A = i + 1;
//			int index_B = nums.length - 1;
//			while (index_A < index_B)
//			{
//				int minSum = nums[i] + nums[index_A] + nums[index_B];
//				if (minSum == target)
//				{
//					return minSum;
//				}
//				if (Math.abs(minSum - target) < Math.abs(temp - target))
//				{
//					temp = minSum;
//				}
//				// if target > minSum means target is bigger than sum, since the array is sorted, which means the sum need some bigger value to add on
//				if (minSum < target) 
//				{
//					index_A++;
//				}
//				else
//				{
//					index_B--;
//				}
//			}
//		}
//		return temp;
//    }
}
