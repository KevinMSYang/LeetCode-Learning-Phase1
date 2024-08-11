//Question:34
//Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
//
//If target is not found in the array, return [-1, -1].
//
//You must write an algorithm with O(log n) runtime complexity.
//
// 
//
//Example 1:
//
//Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
//
//Example 2:
//
//Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
//
//Example 3:
//
//Input: nums = [], target = 0
//Output: [-1,-1]


package BinarySearch;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length -1;
        int[] ans = {-1, -1};
        
        if (nums.length < 2) {
        	if (nums.length == 0) return ans;
        	if (nums.length == 1) {
        		if (nums[0] == target) return new int[] {0,0};
        		else return ans;
        	}
        }
        while (l <= r) {
        	int mid = l + (r - l) /2;
            if (nums[mid] == target) {
                r = mid;
                while (r < nums.length && nums[r] == target) {
                    r++;        
                }
                l = mid;
                while (l >= 0 && nums[l] == target) {
                    l--;
                }
                ans[0] = l+1;
                ans[1] = r-1;
                return ans;
            }
        	else if (nums[mid] < target) {
        		l = mid +1;
        	}
        	else {
        		r = mid -1;
        	}
        }
        return ans;
    }
    
//    public int[] searchRange(int[] nums, int target) {
//        final int l = firstGreaterEqual(nums, target);
//        if (l == nums.length || nums[l] != target)
//          return new int[] {-1, -1};
//        final int r = firstGreaterEqual(nums, target + 1) - 1;
//        return new int[] {l, r};
//      }
//
//      private int firstGreaterEqual(int[] A, int target) {
//        int l = 0;
//        int r = A.length;
//        while (l < r) {
//          final int m = (l + r) / 2;
//          if (A[m] >= target)
//            r = m;
//          else
//            l = m + 1;
//        }
//        return l;
//      }
}
