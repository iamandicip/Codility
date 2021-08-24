package train.reverselinkedlist;

import java.util.*;

public class Solution {

  /*
   * Given the head of a singly linked list, reverse the list, and return the
   * reversed list.
   */

  public ListNode reverseList(ListNode head) {
    ListNode result = head;

    List<Integer> contents = new ArrayList<>();

    while (head != null) {
      contents.add(head.val);
      head = head.next;
    }

    if (!contents.isEmpty()) {
      Collections.reverse(contents);

      result = new ListNode(contents.get(0));

      ListNode n = result;
      for (int i = 1; i < contents.size(); i++) {
        n.next = new ListNode(contents.get(i));
        n = n.next;
      }
    }

    return result;
  }

  public ListNode reverseList2(ListNode head) {
    ListNode prev = null;
    ListNode current = head;
    ListNode next = null;

    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }

    head = prev;

    return head;
  }

  public ListNode reverseListRecursive(ListNode current, ListNode prev, ListNode next) {
    if(current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    
      return reverseListRecursive(current, prev, next);

    } else {
      return prev;
    }
  }

  void printList(ListNode node) {
    while (node != null) {
      System.out.print(node.val + " ");
      node = node.next;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    ListNode head = s.new ListNode(85);
    head.next = s.new ListNode(15);
    head.next.next = s.new ListNode(4);
    head.next.next.next = s.new ListNode(20);

    System.out.println("Given Linked list: ");
    s.printList(head);
    head = s.reverseList2(head);
    System.out.println("");
    System.out.println("Reversed linked list: ");
    s.printList(head);

    head = s.reverseListRecursive(head, null, null);
    System.out.println("");
    System.out.println("Twice reversed linked list recurrent (should be equal to given linked list): ");
    s.printList(head);
  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
