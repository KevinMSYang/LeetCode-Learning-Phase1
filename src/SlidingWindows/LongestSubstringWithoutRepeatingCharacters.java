//Question:3
//Given a string s, find the length of the longest 
//substring
// without repeating characters.
//
// 
//
//Example 1:
//
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//Example 2:
//
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//Example 3:
//
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

package SlidingWindows;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLengthSubstring(String s) {
		char[] charArr = s.toCharArray();
		if (s.length() < 2) {
			return s.length();
		}
		
		int l = 0;
		int r = 0;
		int maxLen = 0;
		Map<Character, Integer> map = new HashMap<>();
		
		while (r < charArr.length) {
			if (!map.containsKey(charArr[r])) {
				map.put(charArr[r], 1);
				maxLen = Math.max(maxLen, r - l + 1);
				r++;
			}else
			{
				map.remove(charArr[l]);
				l++;
			}
		}
		
		
//		while (r < charArr.length) {
//			// add current element
//			map.put(charArr[r], map.getOrDefault(charArr[r], 0) + 1);
//			//check if we meet the condition
//			while (map.size() != r - l +1) {
//				map.put(charArr[l], map.get(l) -1);
//				if (map.get(charArr[l]) == 0) {
//					map.remove(charArr[l]);
//				}
//				l++;
//				//update the maxlen
//				maxLen = Math.max(maxLen, r - l +1);
//				//move r one to the right
//				r++;
//			}
//		}
		
		
		return maxLen;
	}
	
//    public int lengthOfLongestSubstring(String s) {
//        List<Character> list = new ArrayList<>();
//
//        int len = 0;
//		for (int l = 0, r = 0; r < s.length(); r++) {
//			if (!list.contains(s.charAt(r))) {
//				list.add(s.charAt(r));
//			}
//			else {
//				len = Math.max(len, r - l);
//		        r--;
//				list.remove(0);
//				l++;
//			}
//		}
//		return Math.max(len, list.size());
//    }
}
