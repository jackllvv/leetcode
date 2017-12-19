package leetcode;

/**
 * <p>
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1: <br>
 * 
 * Input: 123 <br>
 * Output: 321 <br>
 * 
 * <p>
 * Example 2: <br>
 * Input: -123 <br>
 * Output: -321 <br>
 * <p>
 * Example 3: <br>
 * Input: 120 <br>
 * Output: 21 <br>
 * 
 * @author zhousong
 *
 */
public class Question7 {

	public int reverse(int x) {
		int result = 0;
		while (x != 0) {
			int mod = x % 10;
			x = x / 10;
			if (result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10) return 0;
			result = result * 10 + mod;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Question7 question = new Question7();
		int reverse = question.reverse(1534236469);
		System.out.println(reverse);
		
	}
}
