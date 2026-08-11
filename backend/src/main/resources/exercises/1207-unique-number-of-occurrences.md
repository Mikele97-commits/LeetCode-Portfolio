---
id: "1207"
title: "1207. Unique Number of Occurrences"
category: "leetcode75"
difficulty: "Easy"
link: "https://leetcode.com/problems/unique-number-of-occurrences/description/"
---

Given an array of integers `arr`, return `true` if the number of occurrences of each value in the array is unique, or `false` otherwise.

```java
public static boolean uniqueOccurrences(int[] arr) {
    HashMap<Integer,Integer> map=new HashMap<>();
    for(int i=0;i<arr.length;i++){
        if(map.containsKey(arr[i])){
            map.put(arr[i],map.get(arr[i])+1);
        }else {
            map.put(arr[i],1);
        }
    }
    HashSet<Integer>set=new HashSet<>();
    for(int i : map.keySet()){
        set.add(map.get(i));
    }
    return set.size() == map.size();
}
```
---
- name: arr
  label: Array
  type: int[]
