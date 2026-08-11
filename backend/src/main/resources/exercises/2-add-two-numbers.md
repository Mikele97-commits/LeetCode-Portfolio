---
id: "2"
title: "2. Add Two Numbers"
category: "by-id"
difficulty: "Medium"
link: "https://leetcode.com/problems/add-two-numbers/description/"
---

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list. You may assume the two numbers do not contain any leading zero, except the number 0 itself.

```java
public static class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode sum = new ListNode();
    ListNode start = sum;
    int rest =0;
    while (l1 != null || l2 != null) {
        if (l1 != null && l2 != null) {
            sum.val = l1.val + l2.val + rest;
            rest=0;
            if (sum.val >= 10) {
                rest = 1;
                sum.val = sum.val - 10;
            }
            if (l1.next == null && l2.next == null) {
                if (rest!=0) {
                    sum.next = new ListNode(rest);
                }
                return start;
            }
            l1 = l1.next;
            l2 = l2.next;
            sum.next = new ListNode();
            sum = sum.next;
        }
        else if (l1 == null) {
            sum.val = l2.val + rest;
            rest=0;
            if (sum.val >= 10) {
                rest = 1;
                sum.val = sum.val - 10;
            }
            if (l2.next==null){
                if (rest!=0)
                    sum.next = new ListNode(rest);
                return start;
            }
            sum.next = new ListNode();
            sum = sum.next;
            l2=l2.next;
        }
        else if (l2 == null) {
            sum.val = l1.val + rest;
            rest=0;
            if (sum.val >= 10) {
                rest = 1;
                sum.val = sum.val - 10;
            }
            if (l1.next==null){
                if (rest!=0)
                    sum.next = new ListNode(rest);
                return start;
            }
            sum.next = new ListNode();
            sum = sum.next;
            l1=l1.next;
        }
    }
    return start;
}
```
---
- name: l1
  label: List 1. Split values with ','
  type: ListNode
- name: l2
  label: List 2. Split values with ','
  type: ListNode
