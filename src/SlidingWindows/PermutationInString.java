//Question:567
//Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
//
//In other words, return true if one of s1's permutations is the substring of s2.
//
// 
//
//Example 1:
//
//Input: s1 = "ab", s2 = "eidbaooo"
//Output: true
//Explanation: s2 contains one permutation of s1 ("ba").
//Example 2:
//
//Input: s1 = "ab", s2 = "eidboaoo"
//Output: false

package SlidingWindows;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
    	// define table
    	int[] arr = new int[128];
    	
    	// define the pointers
    	int l = 0;
    	int r = 0;
    	
    	// fill up table
    	char[] s1Arr = s1.toCharArray();
    	char[] s2Arr = s2.toCharArray();
    	
    	for (char c : s1Arr) {
    		arr[c]++;
    	}
    	
    	// define minLen
    	int minLen = Integer.MAX_VALUE;
    	// define counter
    	int counter = 0;
    	// check if there is a permutation
    	while (r < s2Arr.length) {
    		// expend window
    		char cur = s2Arr[r];
    		if (--arr[cur] >= 0) {
    			counter++;
    		}
    		// contract window
    		while (counter == s1.length()) {
    			int curLen = r - l +1;
    			minLen = Math.min(curLen, minLen);
    			char leftChar = s2Arr[l];
    			if (++arr[leftChar] > 0) {
    				counter--;
    			}
    			l++;
    		}
    		r++;
    	}
    	// return if minlen == size of s1
    	return minLen == s1.length();
    }
}
