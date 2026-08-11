---
id: "13"
title: "13. Roman to Integer"
category: "by-id"
difficulty: "Easy"
link: "https://leetcode.com/problems/roman-to-integer/description/"
---

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M. Given a roman numeral, convert it to an integer.

```java
public static int romanToInt(String s) {
    List<Integer> numbers = new ArrayList<Integer>();
    for (int i = 0; i < s.length(); i++) {
        switch (s.charAt(i)) {
            case 'I':
                numbers.add(1);
                break;
            case 'V':
                numbers.add(5);
                break;
            case 'X':
                numbers.add(10);
                break;
            case 'L':
                numbers.add(50);
                break;
            case 'C':
                numbers.add(100);
                break;
            case 'D':
                numbers.add(500);
                break;
            case 'M':
                numbers.add(1000);
                break;
        }
    }
    int answer = 0;
    for (int i = 0; i < numbers.size(); i++) {
        if(i<numbers.size()-1){
            if(numbers.get(i)<numbers.get(i+1)){
                answer += numbers.get(i+1)-numbers.get(i);
                i++;
                continue;
            }
            answer+=numbers.get(i);
            continue;
        }
        answer += numbers.get(i);
    }
    return answer;
}
```
---
- name: s
  label: Roman numeral
  type: String
