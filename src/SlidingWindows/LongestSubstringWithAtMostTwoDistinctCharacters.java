//Question: 159
//Given a string s, find the length of the longest substring t that contains at most 2 distinct characters



package SlidingWindows;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		char[] charArr = s.toCharArray();
		if (s.length() < 3) {
			return s.length();
		}
		
		int l = 0;
		int r = 0;
		int maxLength = 0;
		Map<Character, Integer> map = new HashMap<>();
		
		while (r < charArr.length) {
			map.put(charArr[r], map.getOrDefault(charArr[r], 0) + 1);
			while (map.size() > 2) {
				map.put(charArr[l], map.get(charArr[l]) -1);
				if (map.get(charArr[l]) == 0) {
					map.remove(charArr[l]);
				}
				l++;
			}
			maxLength = Math.max(maxLength, r - l + 1);
			r++;
		}
		return maxLength;
	}
}
