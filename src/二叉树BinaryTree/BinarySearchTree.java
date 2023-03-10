package 二叉树BinaryTree;

/**
 * 二叉搜索树
 *
 * @author insis
 * @date 2023/03/10
 */
public class BinarySearchTree {

    /* 查找结点 */
    TreeNode search(int num,TreeNode root) {
        TreeNode cur = root;
        // 循环查找，越过叶结点后跳出
        while (cur != null) {
            // 目标结点在 cur 的右子树中
            if (cur.val < num) cur = cur.right;
                // 目标结点在 cur 的左子树中
            else if (cur.val > num) cur = cur.left;
                // 找到目标结点，跳出循环
            else break;
        }
        // 返回目标结点
        return cur;
    }

    /* 插入结点 */
    TreeNode insert(int num,TreeNode root) {
        // 若树为空，直接提前返回
        if (root == null) {return null;}
        TreeNode cur = root, pre = null;
        // 循环查找，越过叶结点后跳出
        while (cur != null) {
            // 找到重复结点，直接返回
            if (cur.val == num) {return null;}
            pre = cur;
            // 插入位置在 cur 的右子树中
            if (cur.val < num) {cur = cur.right;}
                // 插入位置在 cur 的左子树中
            else {cur = cur.left;}
        }
        // 插入结点 val
        TreeNode node = new TreeNode(num);
        if (pre.val < num) {pre.right = node;}
        else {pre.left = node;}
        return node;
    }

    /* 删除结点 */
    TreeNode remove(int num,TreeNode root) {
        // 若树为空，直接提前返回
        if (root == null) {return null;}
        TreeNode cur = root, pre = null;
        // 循环查找，越过叶结点后跳出
        while (cur != null) {
            // 找到待删除结点，跳出循环
            if (cur.val == num) {break;}
            pre = cur;
            // 待删除结点在 cur 的右子树中
            if (cur.val < num) {cur = cur.right;}
                // 待删除结点在 cur 的左子树中
            else {cur = cur.left;}
        }
        // 若无待删除结点，则直接返回
        if (cur == null) {return null;}
        // 子结点数量 = 0 or 1
        if (cur.left == null || cur.right == null) {
            // 当子结点数量 = 0 / 1 时， child = null / 该子结点
            TreeNode child = cur.left != null ? cur.left : cur.right;
            // 删除结点 cur
            if (pre.left == cur) {pre.left = child;}
            else {pre.right = child;}
        }
        // 子结点数量 = 2
        else {
            // 获取中序遍历中 cur 的下一个结点
            TreeNode nex = getInOrderNext(cur.right);
            int tmp = nex.val;
            // 递归删除结点 nex
            remove(nex.val,nex);
            // 将 nex 的值复制给 cur
            cur.val = tmp;
        }
        return cur;
    }

    /* 获取中序遍历中的下一个结点（仅适用于 root 有左子结点的情况） */
    TreeNode getInOrderNext(TreeNode root) {
        if (root == null) {return root;}
        // 循环访问左子结点，直到叶结点时为最小结点，跳出
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }


}
