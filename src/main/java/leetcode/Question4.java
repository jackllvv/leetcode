package leetcode;

/**
 * <p>There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * <p>example1: nums1 = [1, 3] nums2 = [2]
 * 
 * The median is 2.0
 * 
 * <p>example2: nums1 = [1, 2] nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * @author zhousong
 *
 */
public class Question4 {
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		
		int k = (len1 + len2) / 2;
		if ((len1 + len2) % 2 == 0) {
			return (double)(findKth(nums1, nums2, 0, 0, len1, len2, k) + findKth(nums1, nums2, 0, 0, len1, len2, k + 1)) / 2;
		} else {
			return findKth(nums1, nums2, 0, 0, len1, len2, k + 1);
		}
		
	}
	
	private int findKth(int[] nums1, int[] nums2, int start1, int start2, int len1, int len2, int k) {
		if (len1 > len2) {
			return findKth(nums2, nums1, start2, start1, len2, len1, k);
		}
		if (len1 == 0) {
			return nums2[start2 + k - 1];
		}
		if (k == 1) {
			return Math.min(nums1[start1], nums2[start2]);
		}
		
		int p1 = Math.min(k/2, len1);
		int p2 = k - p1;
		if (nums1[start1 + p1 - 1] < nums2[start2 + p2 - 1]) {
			return findKth(nums1, nums2, start1 + p1, start2, len1 - p1, len2, k - p1);
		} else if (nums1[start1 + p1 - 1] > nums2[start2 + p2 - 1]) {
			return findKth(nums1, nums2, start1, start2 + p2, len1, len2 - p2, k - p2);
		} else {
			return nums1[start1 + p1 - 1];
		}
	}
	
	public static void main(String[] args) {
		Question4 question4 = new Question4();
		int[] arr1 = {1, 2};
		int[] arr2 = {3, 4};
		
		double num = question4.findMedianSortedArrays(arr1, arr2);
		System.out.println(num);
	}
}
