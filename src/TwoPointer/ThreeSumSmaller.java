//Question:259
//Given an array of n integers nums and an integer target,
//find the number of index triplets i, j, k with 0 <= i < j < k < n
//that satisfy the condition nums[i] + nums[j] + nums[k] < target

package TwoPointer;

import java.util.Arrays;

public class ThreeSumSmaller {
	public int threeSumSmaller(int[] nums, int target) {
		Arrays.sort(nums);
		
		int counter = 0;
		
		for (int i = 0; i < nums.length; i++) {
			int l = i + 1;
			int r = nums.length -1;
			
			while (l < r) {
				int currentSum = nums[i] + nums[l] + nums[r];
				if (currentSum < target) {
					counter += r - l;
					l++;
				}
				else {
					r--;
				}
			}
		}
		
		return counter;
	}
	public static void main(String[] args) {
		ThreeSumSmaller tss = new ThreeSumSmaller();
		int[] nums = {-2, 0, 1, 3};
		int target = 2;
		System.out.println(tss.threeSumSmaller(nums, target));
	}
}
