---
id: "19"
title: "19. Remove Nth Node From End of List"
category: "by-id"
difficulty: "Medium"
link: "https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/"
---

Given the `head` of a linked list, remove the `n`th node from the end of the list and return its head.

```java
public static class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public static ListNode removeNthFromEnd(ListNode head, int n) {
    int counter = 1;
    List<Integer> list = new ArrayList<>();
    list.add(head.val);
    while (head.next != null) {
        head = head.next;
        list.add(head.val);
        counter++;
    }
    list.remove(list.size()-n);
    ListNode newHead=null;
    for (int i = list.size(); i > 0; i--) {
        newHead = new ListNode(list.get(i-1),newHead);
    }
    return newHead;
}
```
---
- name: head
  label: Head of list
  type: ListNode
- name: n
  label: Nth from end
  type: int
