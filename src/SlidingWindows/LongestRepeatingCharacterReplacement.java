//Question:424
//You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
//
//Return the length of the longest substring containing the same letter you can get after performing the above operations.
//
// 
//
//Example 1:
//
//Input: s = "ABAB", k = 2
//Output: 4
//Explanation: Replace the two 'A's with two 'B's or vice versa.
//Example 2:
//
//Input: s = "AABABBA", k = 1
//Output: 4
//Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
//The substring "BBBB" has the longest repeating letters, which is 4.
//There may exists other ways to achieve this answer too.


package SlidingWindows;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
	public int characterReplacement(String s, int k) {
		char[] charArr = s.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		
		int l = 0;
		int r = 0;
		int maxLen = 0;
		int mostFreq = 0;
		
		while (r < charArr.length) {
			map.put(charArr[r], map.getOrDefault(charArr[r], 0) + 1);
			mostFreq = Math.max(map.get(charArr[r]), mostFreq);
			
			if ((r - l + 1) - mostFreq > k) {
				map.put(charArr[l], map.get(charArr[l]) -1);
				l++;
			}
			maxLen = Math.max(maxLen, r - l + 1);
			r++;
		}
		return maxLen;
	}
}
