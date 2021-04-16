import java.util.LinkedList;
import java.util.Queue;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 示例 1：
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 *
 * 示例 2：
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 *
 * 提示：
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 *
 */
public class Q13MovingCount {
    /**
     *
     * 方法一：广度优先
     * 随着限制条件 k 的增大，(0, 0) 所在的蓝色方格区域内新加入的非障碍方格都可以由上方或左方的格子移动一步得到。
     * 而其他不连通的蓝色方格区域会随着 k 的增大而连通，
     * 且连通的时候也是由上方或左方的格子移动一步得到，因此我们可以将我们的搜索方向缩减为向右或向下。
     *
     */
    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        // 向右和向下的方向数组
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        boolean[][] vis = new boolean[m][n];
        queue.offer(new int[]{0, 0});
        // 保存已检查的结果
        vis[0][0] = true;
        int answer = 1;
        while (!queue.isEmpty()) {
            // 从队列中取出最旧的节点检查
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            // 分别检查(x+0,y+1)和(x+1,y+0)，即向右和向下搜索
            for (int i = 0; i < 2; ++i) {
                int tx = x + dx[i];
                int ty = y + dy[i];
                //  不满足条件则结束本循环
                if (tx < 0 || tx >= m || ty < 0 || ty >= n || vis[tx][ty] || get(tx) + get(ty) > k) {
                    continue;
                }
                // 满足条件则将此点加入待检查的父节点队列，并标记为true
                queue.offer(new int[]{tx, ty});
                vis[tx][ty] = true;
                answer++;
            }
        }
        return answer;
    }


    // 计算 k
    private int get(int x){
        int res = 0;
        while (x != 0){
            res += x % 10;
            x /= 10;
        }
        return res;
    }



    /**
     *
     *  方法二：深度优先
     *
     */

    public int movingCount1(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    private int dfs(int i, int j, int m, int n, int k, boolean visited[][]) {
        if (i < 0 || i >= m || j < 0 || j >= n || (i/10 + i%10 + j/10 + j%10) > k || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return dfs(i + 1, j, m, n, k, visited) + dfs(i - 1, j, m, n, k, visited) +
                dfs(i, j + 1, m, n, k, visited) + dfs(i, j - 1, m, n, k, visited) + 1;
    }



    public static void main(String[] args) {
        Q13MovingCount q13MovingCount = new Q13MovingCount();
        System.out.println(q13MovingCount.movingCount1(7,9,5));
    }
}
