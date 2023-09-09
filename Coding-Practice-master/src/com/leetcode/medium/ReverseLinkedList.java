public class ReverseLinkedList {
  public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        
        ListNode temp = head;
        ListNode t = temp;
        //temp.next = null;
        head = head.next;
        while(head != null) {
            ListNode next = head.next;
            head.next = temp;
            temp = head;
            head = next;
            
        }
        t.next = null;
        return temp;
    }

}
