package solutions;

import java.util.stream.IntStream;

public class _1295 {

    public static class Solution1 {

        public int findNumbers(int[] nums) {
            return Math.toIntExact(
                    IntStream.of(nums)
                             .boxed()
                             .map(this::findDigits)
                             .filter(this::isEven)
                             .count());
        }

        private int findDigits(int num) {
            var digits = 0;
            while (num > 0) {
                digits++;
                num /= 10;
            }
            return digits;
        }

        public boolean isEven(int num) {
            return num % 2 == 0;
        }
    }

    public static class Solution2 {

        public int findNumbers(int[] nums) {
            return Math.toIntExact(
                    IntStream.of(nums)
                             .boxed()
                             .map(String::valueOf)
                             .filter(s -> s.length() % 2 == 0)
                             .count()
            );
        }
    }
}
