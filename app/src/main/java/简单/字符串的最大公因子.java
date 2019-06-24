package 简单;

import android.text.TextUtils;
import android.util.Log;

/***
 * 题号 : 1071
 *
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 *
 * 返回字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 *
 *
 *
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 *
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 *
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 *
 */
public class 字符串的最大公因子 {

    public static void main(String[] args) {
        String str1 = "12121212";
        String str2 = "12";


        String s = gcdOfStrings(str1, str2);
        System.out.println(s);
    }

    /**
     *
     * @param str1 ABCABC
     * @param str2 ABC
     * @return
     */
    public static String gcdOfStrings(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return "";
        }
        String longStr = str1.length() > str2.length() ? str1 : str2;
        String shortStr = str1.length() > str2.length() ? str2 : str1;

        while (longStr.length() != shortStr.length()) {
            if (longStr.indexOf(shortStr) == 0) {
                String tempStr = longStr.substring(shortStr.length(), longStr.length());
                longStr = tempStr.length() > shortStr.length() ? tempStr : shortStr;
                shortStr = tempStr.length() > shortStr.length() ? shortStr : tempStr;
            } else {
                return "";
            }
        }
        if (longStr.equals(shortStr)) {
            return longStr;
        }
        return "";
    }

}
