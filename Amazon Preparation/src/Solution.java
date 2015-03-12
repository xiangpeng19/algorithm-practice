
import javax.swing.tree.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lxp19_000 on 2015-02-24.
 */
public class Solution {

   public ArrayList<Integer> sameElement(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        Set<Integer> oldSet = new HashSet<Integer>();
        Set<Integer> newSet = new HashSet<Integer>();
        for (int i : list1)
            oldSet.add(i);

        for (int i : list2) {
            if (oldSet.contains(i))
                newSet.add(i);
        }

        Iterator it = newSet.iterator();
        while (it.hasNext()) {
            temp.add((Integer)it.next());
        }

        return temp;

    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
       map.put();
       map.containsKey();
       Set set = map.entrySet();
       Iterator it = set.iterator();
       while (it.hasNext()) {
           Map.Entry entry = it.next();
           entry.getKey();
           entry.getValue();
       }

   }



    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        list1.add(1);
        list1.add(3);
        list1.add(2);
        list2.add(5);
        temp = new Solution().sameElement(list1, list2);
        for (int i : temp) System.out.print(i);

    }
}
