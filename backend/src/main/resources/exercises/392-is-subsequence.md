---
id: "392"
title: "392. Is Subsequence"
category: "leetcode75"
difficulty: "Easy"
link: "https://leetcode.com/problems/is-subsequence/description/"
---

Given two strings `s` and `t`, return `true` if `s` is a subsequence of `t`, or `false` otherwise. A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters.

```java
public static boolean isSubsequence(String s, String t) {
    if(s.isEmpty()){
        return true;
    }
    if(t.isEmpty()){
        return false;
    }
    int pointerA=0;
    int pointerB=0;
    while(true){
        if(s.charAt(pointerA)==t.charAt(pointerB)){
            pointerA++;
            pointerB++;
        }else{
            pointerB++;
        }
        if(pointerA==s.length()){
            return true;
        }
        if(pointerB==t.length()){
            return false;
        }
    }
}
```
---
- name: s
  label: Subsequence candidate
  type: String
- name: t
  label: Target string
  type: String
