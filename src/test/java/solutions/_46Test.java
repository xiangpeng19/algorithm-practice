package solutions;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import static com.google.common.collect.Collections2.permutations;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

class _46Test {

    private static _46.Solution solution = new _46.Solution();

    @Test
    void shouldPermute() {
        int[] nums = {1, 2, 3, 4};
        var expected = permutations(Lists.newArrayList(1, 2, 3, 4));
        var actual = solution.permute(nums);
        assertThat("List equality without order", actual, containsInAnyOrder(expected.toArray()));
    }
}