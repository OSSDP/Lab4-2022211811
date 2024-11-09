import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution1Test {

    @Test
    public void testFractionToDecimal() {
        Solution1 solution = new Solution1();

        // 测试用例 1: 正常情况
        assertEquals("5", solution.fractionToDecimal(5, 1));

        // 测试用例 2: 分母为1的情况
        assertEquals("2.25", solution.fractionToDecimal(9, 4));

        // 测试用例 3: 分子为0的情况
        assertEquals("0", solution.fractionToDecimal(0, 1));

        // 测试用例 4: 分子和分母都为0的情况（虽然题目保证不会发生，但可以测试代码的鲁棒性）
        assertEquals("0", solution.fractionToDecimal(0, 0)); // 这可能会抛出异常，因为除以0是未定义的

        // 测试用例 5: 负数情况
        assertEquals("-3.5", solution.fractionToDecimal(-7, 2));

        // 测试用例 6: 循环小数情况
        assertEquals("2.(6)", solution.fractionToDecimal(8, 3));

        // 测试用例 7: 循环小数，且循环节较长的情况
        assertEquals("0.(3)", solution.fractionToDecimal(1, 3));

        // 测试用例 8: 循环小数，且循环节为0的情况
        assertEquals("0.(142857)", solution.fractionToDecimal(1, 7));
    }
}