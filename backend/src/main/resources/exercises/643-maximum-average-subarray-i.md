---
id: "643"
title: "643. Maximum Average Subarray I"
category: "leetcode75"
difficulty: "Easy"
link: "https://leetcode.com/problems/maximum-average-subarray-i/description/"
---

You are given an integer array `nums` consisting of `n` elements, and an integer `k`. Find a contiguous subarray whose length is equal to `k` that has the maximum average value and return this value.

```java
public static double findMaxAverage(int[] nums, int k) {
    int start=0;
    int end=k-1;
    int biggest=Integer.MIN_VALUE;
    int sum=0;
    int first=0;
    while(end<nums.length){
        if(start==0){
            first=nums[start];
            for(int i=start;i<=end;i++){
                sum+=nums[i];
            }
        }else{
            sum-=first;
            sum+=nums[end];
            first=nums[start];
        }
        if(sum>biggest){
            biggest=sum;
        }
        start++;
        end++;
    }
    return (double)biggest/(double)k;
}
```
---
- name: nums
  label: Numbers
  type: int[]
- name: k
  label: Window size
  type: int
