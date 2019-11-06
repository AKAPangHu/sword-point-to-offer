/**
 * 二叉树的深度
 * -------判断一棵树是否为平衡二叉树
 * 平衡二叉树的左右子树深度相差不超过1
 * @author: 胖虎
 * @date: 2019/11/6 11:39
 **/
public class No55_2 {
    /**
     * 剪枝
     * 我认为，虽然剪枝算法未达到c++实现的那样高效
     * 但它的时间性能并不会太差
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root){
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = getDepth(root.left);
        if (left == -1){
            return -1;
        }
        int right = getDepth(root.right);
        if (right == -1){
            return -1;
        }
        int diff = Math.abs(right - left);
        return diff > 1 ? -1 : 1 + Math.max(right, left);
    }
}
