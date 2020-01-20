
public class Solution {
    public static int maxProfit(int[] prices) {
    	if (prices.length == 0) return 0;
    	int min = prices[0];
    	int profit = 0;
    	
    	for (int i = 1; i < prices.length; i++) {
    		if ( min > prices[i]) min = prices[i];
    		else if (profit < prices[i] - min) profit = prices[i] - min;
    	}
    	return profit;
/*        if (prices.length == 0) return 0;
        int buy, sell;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
        	buy = prices[i];
			for (int j = i; j < prices.length; j++) {
				sell = prices[j];
				if (profit < sell - buy) profit = sell - buy;
			}
		}
        
        return profit;*/
    }
    
    public static void main(String[] args) {
		int prices[] = {4, 3, 1, 7, 8, 9};
		System.out.println(maxProfit(prices));
	}
}
