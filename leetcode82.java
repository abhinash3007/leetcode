
public class leetcode82 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int data){
            this.val=data;
            this.next=null;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0); // To store unique nodes
        ListNode curr = dummy;

        ListNode prev = null;
        ListNode temp = head;

        while (temp != null) {
            boolean isUnique = true;
            if (prev != null && prev.val == temp.val)
                isUnique = false;
            if (temp.next != null && temp.val == temp.next.val)
                isUnique = false;

            if (isUnique) {
                curr.next = new ListNode(temp.val);
                curr = curr.next;
            }

            prev = temp;
            temp = temp.next;
        }

        return dummy.next;
    }
}
