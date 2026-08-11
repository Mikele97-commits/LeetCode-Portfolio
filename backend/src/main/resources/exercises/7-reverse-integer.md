---
id: "7"
title: "7. Reverse Integer"
category: "by-id"
difficulty: "Medium"
link: "https://leetcode.com/problems/reverse-integer/description/"
---

Given a signed 32-bit integer `x`, return `x` with its digits reversed. If reversing `x` causes the value to go outside the signed 32-bit integer range `[-2^31, 2^31 - 1]`, then return 0. Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

```java
public static int reverse(int x) {
    if(x==Integer.MIN_VALUE){
        return 0;
    }
    if(x>-10&&x<10){
        return x;
    }
    boolean negative = false;
    if (x < 0) {
        negative = true;
        x=-x;
    }
    int magnitude =1;
    long number=10;
    while (number<=x){
        magnitude++;
        number*=10;
    }
    if(number>10){
        number=number/10;}
    int[] ciphers = new int[magnitude];
    int counter = 0;
    for (int i=magnitude;i>=1;i--){
        ciphers[counter]=x/(int)number;
        x=x-(ciphers[counter]*(int)number);
        number=number/10;
        counter++;
    }
    long solution=0;
    for (int i=ciphers.length-1;i>=0;i--){
        solution+=(ciphers[i]*(Math.pow(10,magnitude-1)));
        magnitude--;
    }
    if(solution>Integer.MAX_VALUE){
        return 0;
    }
    if (negative){
        solution=-solution;
    }
    return (int)solution;
}
```
---
- name: x
  label: Integer
  type: int
