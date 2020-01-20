
public class Solution {
	public int maxProfit(int[] prices) {
		if (prices.length < 1) return 0;
		int profit = 0;
        for (int i = 1; i < prices.length; i++) {
        	if (prices[i] > prices[i-1])
        		profit += prices[i] - prices[i-1];
        }
        return profit;
    }
	
	public static void main(String[] args) {
		int prices[] = {1,3,9,7,8};
		int profit = new Solution().maxProfit(prices);
		System.out.println(profit);
	}
}
