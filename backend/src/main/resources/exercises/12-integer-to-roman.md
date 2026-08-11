---
id: "12"
title: "12. Integer to Roman"
category: "by-id"
difficulty: "Medium"
link: "https://leetcode.com/problems/integer-to-roman/description/"
---

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M. Given an integer, convert it to a roman numeral.

```java
public static String intToRoman (int num){
    int thousands=num/1000;
    int hundreds=(num-thousands*1000)/100;
    int tens=(num-thousands*1000-hundreds*100)/10;
    int ones=num%10;
    StringBuilder sb = new StringBuilder();
    sb.append("M".repeat(Math.max(0, thousands)));
    switch(hundreds){
        case 1:
        case 2:
        case 3:
        {
            sb.append("C".repeat(hundreds));
        }
        break;
        case 4:
            sb.append("CD");
            break;
        case 5:
        case 6:
        case 7:
        case 8:
            sb.append("D");
            sb.append("C".repeat(hundreds - 5));
            break;
        case 9:
            sb.append("CM");
    }
    switch(tens){
        case 1:
        case 2:
        case 3:
        {
            sb.append("X".repeat(tens));
        }
        break;
        case 4:
            sb.append("XL");
            break;
        case 5:
        case 6:
        case 7:
        case 8:
            sb.append("L");
            sb.append("X".repeat(tens - 5));
            break;
        case 9:
            sb.append("XC");
    }
    switch(ones){
        case 1:
        case 2:
        case 3:
        {
            sb.append("I".repeat(ones));
        }
        break;
        case 4:
            sb.append("IV");
            break;
        case 5:
        case 6:
        case 7:
        case 8:
            sb.append("V");
            sb.append("I".repeat(ones - 5));
            break;
        case 9:
            sb.append("IX");
    }
    return sb.toString();
}
```
---
- name: num
  label: Number
  type: int
