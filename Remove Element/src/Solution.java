import java.util.ArrayList;



public class Solution {

	public static int removeElement(int[] A, int elem) {
	
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < A.length; i++){
			list.add(A[i]);
		}
		
		for (int j = 0; j < list.size(); j++) {
			if (list.get(j).equals(elem)) {
				list.remove(j);
	//			j--;
			}
		}
		
		return list.size();
    }
	
	
	public static void main(String[] args){
		int x[] = {4,5};
		System.out.println(x.length);
		int a = removeElement(x, 4);
		System.out.println(a);
	}
}
