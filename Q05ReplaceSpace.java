/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例:
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 */
public class Q05ReplaceSpace {
    /**
     *  Java 中 String 不可变，需要新建字符串
     */
    /**
     * 方法一, 用时较久
     */
    public String replaceSpace1(String s) {
        return s.replaceAll(" ", "%20");
    }

    /**
     * 方法二
     */
    public String replaceSpace2(String s) {
        StringBuilder res = new StringBuilder();
        for(Character c : s.toCharArray())
        {
            if(c == ' ') res.append("%20");
            else res.append(c);
        }
        return res.toString();
    }
}
