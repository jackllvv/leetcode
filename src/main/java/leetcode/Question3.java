package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * <p>
 * Examples:
 * 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the
 * answer must be a substring, "pwke" is a subsequence and not a substring
 * 
 * @author zhousong
 *
 */
public class Question3 {

	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int max = 0, i = 0, j = 0;
		while (i < n && j < n) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				max = Math.max(max, j - i);
			} else {
				set.remove(s.charAt(i++));
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		Question3 question3 = new Question3();
		int len = question3.lengthOfLongestSubstring("abcabcbb");
		System.out.println(len);
	}
}
