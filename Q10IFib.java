/**
 * 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * F(0) = 0, F(1)= 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：1
 *
 *
 * 示例 2：
 * 输入：n = 5
 * 输出：5
 *
 * 提示：
 * 0 <= n <= 100
 *
 */
public class Q10IFib {
    // 方法一：递归，缺点：大量重复计算
    public int fib1(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return (fib1(n - 1) + fib1 (n - 2)) % 1000000007;
    }

    // 方法二：记忆化递归，将计算结果保存，避免重复计算
    public int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        int[] list = new int[n + 1];
        list[0] = 0;
        list[1] = 1;
        for (int i = 2; i <= n; i++) {
            list[i] = (list[i-1] + list[i-2]) % 1000000007;
        }
        return list[n];
    }

    // 方法三：动态规划
    // f(n+1)=f(n)+f(n−1) 为转移方程
    public int fib3(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}