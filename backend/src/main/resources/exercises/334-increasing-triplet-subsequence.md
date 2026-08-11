---
id: "334"
title: "334. Increasing Triplet Subsequence"
category: "leetcode75"
difficulty: "Medium"
link: "https://leetcode.com/problems/increasing-triplet-subsequence/description/"
---

Given an integer array `nums`, return `true` if there exists a triple of indices `(i, j, k)` such that `i < j < k` and `nums[i] < nums[j] < nums[k]`. If no such indices exist, return `false`.

```java
public static boolean increasingTriplet(int[] nums) {
    int smallest=nums[0];
    int medium=Integer.MAX_VALUE;

    for(int i=1;i<nums.length;i++){
       if(nums[i]>medium){
           return true;
       }else if(nums[i]<medium&&nums[i]>smallest){
           medium=nums[i];
       }else if(nums[i]<smallest){
           smallest=nums[i];
       }
    }
    return false;
}
```
---
- name: nums
  label: Numbers
  type: int[]
