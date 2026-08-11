---
id: "1"
title: "1. Two Sum"
category: "by-id"
difficulty: "Easy"
link: "https://leetcode.com/problems/two-sum/description/"
---

Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to `target`. You may assume that each input would have exactly one solution, and you may not use the same element twice.

```java
public static int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
        if (map.containsKey(target - nums[i])) {
            return new int[]{map.get(target - nums[i]), i};
        }
        map.put(nums[i], i);
    }
    return null;
}
```
---
- name: nums
  label: Numbers array. Split individual numbers with ","
  type: int[]
- name: target
  label: Target
  type: int
