
import javax.swing.tree.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lxp19_000 on 2015-02-24.
 */
public class Solution {

   public int Cars(String present, String desired) {
        if (desired == null || present == null) return -1;
        if (present.length() != desired.length()) return -1;
        if (present.equals(desired)) return 0;

        char[] Pres = present.toCharArray();
        char[] Desi = desired.toCharArray();
        int count = 0;

        for (int i = 0; i < present.length(); i++) {

            //if the spots are same, just find next spot
            if (Pres[i] == Desi[i]) continue;

            //if the present spot has a car, and the desire spot doesn't, we have to move a car to here
            if (Pres[i] == ' ' && Desi[i] != ' ') {
                int j = i + 1;//the nearest spot which has a car in the present string
                for (; j < Pres.length && Pres[j] == ' '; j++) ;
                char temp = Pres[i];
                Pres[i] = Pres[j];
                Pres[j] = temp;
                count += j - i;
            }

            //if the present spot does have a car, and the desire spot has, we have to remove a car from here
            if (Pres[i] != ' ' && Desi[i] == ' ') {
                int j = i + 1;//the nearest spot which does have a car in the present string
                for (; j < Pres.length && Pres[j] != ' '; j++) ;
                char temp = Pres[i];
                Pres[i] = Pres[j];
                Pres[j] = temp;
                count += j - i;
            }
        }
       return count;
   }



    public static void main(String[] args) {
        String present = "  1  ";
        String desired = "1    ";
        System.out.println(new Solution().Cars(present, desired));

    }
}
