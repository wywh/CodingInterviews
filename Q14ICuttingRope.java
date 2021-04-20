/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 示例 1：
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 *
 * 示例2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36

 * 提示：
 * 2 <= n <= 58
 *
 */
public class Q14ICuttingRope {

    // 动态规划
    public int cuttingRope(int n) {
        // dp: 从0到n长度的绳子剪掉后的最大乘积
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for(int i = 3; i < n + 1; i++){
            // 从 2 开始剪，剩下(i - j)长度可以剪也可以不剪。
            // 如果不剪的话长度乘积即为j * (i - j)；如果剪的话长度乘积即为j * dp[i - j]
            for(int j = 2; j < i; j++){
                // dp[i] 的转移方程
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    //贪心算法
    // 尽可能将绳子分成长度为 3 的小段时，乘积最大。

    public int cuttingRope1(int n) {
        System.out.println(n);
        if(n < 4){
            return n - 1;
        }
        int res = 1;
        while(n > 4){
            System.out.println(n);
            System.out.println(res);
            res *= 3;
            n -= 3;
        }
        return res * n;
    }

    public static void main(String[] args) {
        Q14ICuttingRope q14ICuttingRope = new Q14ICuttingRope();
        System.out.println(q14ICuttingRope.cuttingRope1(50));
    }
}
