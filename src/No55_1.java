/**
 * 二叉树的深度
 * -------简单的求二叉树深度
 * 一棵树如果只有一个节点，那么它的深度为1
 * @author: 胖虎
 * @date: 2019/11/6 11:31
 **/
public class No55_1 {

    /**
     * 递归到最深处返回深度值
     * @param pRoot
     * @return
     */
    int treeDepth(TreeNode pRoot){
        if (pRoot == null){
            return 0;
        }
        int leftDepth = treeDepth(pRoot.left);
        int rightDepth = treeDepth(pRoot.right);
        return leftDepth > rightDepth ? (leftDepth + 1) : (rightDepth + 1);

    }
}

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
}
