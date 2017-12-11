package leetcode;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 * 
 * <p>Example:
 * 
 * <p>Input: "babad"
 * 
 * <p>Output: "bab"
 * 
 * <p>Note: "aba" is also a valid answer. Example:
 * 
 * <p>Input: "cbbd"
 * 
 * <p>Output: "bb"
 * 
 * @author zhousong
 *
 */
public class Question5 {

	static class Manacher {
		private int[] len;//长度为i最长回文串的长度=len - 1,从左往右计算
		private String s;//原字符串
		private char[] t;//将字符串中间插入'#'后的字符数组。
		
		
		public Manacher(String s) {
			super();
			this.s = s;
		}


		/**
		 * 预处理字符串，例如，s="abba" 那么t="$#a#b#b#a#@"
		 */
		private void preprocess() {
			t = new char[s.length() * 2 + 3];
			t[0] = '$';
			t[s.length() * 2 + 2] = '@';
			for (int i = 0; i < s.length(); i++) {
				t[2*i + 1] = '#';
				t[2*i + 2] = s.charAt(i);
			}
			t[s.length()*2 + 1] = '#';
		}
		
		public void process() {
			preprocess();
			
			len = new int[t.length];
			int center = 0, right = 0;
			for (int i = 1; i < t.length - 1; i++) {
				int mirror = 2*center - i;
				
				if (right > i) {
					len[i] = Math.min(right - i, len[mirror]); 
				}
				
				while (t[i + (1 + len[i])] == t[i - (1 + len[i])]) {
					len[i]++;
				}
				
				if (i + len[i] > right) {
					center = i;
					right = i + len[i];
				}
			}
		}
		
		public String longestPalindromicSubstring() {
			int length = 0;
			int center = 0;
			for (int i = 1; i < len.length - 1; i++) {
				if (len[i] > length) {
					length = len[i];
					center = i;
				}
			}
			return s.substring((center - 1 -length) / 2, (center - 1 +length) / 2);
		}
		
		public static void main(String[] args) {
			String s = "ababaca";
			Manacher manacher = new Manacher(s);
			manacher.process();
			String str = manacher.longestPalindromicSubstring();
			System.out.println(str);
		}
	}
}
