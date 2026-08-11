---
id: "14"
title: "14. Longest Common Prefix"
category: "by-id"
difficulty: "Easy"
link: "https://leetcode.com/problems/longest-common-prefix/description/"
---

Write a function to find the longest common prefix string amongst an array of strings. If there is no common prefix, return an empty string `""`.

```java
public static String longestCommonPrefix(String[] strs) {
    int shortestLength = strs[0].length();
    for (int i = 1; i < strs.length; i++) {
        if (strs[i].length() < shortestLength) {
            shortestLength = strs[i].length();
        }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < shortestLength; i++) {
        for(int j = 1; j < strs.length; j++) {
            if (strs[0].charAt(i) != strs[j].charAt(i)) {
                return sb.toString();
            }
        }
        sb.append(strs[0].charAt(i));
    }
    return sb.toString();
}
```
---
- name: strs
  label: Strings
  type: String[]
