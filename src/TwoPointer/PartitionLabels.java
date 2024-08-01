//Question:763
//You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
//
//Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
//
//Return a list of integers representing the size of these parts.
//
// 
//
//Example 1:
//
//Input: s = "ababcbacadefegdehijhklij"
//Output: [9,7,8]
//Explanation:
//The partition is "ababcbaca", "defegde", "hijhklij".
//This is a partition so that each letter appears in at most one part.
//A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
//Example 2:
//
//Input: s = "eccbbbbdec"
//Output: [10]
		
		
package TwoPointer;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        char[] charArr = s.toCharArray();
        int[] lastIndex = new int[128];
        
        for (int i = 0; i < charArr.length; i++) {
        	char currentChar = charArr[i];
        	lastIndex[currentChar] = i;
        }
        
        int l = 0;
        int r = 0;
        int index = 0;
        
        while (index < charArr.length) {
        	char cur = charArr[index];
        	r = Math.max(r, lastIndex[cur]);
        	if (r == index) {
        		int size = r - l +1;
        		list.add(size);
        		r++;
        		l = r;
        	}
        	index++;
        }
        return list;
    }
}
