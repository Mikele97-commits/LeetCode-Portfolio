---
id: "1431"
title: "1431. Kids With the Greatest Number of Candies"
category: "leetcode75"
difficulty: "Easy"
link: "https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/"
---

Given the array `candies` and an integer `extraCandies`, return a boolean array result of length `n` where `result[i]` is `true` if after giving the `i`-th kid all the `extraCandies` they will have the greatest number of candies among all kids, or `false` otherwise.

```java
public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    List<Boolean> ans=new ArrayList<>();
    int highest=Integer.MIN_VALUE;
    int index=Integer.MIN_VALUE;
    for(int i=0;i<candies.length;i++){
        if(candies[i]>highest){
            highest=candies[i];
            index=i;
        }
    }

    for(int i=0;i<candies.length;i++){
        if(i==index){
            ans.add(true);
            continue;
        }
        if(candies[i]+extraCandies>=highest){
            ans.add(true);
        }else {
            ans.add(false);
        }
    }
    return ans;
}
```
---
- name: candies
  label: Candies
  type: int[]
- name: extraCandies
  label: Extra Candies
  type: int
