/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 *
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 *
 *
 * 示例 2：
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 *
 * 提示：
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 *
 */
public class Q12Exist {

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }

    /**
     *
     * 矩阵搜索问题，可使用 深度优先搜索（DFS）+ 剪枝 解决
     * 如果列举到一半发现已经不符合要求了及时剪枝，并且把之前做出的选择撤销
     * 首先，要在矩阵中找字符串中的第一个字符，找到后进入递归
     * 对于已访问的位置，修改其值为'/'，访问完毕后要将值改回来，这是回溯的核心
     * 查找当前字符的周围字符，如果周围字符没有被访问过且与字符串的下一个字符相等，再次进入递归
     * 当索引index已经等于字符串长度时，说明已经找到了一条路径，返回True
     * 只要找到一条路径就返回true：if dfs返回True： 返回True
     *
     */
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        System.out.println(word[k]);
        System.out.println("i: " + i + " j: " + j);
        printBoard(board);
        // 不满足要求
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        // 找到的长度等于word长度代表搜索完毕
        if(k == word.length - 1) return true;
        // 将满足要求的标记
        board[i][j] = '\0';
        // 递归搜索下一个节点
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        // 搜索完后将节点恢复，当某路径不满足时切换成其他路径重新搜索
        board[i][j] = word[k];
        return res;
    }

    public void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '\0'){
                    System.out.print('_');
                }
                System.out.print(board[i][j]);
            }
            System.out.print('\n');
        }
        System.out.println('\n');
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B'}, {'C', 'D'}};
        String word = "ABCD";
        Q12Exist q12Exist = new Q12Exist();
        System.out.println(q12Exist.exist(board, word));
    }
}
