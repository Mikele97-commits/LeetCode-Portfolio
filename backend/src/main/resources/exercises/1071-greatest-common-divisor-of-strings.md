---
id: "1071"
title: "1071. Greatest Common Divisor of Strings"
category: "leetcode75"
difficulty: "Easy"
link: "https://leetcode.com/problems/greatest-common-divisor-of-strings/description/"
---

For two strings `str1` and `str2`, return the largest string `x` such that `x` divides both `str1` and `str2` (i.e. `str1` and `str2` are both made of one or more repetitions of `x`).

```java
public static String gcdOfStrings(String str1, String str2) {
    String str3 = str1 + str2;
    String str4 = str2 + str1;
    if(!str4.equals(str3)){
        return "";
    }
    return str3.substring(0,gcd(str1.length(),str2.length()));
}
public static int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
}
```
---
- name: str1
  label: String 1
  type: String
- name: str2
  label: String 2
  type: String
