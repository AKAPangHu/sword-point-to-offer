/**
 * 二叉搜索树的第k大节点
 * @author: 胖虎
 * @date: 2019/11/6 11:06
 **/
public class No54 {

    int now = 0;

    public TreeNode kthNode (TreeNode pRoot, int k){
        if (k <= 0){
            return null;
        }
        //now不能作参数传进去
        return kthNodeCore(pRoot, k);
    }

    private TreeNode kthNodeCore(TreeNode pRoot, int k) {
        if (pRoot == null){
            return null;
        }
        TreeNode result = null;
        result = kthNodeCore(pRoot.left, k);
        if (result != null) {
            return result;
        }
        now++;
        if (k == now){
            return pRoot;
        }
        return kthNodeCore(pRoot.right, k);
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
