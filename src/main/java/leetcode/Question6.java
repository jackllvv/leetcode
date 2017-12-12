package leetcode;

/**
 * <p>ZigZag Conversion
 * <p>The string "PAYPALISHIRING" is written in a zigzag pattern
 * on a given number of rows like this: (you may want to display this pattern in
 * a fixed font for better legibility)
 * 
 * <p>P   A   H   N
 * <p>A P L S I I G
 * <p>Y   I   R
 * 
 * <p>And then read line by line: "PAHNAPLSIIGYIR" Write the code that will take a
 * string and make this conversion given a number of rows:
 * 
 * <p>string convert(string text, int nRows);
 * 
 * <p>convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * 
 * @author zhousong
 *
 */
public class Question6 {

    public String convert(String s, int numRows) {
    	StringBuffer[] sbs = new StringBuffer[numRows];
    	for (int i = 0; i < sbs.length; i++) {
    		sbs[i] = new StringBuffer();
    	}
    	int flag = 0;
    	int step = -1;
    	for (int i = 0; i < s.length(); i++) {
    		sbs[flag].append(s.charAt(i));
    		if (flag == numRows - 1 || flag == 0) {
    			step = -step;
    		}
    		flag += step;
    		if (flag < 0) {
    			flag = 0;
    		}
    		if (flag > numRows - 1) {
    			flag = numRows - 1;
    		}
    	}
    	
    	StringBuffer result = new StringBuffer();
    	for(StringBuffer sb : sbs) {
    		result.append(sb);
    	}
    	return result.toString();
    }
    
    public static void main(String[] args) {
		Question6 question6 = new Question6();
		String convert = question6.convert("AB", 1);
		System.out.println(convert);
	}
}
