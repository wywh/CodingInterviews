import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 限制：
 * 0 <= 节点个数 <= 5000
 *
 */
public class Q07BuildTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
  }

    /**
     * 对于任意一颗树而言，前序遍历的形式总是
     * [ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
     * 即根节点总是前序遍历中的第一个节点。
     *
     * 而中序遍历的形式总是
     * [ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
     *
     */

    /**
     * 方法一：找到中序遍历中的根节点，再对应到前序遍历的结果中
     */

    // 键表示一个元素（节点的值），值表示其在中序遍历中的出现位置。
    private Map<Integer, Integer> indexMap;

    /**
     *
     * @param preorder 前序遍历结果
     * @param inorder 中序遍历结果
     * @param preorder_left  前序遍历第一个节点位置
     * @param preorder_right 前序遍历末尾节点位置
     * @param inorder_left 中序遍历第一个节点位置
     * @param inorder_right 中序遍历末尾节点位置
     * @return
     */
    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }
        // 将前序第一个节点作为根节点
        int preorder_root = preorder_left;
        // 获取在中序遍历中根节点的位置
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 建立根节点
        TreeNode root = new TreeNode(preorder[preorder_root]);

        // 获得左子树中节点数目
        int size_left_subtree = inorder_root - inorder_left;

        // 递归构造左子树，连接到根节点
        // 前序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 前序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    /**
     * 方法二：迭代
     */
    //如果节点没有右儿子，那么它们在前序和中序遍历中出现的顺序相反
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            //如果节点不等于中序遍历的第一个节点，说明它还有左儿子
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                //如果节点等于中序遍历的第一个节点，说明它没有左儿子或左儿子已经遍历完毕
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Q07BuildTree q07BuildTree = new Q07BuildTree();
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode treeNode = q07BuildTree.buildTree2(preorder, inorder);
        System.out.println(treeNode.left);

    }

}
