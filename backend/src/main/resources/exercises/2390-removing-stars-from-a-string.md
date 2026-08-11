---
id: "2390"
title: "2390. Removing Stars From a String"
category: "leetcode75"
difficulty: "Medium"
link: "https://leetcode.com/problems/removing-stars-from-a-string/description/"
---

You are given a string `s`, which contains stars `*`. In one operation, you can choose any star in `s` and remove the closest non-star character to its left, as well as remove the star itself. Return the string after all stars have been removed.

```java
public static String removeStars(String s) {
    char[] arr = s.toCharArray();
    StringBuilder sb = new StringBuilder();
    int i=0;
    while(arr[i]=='*'){
        i++;
    }
    for(int j=i;j<arr.length;j++){
        sb.append(arr[j]);
        if(j<=arr.length-2){
            while(arr[j+1]=='*'){
                sb.deleteCharAt(sb.length()-1);
                j++;
                if(j==arr.length-1){
                    break;
                }
            }
        }
    }
    return  sb.toString();
}
```
---
- name: s
  label: Input string
  type: String
