package leetcode;

/**
 * <p>
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * @author zhousong
 *
 */
public class Question9 {

	public boolean isPalindrome(int x) {
		if (x < 0 || (x % 10 == 0 && x != 0)) return false;
		
        int revert = 0;
        while (x > revert) {
        	revert = revert * 10 + x % 10; 
        	x /= 10;
        }
        
        return x == revert || x == revert / 10;
    }
	
	public static void main(String[] args) {
		Question9 question9 = new Question9();
		boolean palindrome = question9.isPalindrome(121);
		System.out.println(palindrome);
	}
}
