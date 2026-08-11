---
id: "21"
title: "21. Merge Two Sorted Lists"
category: "by-id"
difficulty: "Easy"
link: "https://leetcode.com/problems/merge-two-sorted-lists/description/"
---

You are given the heads of two sorted linked lists `list1` and `list2`. Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists. Return the head of the merged linked list.

```java
public static class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode firstNode=new ListNode(0);
    ListNode head = firstNode;
    while(list1!=null&&list2!=null){
        if(list1.val>list2.val){
            head.next=list2;
            head=head.next;
            list2=list2.next;
        } else if (list2.val>list1.val) {
           head.next=list1;
           head=head.next;
           list1=list1.next;
        }
        else {
            head.next=list1;
            head=head.next;
            list1=list1.next;
        }
    }
    if(list1!=null){
        head.next=list1;
    }
    if(list2!=null){
        head.next=list2;
    }
    return firstNode.next;
}
```
---
- name: list1
  label: List 1
  type: ListNode
- name: list2
  label: List 2
  type: ListNode
