package leetcode;

/**
 * <p>
 * Given an integer, convert it to a roman numeral.<br>
 * 
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author zhousong
 *
 */
public class Question12 {

	public String intToRoman(int num) {
		String[][] c = new String[][] { 
				{ "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" },
				{ "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" },
				{ "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" },
				{ "", "M", "MM", "MMM" }
		};
		
		StringBuffer sb = new StringBuffer();
		sb.append(c[3][num / 1000]);
		sb.append(c[2][(num % 1000) / 100]);
		sb.append(c[1][(num % 100) / 10]);
		sb.append(c[0][num % 10]);
		return sb.toString();
	}
}
