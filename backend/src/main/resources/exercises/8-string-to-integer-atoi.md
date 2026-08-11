---
id: "8"
title: "8. String to Integer (atoi)"
category: "by-id"
difficulty: "Medium"
link: "https://leetcode.com/problems/string-to-integer-atoi/description/"
---

Implement the `myAtoi(string s)` function, which converts a string to a 32-bit signed integer (similar to C/C++'s `atoi` function). The algorithm for `myAtoi(string s)` is as follows: Read in and ignore any leading whitespace. Check if the next character (if not already at the end of the string) is `'-'` or `'+'`. Read the integer and stop at non-digit. Convert digits to integer, clamp to 32-bit range if needed.

```java
public static int myAtoi(String s) {
    long solution=0;
    int i=0;
    boolean negative = false;
    boolean numberFound = false;
    boolean signFound = false;
    while (i<=s.length()-1){
        char c = s.charAt(i);
        if(c==' '||c=='+'){
            if(signFound){
                break;
            }
            if(c=='+'){
                signFound=true;
            }
            if(numberFound){
                break;
            }
            i++;
            continue;
        }
        if(c=='-'){
            if(signFound){
                break;
            }
            if(numberFound){
                break;
            }
            negative=true;
            i++;
            signFound=true;
            continue;
        }
        if(c<48||c>57){
            break;
        }
        solution=solution*10+c-48;
        if(solution>Integer.MAX_VALUE){
            break;
        }
        numberFound=true;
        i++;
    }
    if(solution>Integer.MAX_VALUE){
        if(negative){
            return Integer.MIN_VALUE;
        }
        return Integer.MAX_VALUE;
    }
    if(negative){
        solution=-solution;
    }
    return (int) solution;
}
```
---
- name: s
  label: Input string
  type: String
