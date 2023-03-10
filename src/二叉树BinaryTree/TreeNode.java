package 二叉树BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 树节点
 *
 * @author insis
 * @date 2023/03/10
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        this.val = x;
    }

    /* 层序遍历 */
    List<Integer> levelOrder(TreeNode root) {
        // 初始化队列，加入根结点
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        // 初始化一个列表，用于保存遍历序列
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            // 队列出队
            TreeNode node = queue.poll();
            // 保存结点值
            list.add(node.val);
            if (node.left != null){
                queue.offer(node.left);    // 左子结点入队
            }
            if (node.right != null){
                queue.offer(node.right);   // 右子结点入队
            }
        }
        return list;
    }

    /* 前序遍历 */
    void preOrder(TreeNode root) {
        // 初始化一个列表，用于保存遍历序列
        List<Integer> list = new ArrayList<>();
        if (root == null) {return;}
        // 访问优先级：根结点 -> 左子树 -> 右子树
        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    /* 中序遍历 */
    void inOrder(TreeNode root) {
        // 初始化一个列表，用于保存遍历序列
        List<Integer> list = new ArrayList<>();
        if (root == null) {return;}
        // 访问优先级：左子树 -> 根结点 -> 右子树
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    /* 后序遍历 */
    void postOrder(TreeNode root) {
        // 初始化一个列表，用于保存遍历序列
        List<Integer> list = new ArrayList<>();
        if (root == null) {return;}
        // 访问优先级：左子树 -> 右子树 -> 根结点
        postOrder(root.left);
        postOrder(root.right);
        list.add(root.val);
    }

}
