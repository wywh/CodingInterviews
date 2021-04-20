/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 *
 * 示例 1：
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 *
 * 示例 2：
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 *
 * 示例 3：
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2^-2 = 1/2^2 = 1/4 = 0.25
 *
 * 提示：
 * -100.0 < x < 100.0
 * -2^31 <= n <= 2^31-1
 * -10^4 <= x^n <= 10^4
 *
 */
public class Q16MyPow {

    //递归
    public double myPow1(double x, int n) {
        if(n == 0){
            return 1;
        }else if(n < 0){
            //Integer.MIN_VALUE的相反数还是他自己,提取一个1/x避免死循环
            return 1 / (x * myPow1(x, - n - 1));
        }else if(n % 2 == 1){
            return x * myPow1(x, n - 1);
        }else{
            return myPow1(x * x, n / 2);
        }
    }

    // 二进制快速幂
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        // 将 n 存入 long 避免越界出错
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(-Integer.MIN_VALUE);
        System.out.println(Math.abs(Integer.MIN_VALUE));
        System.out.println(-Integer.MIN_VALUE - 1);
    }
}
