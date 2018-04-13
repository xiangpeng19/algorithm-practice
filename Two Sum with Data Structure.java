import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TwoSum {


    Map<Integer, Integer> map;

    public TwoSum() {

        map = new HashMap<>();
    }


    public void add(int num) {
        if (map.containsKey(num)) {
            map.put(num, map.get(num) + 1);
        } else {
            map.put(num, 1);
        }
    }


    public boolean find(int num) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int target = num - entry.getKey();
            if (target == entry.getKey()) {
                return entry.getValue() > 1;
            } else {
                return map.containsKey(target);
            }
        }

    }


    Set<Integer> sum; 
    Set<Integer> nums; 

    public TwoSum() {
        sum = new HashSet<>();
        nums = new HashSet<>();
    }
    
    public void add(int num) {
        if (nums.contains(num)) {
            sum.add(num + num);
        } else {
            Iterator<Integer> iter = nums.iterator();
            while (iter.hasNext()) {
                sum.add(num + iter.next());
            }
            nums.add(num);
        }

    }


    public boolean find(int num) {
        return sum.contains(num);
    }
}