---
id: "4"
title: "4. Median of Two Sorted Arrays"
category: "by-id"
difficulty: "Hard"
link: "https://leetcode.com/problems/median-of-two-sorted-arrays/description/"
---

Given two sorted arrays `nums1` and `nums2` of size `m` and `n` respectively, return the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

```java
public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1.length == 0 || nums2.length == 0) {
        if (nums1.length == nums2.length) {
            return 0;
        }
        int[] arr = (nums1.length==0) ? nums2 : nums1;
        int index=arr.length/2;
        if(arr.length % 2 == 0){
            double median= ((double)arr[index]+(double)arr[index-1])/2;
            return median;
        }else{
            return arr[index];
        }
    }

    double median=0;
    int[] shortArray;
    int[] longArray;
    if(nums1.length!=nums2.length){
     shortArray = (nums1.length<=nums2.length?nums1:nums2);
     longArray = (nums1.length>=nums2.length?nums1:nums2);
    }else{
         shortArray=nums1;
         longArray=nums2;
    }
    int maxLeft;
    int minRight;
    int length=nums1.length+nums2.length;
    int index=findIndex(shortArray, longArray);
    int jndex=((length)/2)-index;
    int left1=(index<1) ? Integer.MIN_VALUE : shortArray[index-1];
    int left2=(jndex<1) ? Integer.MIN_VALUE : longArray[jndex - 1];
    int right1 = (index >= shortArray.length) ? Integer.MAX_VALUE : shortArray[index];
    int right2 = (jndex >= longArray.length) ? Integer.MAX_VALUE : longArray[jndex];
    minRight = Math.min(right1, right2);
    maxLeft = Math.max(left1, left2);

    if(length%2==0){
        median=((double)maxLeft+(double)minRight)/2;
    }else{
        int ij=index+jndex;
        if(ij<(length/2)){
        median= maxLeft;}
        else{
            median= minRight;
        }
    }
    return median;
}
public static int findIndex(int[] shortArray, int[] longArray) {
    int l1 = shortArray.length;
    int l2 = longArray.length;
    int lo=0;
    int hi=shortArray.length;
    while (true) {
        int i = (lo + hi) / 2;
        int j = (l1 + l2) / 2 - i;
        int left1 = (i == 0) ? Integer.MIN_VALUE : shortArray[i-1];
        int right1 = (i >= shortArray.length) ? Integer.MAX_VALUE : shortArray[i];
        int left2 = (j == 0) ? Integer.MIN_VALUE : longArray[j-1];
        int right2 = (j >= longArray.length) ? Integer.MAX_VALUE : longArray[j];
            if (left1 <= right2 && right1 >= left2) {
                return i;
            } else if (left1 > right2) {
                hi = i - 1;
            } else if (left2 > right1) {
                lo = i + 1;
            }
        }
}
```
---
- name: nums1
  label: Array 1. Split values with ","
  type: int[]
- name: nums2
  label: Array 2. Split values with ","
  type: int[]
