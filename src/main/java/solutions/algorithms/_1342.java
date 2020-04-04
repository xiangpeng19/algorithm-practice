package solutions.algorithms;

public class _1342 {

    public static class Solution {

        public int numberOfSteps(int num) {
            int count = 0;
            while (num != 0) {
                if (num % 2 == 0) {
                    num /= 2;
                } else {
                    num--;
                }
                count++;
            }

            return count;
        }
    }

}
