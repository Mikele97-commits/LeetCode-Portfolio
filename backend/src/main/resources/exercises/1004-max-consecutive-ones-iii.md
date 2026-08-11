---
id: "1004"
title: "1004. Max Consecutive Ones III"
category: "leetcode75"
difficulty: "Medium"
link: "https://leetcode.com/problems/max-consecutive-ones-iii/description/"
---

Given a binary array `nums` and an integer `k`, return the maximum number of consecutive 1's in the array if you can flip at most `k` 0's.

```java
public static int longestOnes(int[] nums, int k) {
    int start = 0;
    int end = 0;
    int length = 0;
    int zeroes=0;

    if(k==0){
        int sum=0;
        while(end<nums.length){
            if(nums[end]==1){
                sum++;
            }
            if(nums[end]==0){
               if(sum>length) length=sum;
               sum=0;
            }
            end++;
        }
        if(sum>length) length=sum;
        return length;
    }

    while(end<nums.length){
        if(nums[end]==0){
            zeroes++;
        }
        if(zeroes>k){
            while(zeroes>k) {
                start++;
                if (nums[start - 1] == 0) {
                    zeroes--;
                }
                if(start>end) start=end;
            }
        }
        if(end-start+1>length)length=end-start+1;
        end++;
    }
    return length;
}
```
---
- name: nums
  label: Binary array
  type: int[]
- name: k
  label: Max flips
  type: int
