---
id: "1679"
title: "1679. Max Number of K-Sum Pairs"
category: "leetcode75"
difficulty: "Medium"
link: "https://leetcode.com/problems/max-number-of-k-sum-pairs/description/"
---

You are given an integer array `nums` and an integer `k`. In one operation, you can pick two numbers from the array whose sum equals `k` and remove them from the array. Return the maximum number of operations you can perform on the array.

```java
public static int maxOperations(int[] nums, int k) {
    Arrays.sort(nums);
    int pointer1=0;
    int pointer2=nums.length-1;
    int pairs=0;
    while(pointer1<pointer2){
        if(nums[pointer1]+nums[pointer2]==k){
            pairs++;
            pointer1++;
            pointer2--;
        }
        else if(nums[pointer1]+nums[pointer2]>k){
            pointer2--;
        }else{
            pointer1++;
        }
    }
    return pairs;
}
```
---
- name: nums
  label: Numbers
  type: int[]
- name: k
  label: Target sum
  type: int
