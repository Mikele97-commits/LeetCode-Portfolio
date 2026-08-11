---
id: "1456"
title: "1456. Maximum Number of Vowels in a Substring of Given Length"
category: "leetcode75"
difficulty: "Medium"
link: "https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/"
---

Given a string `s` and an integer `k`, return the maximum number of vowel letters in any substring of `s` with length `k`. Vowel letters in English are `'a'`, `'e'`, `'i'`, `'o'`, and `'u'`.

```java
public static int maxVowels(String s, int k) {
    char[] arr = s.toCharArray();
    int start = 0;
    int end = k-1;
    int biggest = 0;
    int sum = 0;
    boolean first;
    first= arr[0] == 'a' || arr[0] == 'e' || arr[0] == 'i' || arr[0] == 'o' || arr[0] == 'u';
    for (int i = 0; i <= end; i++) {
        if(arr[i]=='a'||arr[i]=='e'||arr[i]=='i'||arr[i]=='o'||arr[i]=='u'){
            sum++;
        }
    }
    biggest = sum;
    start++;
    end++;
    while(end<s.length()){
        if(first) sum--;
        if(arr[end]=='a'||arr[end]=='e'||arr[end]=='i'||arr[end]=='o'||arr[end]=='u'){
            sum++;
        }
        if(sum>biggest){
            biggest=sum;
        }
        if(sum==k){
            return k;
        }
        first= arr[start] == 'a' || arr[start] == 'e' || arr[start] == 'i' || arr[start] == 'o' || arr[start] == 'u';
        start++;
        end++;
    }
    return biggest;
}
```
---
- name: s
  label: Input string
  type: String
- name: k
  label: Window length
  type: int
