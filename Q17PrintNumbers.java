/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
 * 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *
 * 说明：
 * 用返回一个整数列表来代替打印
 * n 为正整数
 *
 */
public class Q17PrintNumbers {
    // 不考虑大数越界问题
    public int[] printNumbers1(int n) {
        int end = (int)Math.pow(10, n) - 1;
        int[] res = new int[end];
        for(int i = 0; i < end; i++)
            res[i] = i + 1;
        return res;
    }

    // 考虑大数越界问题
    StringBuilder res;
    int nineNum = 0, n, startZeroNum;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public String printNumbers(int n) {
        this.n = n;
        res = new StringBuilder(); // 数字字符串集
        num = new char[n]; // 定义长度为 n 的字符列表
        startZeroNum = n - 1; //开头 0 的数量
        dfs(0); // 开启全排列递归
        res.deleteCharAt(res.length() - 1); // 删除最后多余的逗号
        return res.toString(); // 转化为字符串并返回
    }
    void dfs(int x) {
        if(x == n) { // 终止条件：已固定完所有位
            String s = String.valueOf(num).substring(startZeroNum); // 删除开头的 0
            if (!s.equals("0")) res.append(s + ","); // 拼接 num 并添加至 res 尾部，使用逗号隔开
            if (n - startZeroNum == nineNum) startZeroNum--; //当每一位数字全部都是9时，开头0的数量减1
            return;
        }
        for(char i : loop) { // 遍历 ‘0‘ - ’9‘
            if (i == '9') nineNum++;
            num[x] = i; // 固定第 x 位为 i
            dfs(x + 1); // x位固定完成后，再固定第 x + 1 位
        }
        nineNum --; //如果不是全部为9，即19，29等，下一个数字 9 的数量需要减1
    }

    public static void main(String[] args) {
        Q17PrintNumbers q17PrintNumbers = new Q17PrintNumbers();
        q17PrintNumbers.printNumbers(2);
        System.out.println(q17PrintNumbers.res);
    }

}
