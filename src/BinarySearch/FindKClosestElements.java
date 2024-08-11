//Question:658
//Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
//
//An integer a is closer to x than an integer b if:
//
//    |a - x| < |b - x|, or
//    |a - x| == |b - x| and a < b
//
// 
//
//Example 1:
//
//Input: arr = [1,2,3,4,5], k = 4, x = 3
//Output: [1,2,3,4]
//
//Example 2:
//
//Input: arr = [1,2,3,4,5], k = 4, x = -1
//Output: [1,2,3,4]

package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0;
        int r = arr.length - k;
        
        while (l < r) {
        	int mid = l + (r - l) /2;
        	if (x - arr[mid] > arr[mid+k] - x) {
        		l = mid + 1;
        	}
        	else {
        		r = mid;
        	}
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = l; i < l + k; i++) {
        	list.add(arr[i]);
        }
        return list;
    }
}
