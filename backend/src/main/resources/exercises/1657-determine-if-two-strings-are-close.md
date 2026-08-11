---
id: "1657"
title: "1657. Determine if Two Strings Are Close"
category: "leetcode75"
difficulty: "Medium"
link: "https://leetcode.com/problems/determine-if-two-strings-are-close/description/"
---

Two strings are considered close if you can attain one from the other using the following operations any number of times: swap any two existing characters, or transform every occurrence of one existing character into another existing character. Return `true` if `word1` and `word2` are close, and `false` otherwise.

```java
public static boolean closeStrings(String word1, String word2) {
    if(word1.length()==word2.length()){
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char ch : arr1) {
            freq1[ch - 'a']++;
            set1.add(ch);
        }
        for (char ch : arr2) {
            freq2[ch - 'a']++;
            set2.add(ch);
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        if(Arrays.equals(freq1,freq2)){
            return set1.equals(set2);
        }
    }
    return false;
}
```
---
- name: word1
  label: Word 1
  type: String
- name: word2
  label: Word 2
  type: String
