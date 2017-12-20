package leetcode;

/**
 * <p>
 * Implement regular expression matching with support for '.' and '*'.
 * <p>
 * '.' Matches any single character.
 * <p>
 * '*' Matches zero or more of the preceding element.
 * <p>
 * The matching should cover the entire input string (not partial).
 * 
 * <p>
 * The function prototype should be: bool isMatch(const char *s, const char *p)
 * <p>
 * Some examples: <br>
 * isMatch("aa","a") ¡ú false <br>
 * isMatch("aa","aa") ¡ú true <br>
 * isMatch("aaa","aa") ¡ú false <br>
 * isMatch("aa", "a*") ¡ú true <br>
 * isMatch("aa", ".*") ¡ú true <br>
 * isMatch("ab", ".*") ¡ú true <br>
 * isMatch("aab", "c*a*b") ¡ú true
 * 
 * @author zhousong
 *
 */
public class Question10 {

	public boolean isMatch(String text, String pattern) {
		if (pattern.isEmpty())
			return text.isEmpty();
		boolean first_match = (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

		if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
			return (isMatch(text, pattern.substring(2)) || (first_match && isMatch(text.substring(1), pattern)));
		} else {
			return first_match && isMatch(text.substring(1), pattern.substring(1));
		}
	}

	public static void main(String[] args) {
		Question10 question10 = new Question10();
		System.out.println(question10.isMatch("aaaaaaaab", "a*b"));
	}
}
