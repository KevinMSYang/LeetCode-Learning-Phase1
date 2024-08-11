//Question:76
//Given two strings s and t of lengths m and n respectively, return the minimum window
//substring
//of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
//
//The testcases will be generated such that the answer is unique.
//
// 
//
//Example 1:
//
//Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
//Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
//
//Example 2:
//
//Input: s = "a", t = "a"
//Output: "a"
//Explanation: The entire string s is the minimum window.
//
//Example 3:
//
//Input: s = "a", t = "aa"
//Output: ""
//Explanation: Both 'a's from t must be included in the window.
//Since the largest window of s only has one 'a', return empty string.


package SlidingWindows;

public class MiniumnWindowSubstring {
    public String minWindow(String s, String t) {
        int[] arr = new int[128];
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        
        int l = 0;
        int r = 0;
        int counter = 0;
        String str = "";
        int minLen = Integer.MAX_VALUE;
        
        for (char c : tArr) {
        	arr[c]++;
        }
        
        while (r < sArr.length) {
        	char curChar = sArr[r];
        	if (--arr[curChar] >= 0) {
        		counter++;
        	}
        	while (counter == t.length()) {
        		if (minLen > r - l +1) {
        			minLen = r - l + 1;
        			str = s.substring(l,r +1);
        		}
        		char leftChar = sArr[l];
        		if (++arr[leftChar] > 0) {
        			counter--;
        		}
        		l++;
        	}
        	r++;
        }
        return str;
    }
}
