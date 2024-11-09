public class Solution1Tests {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        // 执行测试用例
        runTests(solution);
    }

    private static void runTests(Solution1 solution) {       
        // 测试用例 - 正常小数
        test(solution.fractionToDecimal(1, 2), "0.5", "1/2 should return 0.5");
        test(solution.fractionToDecimal(2, 1), "2", "2/1 should return 2");

        // 测试用例 - 循环小数
        test(solution.fractionToDecimal(4, 333), "0.(012)", "4/333 should return 0.(012)");

        // 测试用例 - 负数结果
        test(solution.fractionToDecimal(-1, 2), "-0.5", "-1/2 should return -0.5");
        test(solution.fractionToDecimal(1, -3), "-0.(3)", "1/-3 should return -0.(3)");
        test(solution.fractionToDecimal(-5, 1), "-5", "-5/1 should return -5");

        // 测试用例 - 分子为0
        test(solution.fractionToDecimal(0, 1), "0", "0/1 should return 0");

        // 测试用例 - 边界情况，最小负数
        test(solution.fractionToDecimal(Integer.MIN_VALUE, -1), "2147483648", 
             "Integer.MIN_VALUE/-1 should return 2147483648");

        // 测试用例 - 大数
        test(solution.fractionToDecimal(123456789, 100000000), "1.23456789", 
             "123456789/100000000 should return 1.23456789");

        // 测试用例 - 另一个循环小数
        test(solution.fractionToDecimal(10, 3), "3.(3)", "10/3 should return 3.(3)");
    }

    private static void test(String actual, String expected, String message) {
        if (actual.equals(expected)) {
            System.out.println("Passed: " + message);
        } else {
            System.out.println("Failed: " + message + ". Expected: " + expected + ", but got: " + actual);
        }
    }
}
