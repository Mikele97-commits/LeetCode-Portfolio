---
id: "9"
title: "9. Palindrome Number"
category: "by-id"
difficulty: "Easy"
link: "https://leetcode.com/problems/palindrome-number/description/"
---

Given an integer `x`, return `true` if `x` is a palindrome, and `false` otherwise. An integer is a palindrome when it reads the same backward as forward. For example, `121` is a palindrome while `123` is not.

```java
public static boolean isPalindrome(int x) {
    if (x < 0){
        return false;
    }
    String number = Integer.toString(x);
    int pointer1=0;
    int pointer2=number.length()-1;
    while (pointer1<pointer2){
        if(number.charAt(pointer1)!=number.charAt(pointer2)){
            return false;
        }
        pointer1++;
        pointer2--;
    }
    return true;
}
```
---
- name: x
  label: Integer
  type: int
