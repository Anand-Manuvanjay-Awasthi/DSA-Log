/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution 
{
    public ListNode reverseList(ListNode head) 
    {
        ListNode rev=head;
        List<Integer> list=new ArrayList<>();
        while(rev!=null)
        {
            list.add(rev.val);
            rev=rev.next;
        }
        ListNode start=null;
        ListNode end=null;
        for(int i=list.size()-1;i>=0;i--)
        {
            ListNode node=new ListNode(list.get(i));
            if(start==null)
            {
                start=node;
                end=node;
            }
            else
            {
                end.next=node;
                end=node;
            }

        }
        return start;
    }
}