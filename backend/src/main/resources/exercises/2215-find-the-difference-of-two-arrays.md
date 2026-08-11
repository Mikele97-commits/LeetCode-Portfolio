---
id: "2215"
title: "2215. Find the Difference of Two Arrays"
category: "leetcode75"
difficulty: "Easy"
link: "https://leetcode.com/problems/find-the-difference-of-two-arrays/description/"
---

Given two 0-indexed integer arrays `nums1` and `nums2`, return a list `answer` of size 2 where `answer[0]` is a list of all distinct integers in `nums1` which are not present in `nums2`, and `answer[1]` is a list of all distinct integers in `nums2` which are not present in `nums1`.

```java
public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
    List<List<Integer>> ans=new ArrayList<>();
    HashSet<Integer> set1=new HashSet<>();
    HashSet<Integer> set2=new HashSet<>();
    for (int i : nums1) {
        set1.add(i);
    }
    for (int j : nums2) {
        set2.add(j);
    }
    List<Integer> list1=new ArrayList<>();
    List<Integer> list2=new ArrayList<>();
    for (int i : set1) {
        if(!set2.contains(i)){
            list1.add(i);
        }
    }
    for (int i : set2) {
        if(!set1.contains(i)){
            list2.add(i);
        }
    }
    ans.add(list1);
    ans.add(list2);
    return ans;
}
```
---
- name: nums1
  label: Array 1
  type: int[]
- name: nums2
  label: Array 2
  type: int[]
