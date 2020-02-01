package solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import solutions.algorithms._1295.Solution1;
import solutions.algorithms._1295.Solution2;

class _1295Test {

    private static Solution1 solution1 = new Solution1();
    private static Solution2 solution2 = new Solution2();

    @Test
    void canCountEven1() {
        int[] nums = {12, 345, 2, 6, 7896};
        assertEquals(solution1.findNumbers(nums), 2);
        assertEquals(solution2.findNumbers(nums), 2);
    }

    @Test
    void canCountEven2() {
        int[] nums = {555, 901, 482, 1771};
        assertEquals(solution1.findNumbers(nums), 1);
        assertEquals(solution2.findNumbers(nums), 1);
    }
}