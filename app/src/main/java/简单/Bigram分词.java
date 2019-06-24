package 简单;

import java.util.LinkedList;
import java.util.List;

/**
 * 题号 : 1078
 *
 * 给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，其中 second 紧随 first 出现，third 紧随 second 出现。
 * 对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。
 *
 * 输入：text = "alice is a good girl she is a good student", first = "a", second = "good"
 * 输出：["girl","student"]
 *
 *
 */
public class Bigram分词 {
    public static void main(String[] args) {
//        String str = "alice is a good girl she is a good student";
        String str = "alice is a";

        String[] ocurrences = findOcurrences(str, "alice", "is");
        for (int i = 0; i < ocurrences.length; i++) {

            System.out.println(ocurrences[i]);

        }

    }

    public static String[] findOcurrences(String text, String first, String second) {
        if (text.length() <= first.length() || text.length() <= second.length()) {
            return new String[]{};
        }

        List<String> list = new LinkedList<>();
        String[] arr = text.trim().split(" ");
      //因为最少为两位开始 所以索引从第二位开始
        for (int i = 2; i < arr.length; i++) {
            if (arr[i-2].equals(first) && arr[i-1].equals(second)) {
                list.add(arr[i]);
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
