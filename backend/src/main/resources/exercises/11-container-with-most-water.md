---
id: "11"
title: "11. Container With Most Water"
category: "leetcode75"
difficulty: "Medium"
link: "https://leetcode.com/problems/container-with-most-water/description/"
---

You are given an integer array `height` of length `n`. There are `n` vertical lines drawn such that the two endpoints of the `i`th line are `(i, 0)` and `(i, height[i])`. Find two lines that together with the x-axis form a container such that the container contains the most water. Return the maximum amount of water a container can store.

```java
public static int maxArea(int[] height) {
    int pointer1=0,pointer2=height.length-1;
    int maxArea=(pointer2-pointer1)*(Math.min(height[pointer1], height[pointer2]));
    while(pointer1<pointer2){
        if(height[pointer1]<height[pointer2]){
            pointer1++;
        }else{
            pointer2--;
        }
        int newArea=(pointer2-pointer1)*(Math.min(height[pointer1], height[pointer2]));
        if(maxArea<newArea){
            maxArea=newArea;
        }
    }
    return maxArea;
}
```
---
- name: height
  label: Heights
  type: int[]
