package solutions.algorithms;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class _125Test {

    private static _125.Solution solution = new _125.Solution();

    @Test
    public void shouldWork() {
        assertFalse(solution.isPalindrome("0P"));
    }

}