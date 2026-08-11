---
id: "20"
title: "20. Valid Parentheses"
category: "by-id"
difficulty: "Easy"
link: "https://leetcode.com/problems/valid-parentheses/description/"
---

Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid. An input string is valid if: Open brackets must be closed by the same type of brackets. Open brackets must be closed in the correct order. Every close bracket has a corresponding open bracket of the same type.

```java
public static boolean isValid(String s) {
    if(s.length()<2) return false;
    char[] chars= s.toCharArray();
    Map<Character, Character> pairs = new HashMap<>();
    pairs.put('(', ')');
    pairs.put('[', ']');
    pairs.put('{', '}');
    Stack<Character> openings = new Stack<>();
    for (char aChar : chars) {
        if (pairs.containsKey(aChar)) {
            openings.push(aChar);
        } else if (openings.isEmpty()) {
            return false;
        } else if (aChar == pairs.get(openings.peek())) {
            openings.pop();
        } else {
            return false;
        }
    }
    return openings.isEmpty();
}
```
---
- name: s
  label: Input string
  type: String
