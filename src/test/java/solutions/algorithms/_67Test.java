package solutions.algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class _67Test {

    private static _67.Solution solution = new _67.Solution();

    @Test
    void shouldAdd() {
        String a = "1001";
        String b = "101";
        var expected = "1110";
        var actual = solution.addBinary(a, b);
        assertEquals(expected, actual);
    }

    @Test
    void shouldAddWithAdditionalCarry() {
        String a = "1";
        String b = "11";
        var expected = "100";
        var actual = solution.addBinary(a, b);
        assertEquals(expected, actual);
    }
}