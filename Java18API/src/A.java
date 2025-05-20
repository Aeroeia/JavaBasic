// 定义二叉树的节点类
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // 构造方法，初始化节点值
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Solution {
    private int ans; // 用于记录最大深度

    // 计算二叉树最大深度的方法
    public int calculateDepth(TreeNode root) {
        dfs(root, 0); // 从根节点开始深度优先搜索，初始深度为 0
        return ans;   // 返回计算出的最大深度
    }

    // 深度优先搜索的递归方法
    private void dfs(TreeNode node, int cnt) {
        if (node == null) return; // 如果节点为空，返回
        ++cnt; // 当前节点计数加一
        ans = Math.max(ans, cnt); // 更新最大深度
        dfs(node.left, cnt);  // 递归遍历左子树
        dfs(node.right, cnt); // 递归遍历右子树
    }
}

public class A {
    public static void main(String[] args) {
        // 创建二叉树
        //         1
        //        / \
        //       2   3
        //      / \   \
        //     4   5   6
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        // 创建 Solution 对象，计算二叉树的深度
        Solution solution = new Solution();
        int depth = solution.calculateDepth(root);

        // 打印结果
        System.out.println("二叉树的最大深度是: " + depth);
    }
}
