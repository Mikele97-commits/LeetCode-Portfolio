---
id: "5"
title: "5. Longest Palindromic Substring"
category: "by-id"
difficulty: "Medium"
link: "https://leetcode.com/problems/longest-palindromic-substring/description/"
---

Given a string `s`, return the longest palindromic substring in `s`.

```java
public static String longestPalindrome(String s) {
    if (s.length() == 1) {
        return s;
    }
    if(s.length() == 2) {
        if (s.charAt(0) == s.charAt(1)) {
            return s;
        }else{
            return s.substring(0,1);
        }
    }
    String longest = "";
    String current = "";
    StringBuilder builder = new StringBuilder();
   //Check for odd-length palindrome
    for (int i = 0; i < s.length(); i++) {
        int index1=i, index2=i;
        while(index1>=0 && index2<s.length()){
            if(s.charAt(index1)==s.charAt(index2)){
                index1--;
                index2++;
            } else {
                for(int j=index1+1; j<index2; j++){
                    builder.append(s.charAt(j));
                }
                current=builder.toString();
                if(current.length()>longest.length()){
                    longest=current;
                };
                builder = new StringBuilder();
                break;
            }
            if(index1<0 || index2==s.length()){
                for(int j=index1+1; j<index2; j++){
                    builder.append(s.charAt(j));
                }
                current=builder.toString();
                if(current.length()>longest.length()){
                    longest=current;
                };
                builder = new StringBuilder();
                break;
            }
        }
    }
    //Check for even-length palindrome
    for(int i=1; i<s.length(); i++){
        if(s.charAt(i)==s.charAt(i-1)){
            int index1=i-1, index2=i;
            while(index1>=0 && index2<s.length()){
                if(s.charAt(index1)==s.charAt(index2)){
                    index1--;
                    index2++;
                }else{
                    for(int j=index1+1; j<index2; j++){
                        builder.append(s.charAt(j));
                    }
                    current=builder.toString();
                    if(current.length()>longest.length()){
                        longest=current;
                    };
                    builder = new StringBuilder();
                    break;
                }
                if(index1<0 || index2==s.length()){
                    for(int j=index1+1; j<index2; j++){
                        builder.append(s.charAt(j));
                    }
                    current=builder.toString();
                    if(current.length()>longest.length()){
                        longest=current;
                    };
                    builder = new StringBuilder();
                    break;
                }
            }
        }
    }
    return longest;
}
```
---
- name: s
  label: Input string
  type: String
