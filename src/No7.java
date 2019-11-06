import java.util.HashMap;

/**
 * 用前序中序数组重建二叉树
 *
 * @author: 胖虎
 * @date: 2019/8/29 11:28
 **/
public class No7 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null){
            return null;
        }
        //key为值，value为在in中的的索引
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return preIn(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
    }

    private TreeNode preIn(int[] pre, int preI, int preJ, int[] in, int inI, int inJ, HashMap<Integer, Integer> map) {
        if (preI > preJ){
            return null;
        }
        //核心就是先序数组中的第一个点
        int val = pre[preI];
        TreeNode head = new TreeNode(val);
        int index = map.get(val);
        //左子树有多少个结点
        int numInLeftTree = index - inI;
        head.left = preIn(pre, preI + 1, preI + numInLeftTree,in, inI, index - 1, map);
        head.right = preIn(pre, preI + numInLeftTree + 1, preJ, in, index + 1, inJ, map);
        return head;
    }


}
