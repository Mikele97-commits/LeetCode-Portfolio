---
id: "1732"
title: "1732. Find the Highest Altitude"
category: "leetcode75"
difficulty: "Easy"
link: "https://leetcode.com/problems/find-the-highest-altitude/description/"
---

There is a biker going on a road trip. The road trip consists of `n + 1` points at different altitudes. The biker starts his trip on point 0 with altitude equal 0. You are given an integer array `gain` of length `n` where `gain[i]` is the net gain in altitude between points `i` and `i + 1`. Return the highest altitude of a point.

```java
public static int largestAltitude(int[] gain) {
    int height=0;
    int highest=Integer.MIN_VALUE;
    for (int j : gain) {
        height += j;
        if (height > highest) {
            highest = height;
        }
    }
    return Math.max(highest, 0);
}
```
---
- name: gain
  label: Altitude gains
  type: int[]
