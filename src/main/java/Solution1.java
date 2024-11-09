import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 * 如果存在多个答案，只需返回 任意一个 。
 * 对于所有给定的输入，保证 答案字符串的长度小于 104 。
 */
class Solution1 {
    public String fractionToDecimal(int numerator, int denominator) {
        long numeratorLong = (long) numerator;
        long denominatorLong = (long) denominator;
        if (numeratorLong == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        // 处理符号
        if (numeratorLong < 0 ^ denominatorLong < 0) {
            sb.append('-');
        }

        // 整数部分
        numeratorLong = Math.abs((long) numerator);
        denominatorLong = Math.abs((long) denominator);
        sb.append(numeratorLong / denominatorLong);
        if(numeratorLong % denominatorLong != 0)
            sb.append('.');

        // 小数部分
        long remainder = numeratorLong % denominatorLong;
        Map<Long, Integer> remainderIndexMap = new HashMap<>();
        while (remainder != 0) {
            if (remainderIndexMap.containsKey(remainder)) {
                int index = remainderIndexMap.get(remainder);
                sb.insert(index, "(");
                sb.append(")");
                break;
            } else {
                remainderIndexMap.put(remainder, sb.length());
                remainder *= 10;
                sb.append((int)(remainder / denominatorLong));
                remainder %= denominatorLong;
            }
        }

        // 去除末尾的0
        while (sb.length() > 1 && sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }
        // 如果有括号，确保它们是成对的
        if (sb.indexOf("(") != -1 && sb.lastIndexOf(")") != sb.length() - 1) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }
}