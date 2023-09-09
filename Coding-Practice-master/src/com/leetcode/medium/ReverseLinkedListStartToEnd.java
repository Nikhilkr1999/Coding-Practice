public class ReverseLinkedListStartToEnd {
  public ListNode reverseBetween(ListNode head, int left, int right) {
       
        if(head == null) {
            return null;
        }
        int i = 1;
        ListNode firstHalf = new ListNode();
        ListNode temp = firstHalf;
        while( i < left && head != null) {
            temp.next = head;
            temp = temp.next;
            head = head.next;
            i++;
        }
        
        temp.next = reverse(head, right-left + 1);;
        
        return firstHalf.next;
        
        
    }
    
    public ListNode reverse(ListNode head, int count) {
        ListNode temp = head;
        ListNode t = temp;
        while(head != null && count > 0) {
            ListNode next = head.next;
            head.next = temp;
            temp = head;
            head = next;
            count--;
        }
        while(head != null) {
            t.next = head;
            t = t.next;
            head = head.next;
        }
        t.next = null;
        return temp;
    }
}
