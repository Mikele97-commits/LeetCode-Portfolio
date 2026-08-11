---
id: "16"
title: "16. 3Sum Closest"
category: "by-id"
difficulty: "Medium"
link: "https://leetcode.com/problems/3sum-closest/description/"
---

Given an integer array `nums` of length `n` and an integer `target`, find three integers in `nums` such that the sum is closest to `target`. Return the sum of the three integers. You may assume that each input would have exactly one solution.

```java
public static int threeSumClosest(int[] nums, int target) {
    int p1=0, p2=1,p3=nums.length-1;
    int smallest=Integer.MAX_VALUE;
    int answer=0;
    Arrays.sort(nums);
    while(p1<=nums.length-3){
        while(p2<p3){
          if(nums[p1]+nums[p2]+nums[p3]==target){
              return target;
          }
          if(smallest>Math.abs(target-(nums[p1]+nums[p2]+nums[p3]))){
              smallest=Math.abs(target-(nums[p1]+nums[p2]+nums[p3]));
              answer=nums[p1]+nums[p2]+nums[p3];
          }
            if(nums[p1]+nums[p2]+nums[p3]<target){
                p2++;
            }
            if(nums[p1]+nums[p2]+nums[p3]>target){
                p3--;
            }
        }
        p1++;
        p2=p1+1;
        p3=nums.length-1;
    }
    return answer;
}
```
---
- name: nums
  label: Numbers
  type: int[]
- name: target
  label: Target
  type: int
