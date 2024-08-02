//Question:487
//Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.

package SlidingWindows;

public class MaxConsecutiveOnesII {
	public int findMaxConsecutiveOnes(int[] nums) {
		if (nums.length < 2) {
			return nums.length;
		}
		int l = 0;
		int r = 0;
		int count = 0;
		int maxLen = 0;
		
		while (r < nums.length) {
			if (nums[r] == 0) {
				count++;
			}
			// contract window if we don't meet the condition
			while (count > 1) {
				if (nums[l] == 0) {
					count--;
				}
				l++;
			}
			// update the maxLen
			maxLen = Math.max(maxLen, r - l + 1);
			r++;
		}
		return maxLen;
	}
}
