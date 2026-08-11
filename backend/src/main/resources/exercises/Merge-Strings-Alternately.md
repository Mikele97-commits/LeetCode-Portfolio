---
id: "1768"
title: "1768. Merge Strings Alternately"
category: "leetcode75"
difficulty: "Easy"
link: "https://leetcode.com/problems/merge-strings-alternately/description/"


---

Given two strings `word1` and `word2`, merge the strings by adding letters in alternating order, starting with `word1`. If a string is longer than the other, append the additional letters onto the end of the merged string. Return the final merged string.

```java
public static String mergeAlternately(String word1, String word2) {
    int minlength = Math.min(word1.length(), word2.length());
    StringBuilder result = new StringBuilder();
    for(int i=0;i<minlength;i++){
        result.append(word1.charAt(i));
        result.append(word2.charAt(i));
    }
    if(word1.length()<word2.length()){
        result.append(word2, minlength, word2.length());
    }
    if(word1.length()>word2.length()){
        result.append(word1, minlength, word1.length());
    }
    return result.toString();
}
```
---
- name: String1
  label: String 1
  type: String
- name: String2
  label: String 2
  type: String
