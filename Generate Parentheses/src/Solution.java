import java.util.ArrayList;
import java.util.List;


public class Solution {
	public static List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		String s = new String();
		recursive(n, n, s, list);
		return list;
	}
	
	
	
	
	public static void recursive(int left, int right, String s, List<String> list) {
		if (left == 0 && right == 0) {
			list.add(new String(s));
			return;
		}
		if (left != 0) {
			recursive(left - 1, right, s + '(', list);
		}
		if (left < right && right != 0) {
			recursive(left, right - 1, s + ')', list);
		}

	}
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list = generateParenthesis(5);
		for (String s : list) {
			System.out.println(s);
		}
	}
}
