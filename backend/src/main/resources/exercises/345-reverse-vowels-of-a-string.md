---
id: "345"
title: "345. Reverse Vowels of a String"
category: "leetcode75"
difficulty: "Easy"
link: "https://leetcode.com/problems/reverse-vowels-of-a-string/description/"
---

Given a string `s`, reverse only all the vowels in the string and return it. The vowels are `'a'`, `'e'`, `'i'`, `'o'`, and `'u'`, and they can appear in both lower and upper cases.

```java
public static String reverseVowels(String s) {
    char[] charArray = s.toCharArray();
    List<Character> vowels = new ArrayList<>();
    List<Integer> indexes = new ArrayList<>();
    Map<Integer,Character> consonantMap = new HashMap<>();
    for (int i = 0; i < charArray.length; i++) {
        if(charArray[i]=='a'||charArray[i]=='A'||charArray[i]=='e'||charArray[i]=='E'||charArray[i]=='i'||charArray[i]=='I'||charArray[i]=='o'||charArray[i]=='O'||charArray[i]=='u'||charArray[i]=='U') {
            vowels.add(charArray[i]);
            indexes.add(i);
        }else{
            consonantMap.put(i,charArray[i]);
        }
    }
    Collections.reverse(indexes);
    Map<Integer, Character> vowelsMap = new HashMap<>();
    for(int i=0;i<vowels.size();i++){
        vowelsMap.put(indexes.get(i),vowels.get(i));
    }

    StringBuilder stringBuilder = new StringBuilder();
    for(int i=0;i<s.length();i++){
        if(consonantMap.containsKey(i)){
            stringBuilder.append(consonantMap.get(i));
        }else{
            stringBuilder.append(vowelsMap.get(i));
        }
    }
    return stringBuilder.toString();
}
```
---
- name: s
  label: Input string
  type: String
