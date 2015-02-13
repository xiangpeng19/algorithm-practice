
public class Solution {
	
	public static int[] twoSum(int[] numbers, int target) 
	{
		int array[] = new int[numbers.length];
		for (int i : numbers) {
			array[i] = numbers[i];
		}
		
		for (int i = 0; i < array.length; i++)
		{
			for (int j = i; j < array.length; j++)
			{
				if (array[i] > array[j])
				{
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		
		for (int i:array) {
			System.out.println(i);
		}
	//	System.out.println(numbers.length);		
		int idx1 = 0, idx2 = array.length - 1;
		for (int i = 0; i < array.length; i++)
		{
			if (array[idx1] + array[idx2] < target)
				idx1++;
			if (array[idx1] + array[idx2] > target)
				idx2--; 
			if (array[idx1] + array[idx2] == target)
				break;
		}
		int temp[] = new int[2];
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] == numbers[idx1])
				idx1 = i;
			if (array[i] == numbers[idx2])
				idx2= i;
		}
		temp[0] = idx1;
		temp[1] = idx2;
		

		return temp;
    }

	public static void main(String[] args) 
	{
		int testCase[] = {2, 7, 11, 15, 22, 4, 3};
		int target = 5;
		int result[] = new int[2];
		result = twoSum(testCase, target);
		for (int i : result) {
			System.out.println(i);
		}
//		System.out.println(result);
	}

}
