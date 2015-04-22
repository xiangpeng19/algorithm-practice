import java.util.HashMap;

/**
 * Created by lxp19_000 on 2015-04-22.
 */
public class Solution {
    public boolean isHappy(int n) {
        if (n <= 0) return false;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int res = 0;
        while (res != 1) {
            res = 0;
            while (n != 0) {
                res += ( n % 10 ) * ( n % 10 );
                n /= 10;
            }
            if (map.containsKey(res)) return false;
            map.put(res, 1);
            n = res;
        }
        return true;
    }




    /*
    public boolean isHappy(int n) {
        if (n <= 0) return false;
        ArrayList<Integer> list = splitNumber(n);
        int sum = checkSum(list);
        while (sum != 1) {
            list = splitNumber(sum);
            sum = checkSum(list);
        }
        return true;
    }

    ArrayList<Integer> splitNumber(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (n != 0) {
            list.add(n%10);
            n /= 10;
        }
        return list;
    }

    int checkSum(ArrayList<Integer> list) {
        int res = 0;
        while (!list.isEmpty()) {
            res += list.get(0) * list.get(0);
            list.remove(0);
        }
        return res;
    }
    */
    public static void main(String[] args) {
        System.out.println(new Solution().isHappy(19));
    }
}