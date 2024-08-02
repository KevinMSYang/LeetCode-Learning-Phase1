//Question:340
//Given a string s and an integer k, return the length of the longest substring of s that contains at most k distnict characters

package SlidingWindows;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		char[] charArr = s.toCharArray();
		if (s.length() < 2) {
			return s.length();
		}
		if (k < 1) {
			return 0;
		}
		
		int l = 0;
		int r = 0;
		int maxLen = 0;
		Map<Character, Integer> map = new HashMap<>();
		
		while (r < charArr.length) {
			map.put(charArr[r], map.getOrDefault(charArr[r], 0) + 1);
			while (map.size() > k) {
				map.put(charArr[l], map.get(charArr[l]) -1);
				if (map.get(charArr[l]) == 0) {
					map.remove(charArr[l]);
				}
				l++;
			}
			maxLen = Math.max(maxLen, r - l +1);
			r++;
		}
		return maxLen;
	}
}
