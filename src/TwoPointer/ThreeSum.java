//Question:15
//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//
//Notice that the solution set must not contain duplicate triplets.
//
// 
//
//Example 1:
//
//Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
//Explanation: 
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//The distinct triplets are [-1,0,1] and [-1,-1,2].
//Notice that the order of the output and the order of the triplets does not matter.
//Example 2:
//
//Input: nums = [0,1,1]
//Output: []
//Explanation: The only possible triplet does not sum up to 0.
//Example 3:
//
//Input: nums = [0,0,0]
//Output: [[0,0,0]]
//Explanation: The only possible triplet sums up to 0.

package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		
		if (nums.length < 3) {
			return list;
		}
		Arrays.sort(nums);
		
		for (int i = 0; i +2 < nums.length; i++) {
			if (i != 0 && nums[i] == nums[i-1]) {
				continue;
			}
			int l = i +1;
			int r = nums.length -1;
			while (l < r) {
				int ans = nums[i] + nums[l] + nums[r];
				if (ans == 0) {
					List<Integer> subList = new ArrayList<>();
					subList.add(nums[i]);
					subList.add(nums[l]);
					subList.add(nums[r]);
					list.add(subList);
					l++;
					r--;
					
					while (l < r && nums[l] == nums[l -1]) {
						l++;
					}
					while (l < r && nums[r] == nums[r +1]) {
						r--;
					}
				}
				else if (ans < 0) {
					l++;
				}
				else {
					r--;
				}
			}
		}
		return list;
	}
	
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> list = new ArrayList<>();
//        
//        Arrays.sort(nums);
//        
//        for (int i = 0; i + 2 < nums.length; i++) {
//        	if (i > 0 && nums[i] == nums[i-1]) {
//        		continue;
//        	}
//        	int r = nums.length -1;
//        	int l = i + 1;
//        	
//        	while ( l < r) {
//                final int sum = nums[i] + nums[l] + nums[r];
//                if (sum == 0) {
//                  list.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
//                  while (l < r && nums[l] == nums[l - 1])
//                    ++l;
//                  while (l < r && nums[r] == nums[r + 1])
//                    --r;
//                } else if (sum < 0) {
//                  ++l;
//                } else {
//                  --r;
//                }
//        	}
//        }
//        return list;
//    }
}
