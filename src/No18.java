/**
 * 删除链表中重复的节点
 *
 * @author: 胖虎
 * @date: 2019/10/6 16:18
 **/
public class No18 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return pHead;
        }
        ListNode pPreNode = null;
        ListNode pNode = pHead;
        while (pNode != null) {
            boolean needDelete = false;
            ListNode pNextNode = pNode.next;
            if (pNextNode != null && pNode.val == pNextNode.val) {
                needDelete = true;
            }
            //首先查看是否需要删除
            if (!needDelete) {
                pPreNode = pNode;
                pNode = pNextNode;
            }

            else {
                //找到第一个不需要删除的位置，并把pre的next设置过去
                int value = pNode.val;
                while (pNode != null && pNode.val == value) {
                    //断开链表
                    pNode.next = null;

                    pNode = pNextNode;
                    if (pNode != null) {
                        pNextNode = pNode.next;
                    }
                }

                if (pPreNode == null) {
                    pHead = pNode;
                } else {
                    pPreNode.next = pNode;
                }

            }
        }
        return pHead;
    }

}
