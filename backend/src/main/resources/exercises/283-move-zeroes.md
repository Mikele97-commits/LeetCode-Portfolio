---
id: "283"
title: "283. Move Zeroes"
category: "leetcode75"
difficulty: "Easy"
link: "https://leetcode.com/problems/move-zeroes/description/"
---

Given an integer array `nums`, move all 0's to the end of it while maintaining the relative order of the non-zero elements. Note that you must do this in-place without making a copy of the array.
By default this function returns void, but in the name of transparency here it'll return processed array

```java
public static void moveZeroes(int[] nums) {
    int zeroCounter=0;
    List<Integer> list=new ArrayList<>();
    for (int num : nums) {
        if (num != 0) {
            list.add(num);
        } else {
            zeroCounter++;
        }
    }
    for(int i=0;i<list.size();i++){
        nums[i]=list.get(i);
    }
    for(int i=list.size(); i<list.size()+zeroCounter; i++){
        nums[i]=0;
    }
}
```
---
- name: nums
  label: Numbers
  type: int[]
