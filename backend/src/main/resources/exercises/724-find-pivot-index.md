---
id: "724"
title: "724. Find Pivot Index"
category: "leetcode75"
difficulty: "Easy"
link: "https://leetcode.com/problems/find-pivot-index/description/"
---

Given an array of integers `nums`, calculate the pivot index of this array. The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the right. If the index is on the left edge, then the left sum is 0 (and the same for the right edge). Return the leftmost pivot index. If no such index exists, return -1.

```java
public static int pivotIndex(int[] nums) {
    int sum=0;
    int[] prefixSum=new int[nums.length];
    for(int i=0;i<prefixSum.length;i++){
        sum+=nums[i];
        prefixSum[i]=sum;
    }
    if(prefixSum[prefixSum.length-1]-prefixSum[0]==0){
        return 0;
    }
    for(int i=1;i<prefixSum.length;i++){
        if(prefixSum[i-1]==(prefixSum[prefixSum.length-1]-prefixSum[i])){
            return i;
        }
    }
    return -1;
}
```
---
- name: nums
  label: Numbers
  type: int[]
