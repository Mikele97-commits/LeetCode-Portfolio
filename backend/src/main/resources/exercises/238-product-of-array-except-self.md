---
id: "238"
title: "238. Product of Array Except Self"
category: "leetcode75"
difficulty: "Medium"
link: "https://leetcode.com/problems/product-of-array-except-self/description/"
---

Given an integer array `nums`, return an array `answer` such that `answer[i]` is equal to the product of all the elements of `nums` except `nums[i]`. The product of any prefix or suffix of `nums` is guaranteed to fit in a 32-bit integer. You must write an algorithm that runs in O(n) time and without using the division operation.

```java
public static int[] productExceptSelf(int[] nums) {
    int[] left = new int[nums.length];
    int[] right = new int[nums.length];
    int temp=1;
    for(int i=0;i<nums.length;i++){
        temp=temp*nums[i];
        left[i]=temp;
    }
    temp=1;
    for(int i=nums.length-1;i>0;i--){
        temp=temp*nums[i];
        right[i]=temp;
    }
    int[] ans=new int[nums.length];
    for(int i=0;i<nums.length;i++){
        if(i==0){
            ans[i]=right[i+1];
        }else if(i==nums.length-1){
            ans[i]=left[i-1];
        }else {
            ans[i] = left[i - 1] * right[i + 1];
        }
    }
    return ans;
}
```
---
- name: nums
  label: Numbers
  type: int[]
