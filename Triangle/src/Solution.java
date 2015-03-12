import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxp19_000 on 2015-02-23.
 */


public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int rowLen = triangle.size();

        // dp数组用来存储每一格子的最优解
        int[][] sum = new int[rowLen][rowLen];

        // 最底下一行
        List<Integer> last = triangle.get(triangle.size()-1);
        for(int i=0; i<last.size(); i++){
            sum[rowLen-1][i] = last.get(i);
        }

        // Bottom-up DP
        for(int i=rowLen-2; i>=0; i--){
            List<Integer> row = triangle.get(i);
            for(int j=0; j<=i; j++){
                sum[i][j] = Math.min(sum[i+1][j], sum[i+1][j+1]) + row.get(j);
            }
        }

        return sum[0][0];
   /*     if (triangle.size() == 0) return 0;
        int len = triangle.size();
        int[][] dp = new int[len][len];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            dp[i][len - 1] = dp[i - 1][len - 1] + triangle.get(i).get(triangle.get(i).size() - 1);
        }

        for (int i = 1; i < triangle.size(); i++)
            for (int j = 1; j < triangle.get(i).size(); j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
            }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++)
            min = min > dp[len - 1][i] ? dp[len - 1][i] : min;
        return min;*/
    }
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        ArrayList<Integer> list4 = new ArrayList<Integer>();
        list1.add(-1);
        list2.add(2);
        list2.add(3);
        list3.add(1);
        list3.add(-1);
        list3.add(-3);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        System.out.print(new Solution().minimumTotal(list));

    }


}
