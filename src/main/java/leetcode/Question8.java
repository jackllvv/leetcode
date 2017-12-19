package leetcode;

/**
 * <p>
 * Implement atoi to convert a string to an integer.
 * 
 * <p>
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 * 
 * <p>
 * Notes: It is intended for this problem to be specified vaguely (ie, no given
 * input specs). You are responsible to gather all the input requirements up
 * front.
 * 
 * @author zhousong
 *
 */
public class Question8 {
	
	public int myAtoi(String str) {
		if (str == null || str.trim().length() == 0) return 0;
		str = str.trim();
		int result = 0;
		int flag = 1;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (i == 0) {
				if (c == '+') {
				} else if (c == '-') {
					flag = -1;
				} else if (c >= '0' && c <= '9') {
					result = result * flag + (c - '0') * flag;
				} else {
					return 0;
				}
			} else {
 				if (c >= '0' && c <= '9') {
 					int before = result;
					result = result * 10 + (c - '0') * flag;
 					if (before > 0 && (Integer.MAX_VALUE - (c - '0') * flag) / 10 < before) {
						return Integer.MAX_VALUE;
					}
					if (before < 0 && (Integer.MIN_VALUE - (c - '0') * flag) / 10 > before) {
						return Integer.MIN_VALUE;
					}
				} else {
					break;
				}
			}
			
			
		}
		return result;
	}
	
	public static void main(String[] args) {
		Question8 question = new Question8();
		int result = question.myAtoi("-2147483647");
		System.out.println(result);
		System.out.println(Integer.MIN_VALUE);
	}
}
