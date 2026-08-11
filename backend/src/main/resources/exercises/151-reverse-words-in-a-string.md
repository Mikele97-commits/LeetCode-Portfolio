---
id: "151"
title: "151. Reverse Words in a String"
category: "leetcode75"
difficulty: "Medium"
link: "https://leetcode.com/problems/reverse-words-in-a-string/description/"
---

Given an input string `s`, reverse the order of the words. A word is defined as a sequence of non-space characters. The words in `s` will be separated by at least one space. Return a string of the words in reverse order concatenated by a single space.

```java
public static String reverseWords(String s) {
    List<String> words = new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
        if(s.charAt(i)==' '||i==s.length()-1){
            if(s.charAt(i)!=' '){
                stringBuilder.append(s.charAt(i));
            }
            if(!stringBuilder.isEmpty()){
                words.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            }
            continue;
        }
        stringBuilder.append(s.charAt(i));
    }
    Collections.reverse(words);
    return String.join(" ", words);
}
```
---
- name: s
  label: Input string
  type: String
