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
    ListNode result = head;

    ListNode prev = null;
    ListNode current = head;
    ListNode next = null;

    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }

    result = prev;

    return result;
  }

  // public ListNode reverseListRecursive(ListNode current, ListNode prev, ListNode next) {
  //   if(current != null) {
  //     next = current.next;
  //     current.next = prev;
  //     prev = current;
  //     current = next;
    
  //     return reverseListRecursive(current, prev, next);

  //   } else {
  //     return prev;
  //   }
  // }

  public ListNode reverseListRecursive2(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    /* reverse the rest list and put
    the first element at the end */
    ListNode rest = reverseListRecursive2(head.next);
    head.next.next = head;

    /* tricky step -- see the diagram */
    head.next = null;

    /* fix the head pointer */
    return rest;
  }

  public ListNode reverseListStack(ListNode head) {
    Stack<ListNode> s = new Stack<>();
    ListNode result = head;
    ListNode n = head;

    while (n.next != null) {
      s.push(n);
      n = n.next;
    }

    result = n;

    while(!s.isEmpty()) {
      n.next = s.pop();
      n = n.next;
    }

    //avoid infinite loop
    n.next = null;

    return result;
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
    ListNode reversed;

    reversed = s.reverseList(head);
    System.out.println("");
    System.out.println("Reversed linked list 1: ");
    s.printList(reversed);

    // reversed = s.reverseListRecursive(head, null, null);
    // System.out.println("");
    // System.out.println("Reversed linked list recursive 1: ");
    // s.printList(reversed);

    head = s.reverseListRecursive2(head);
    System.out.println("");
    System.out.println("Reversed linked list recursive 2: ");
    s.printList(head);

    reversed = s.reverseListStack(head);
    System.out.println("");
    System.out.println("Reversed linked list stack: ");
    s.printList(reversed);

    // reversed = s.reverseList2(head);
    // System.out.println("");
    // System.out.println("Reversed linked list 2: ");
    // s.printList(reversed);
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

    public String toString() {
      return String.valueOf(val);
    }
  }
}
