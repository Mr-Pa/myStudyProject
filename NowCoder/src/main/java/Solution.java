import java.util.ArrayList;
import java.util.List;

/**
 * @author 14280
 * @date 2022/6/5
 */
public class Solution {


    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode ReverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode newHead = head;
        head = head.next;
        newHead.next = null;
        do {
            ListNode last = newHead;
            newHead = head;
            head = head.next;
            newHead.next = last;
        } while (head != null);

        return newHead;
    }


    public static ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here
        if (m == n) return head;


        ListNode prefix = head;
        ListNode start = head.next;
        for (int i = 0; i < m - 1; i++) {
            prefix = start;
            start = start.next;
        }
        ListNode end = start;
        for (int i = m - 1; i < n - 1; i++) {
            end = end.next;
        }
        ListNode suffix = end.next;
        end.next = null;

        if (m == 1) return   ReverseList(start, suffix);

        prefix.next = ReverseList(start, suffix);

        return head;
    }

    public static ListNode ReverseList(ListNode head, ListNode suffix) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode newHead = head;
        head = head.next;
        newHead.next = suffix;
        do {
            ListNode last = newHead;
            newHead = head;
            head = head.next;
            newHead.next = last;
        } while (head != null);

        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = reverseBetween(head, 2, 4);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
