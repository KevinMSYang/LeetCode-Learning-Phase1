//Question: 42
//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
//Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
//Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
//Example 2:
//
//Input: height = [4,2,0,3,2,5]
//Output: 9

package TwoPointer;

public class TrappingRainWater {
    public int trap(int[] height) {
    	int sum = 0;
        int maxHeight = 0;
        for (int i = 0; i < height.length; i++) {
        	if (height[maxHeight] < height[i]) {
        		maxHeight = i;
        	}
        }
        int leftMax = 0;
        for (int i = 0; i < maxHeight; i++) {
        	if (height[leftMax] < height[i]) {
        		leftMax = i;
        	}
        	sum += Math.min(height[leftMax], height[maxHeight]) - height[i];
        }

        int rightMax = height.length - 1;
        for (int i = height.length -1; i > maxHeight; i--) {
        	if (height[rightMax] < height[i]) {
        		rightMax = i;
        	}
        	sum += Math.min(height[rightMax], height[maxHeight]) - height[i];
        }
        return sum;
    }
    
    // dp:
//    public int trap(int[] height) {
//        int[] leftMax = new int[height.length];
//        int[] rightMax = new int[height.length];
//        
//        for (int i = 0; i < leftMax.length; i++) {
//        	if (i == 0) {
//        		leftMax[i] = height[i];
//        	}
//        	else {
//        		leftMax[i] = Math.max(leftMax[i-1], height[i]);
//        	}
//        }
//        for (int i = height.length -1; i >= 0; i--) {
//        	if (i == height.length -1) {
//        		rightMax[i] = height[i];
//        	}
//        	else {
//        		rightMax[i] = Math.max(rightMax[i+1], height[i]);
//        	}
//        }
//        
//        int sum = 0;
//        for (int i = 0; i < height.length; i++) {
//        	sum += Math.min(leftMax[i], rightMax[i]) - height[i];
//        }
//        return sum;
//    }
}
