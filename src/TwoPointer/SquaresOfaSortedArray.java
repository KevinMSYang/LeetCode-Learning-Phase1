//Question:977
//Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
//
//		 
//
//Example 1:
//
//Input: nums = [-4,-1,0,3,10]
//Output: [0,1,9,16,100]
//Explanation: After squaring, the array becomes [16,1,0,9,100].
//After sorting, it becomes [0,1,9,16,100].
//Example 2:
//
//Input: nums = [-7,-3,2,3,11]
//Output: [4,9,9,49,121]
		
package TwoPointer;

public class SquaresOfaSortedArray {
	public int[] sortedSquares(int[] nums) {
		int l = 0;
		int r = nums.length -1;
		int index = nums.length -1;
		int[] ans = new int[nums.length];
		
		while (0 <= index) {
			int left = nums[l] * nums[l];
			int right = nums[r] * nums[r];
			
			if (left < right) {
				ans[index] = right;
				r--;
			}
			else {
				ans[index] = left;
				l++;
			}
			index--;
		}
		return ans;	
	}
	
//    public int[] sortedSquares(int[] nums) {
//		for (int i = 0; i < nums.length; i++)
//		{
//			nums[i] = (int) Math.pow(nums[i], 2);
//		}
//		Arrays.sort(nums);
//		return nums;
//    }
}
