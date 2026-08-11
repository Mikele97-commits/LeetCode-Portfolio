---
id: "605"
title: "605. Can Place Flowers"
category: "leetcode75"
difficulty: "Easy"
link: "https://leetcode.com/problems/can-place-flowers/description/"
---

You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots. Given an integer array `flowerbed` containing 0's and 1's, and an integer `n`, return `true` if `n` new flowers can be planted without violating the no-adjacent-flowers rule.

```java
public static boolean canPlaceFlowers(int[] flowerbed, int n) {
    if(flowerbed.length==1){
        return flowerbed[0] == 0 || n == 0;
    }
    if(flowerbed[0]==0&&flowerbed[1]==0){
        n--;
        flowerbed[0]=1;
    }
    for(int i=1;i<=flowerbed.length-2;i++){
        if(flowerbed[i-1]==0&&flowerbed[i+1]==0&&flowerbed[i]==0){
            n--;
            flowerbed[i]=1;
        }
    }
    if(flowerbed[flowerbed.length-1]==0&&flowerbed[flowerbed.length-2]==0){
        n--;
        flowerbed[flowerbed.length-1]=1;
    }
    return n <= 0;
}
```
---
- name: flowerbed
  label: Flowerbed
  type: int[]
- name: n
  label: Number of flowers
  type: int
