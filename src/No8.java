/**
 * 二叉树的下一个节点
 *
 * @author: 胖虎
 * @date: 2019/8/29 12:00
 **/
public class No8 {
    class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode == null){
            return null;
        }
        TreeLinkNode nextNode = null;
        //如果有右子树，直接取得子树的最左节点
        if (pNode.right != null){
            nextNode = getMostLeft(pNode.right);
        }
        //如果没有右子树，寻找自己作为哪个节点的左子树
        else {
            TreeLinkNode parent = pNode.next;
            while(parent != null && parent.left != pNode){
                pNode = parent;
                parent = parent.next;
            }
            nextNode = parent;
        }
        return nextNode;
    }

    private TreeLinkNode getMostLeft(TreeLinkNode node) {
        if (node == null){
            return null;
        }
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
}


