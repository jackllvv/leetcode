package leetcode;

/**
 * <p>
 * Given a roman numeral, convert it to an integer.<br>
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author zhousong
 *
 */
public class Question13 {
	
	public int romanToInt(String s) {
		int sum = 0;
		if (s.contains("IV"))
			sum -= 2;
		if (s.contains("IX"))
			sum -= 2;
		if (s.contains("XL"))
			sum -= 20;
		if (s.contains("XC"))
			sum -= 20;
		if (s.contains("CD"))
			sum -= 200;
		if (s.contains("CM"))
			sum -= 200;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'M')
				sum += 1000;
			if (s.charAt(i) == 'D')
				sum += 500;
			if (s.charAt(i) == 'C')
				sum += 100;
			if (s.charAt(i) == 'L')
				sum += 50;
			if (s.charAt(i) == 'X')
				sum += 10;
			if (s.charAt(i) == 'V')
				sum += 5;
			if (s.charAt(i) == 'I')
				sum += 1;
		}

		return sum;
	}
}
