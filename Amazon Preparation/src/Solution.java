
import javax.swing.tree.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lxp19_000 on 2015-02-24.
 */
public class Solution {

    public void Min(int A[]) {
        if (A.length == 0) return;
        int start = 0, end = A.length - 1;
        int mid = 0;

        if (A[start] < A[end]) System.out.println(A[start]);

        while (start < end) {
            mid =(start + end) / 2;

            if (A[mid] < A[end]) end = mid;
            else if (A[mid] > A[end]) start = mid + 1;
        }
        System.out.println(A[start]);

    }

    public static void main(String[] args) {
        int A[] = {5,6,7,8,9,10,1,2,3,4};

        new Solution().Min(A);
    }
}
