import java.util.ArrayList;
import java.util.List;


public class Solution {
	public static List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<Integer>();
        
        for (int i = 0; i < Math.pow(2, n); i++) {
        	int gCode = (i >> 1) ^ i;
        	list.add(gCode);
        }
        
        return list;
    }
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list = grayCode(3);
		for (Integer i : list) {
			System.out.println(i);
		}
	}
}
