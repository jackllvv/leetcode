package leetcode;

/**
 * <h1> Container With Most Water</h1>
 * 
 * <p>
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
 * <p>
 * Note: You may not slant the container and n is at least 2.
 * 
 * @author zhousong
 *
 */
public class Question11 {

	public int maxArea(int[] height) {
		int l = 0, r = height.length - 1, maxArea = 0;
		while (l < r) {
			maxArea = Math.max(maxArea, (r - l) * Math.min(height[l], height[r]));
			if (height[r] > height[l]) {
				r--;
			} else {
				l++;
			}
		}
		return maxArea;
    }
}
