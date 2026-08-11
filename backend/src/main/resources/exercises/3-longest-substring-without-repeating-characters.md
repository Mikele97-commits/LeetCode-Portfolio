---
id: "3"
title: "3. Longest Substring Without Repeating Characters"
category: "by-id"
difficulty: "Medium"
link: "https://leetcode.com/problems/longest-substring-without-repeating-characters/description/"
---

Given a string `s`, find the length of the longest substring without repeating characters.

```java
public static int lengthOfLongestSubstring(String s) {
    int counter = 0;
    int finalcounter = 0;
    int start = 0;
    int end = 0;
    int step = 0;
    HashMap<Character, Integer> map = new HashMap<>();
    while (end < s.length()) {
        step++;
        if (map.containsKey(s.charAt(end))&&map.get(s.charAt(end)) >=start) {
            start=map.get(s.charAt(end))+1;
            map.put(s.charAt(end), end);
            if (counter>finalcounter) {
                finalcounter = counter;
            }
            end++;
            counter = end-start;
        }else {
            map.put(s.charAt(end), end);
            end++;
            counter++;
        }
    }
    if (counter>finalcounter) {
        finalcounter = counter;
    }
    return finalcounter;
}
```
---
- name: s
  label: Input string
  type: String
