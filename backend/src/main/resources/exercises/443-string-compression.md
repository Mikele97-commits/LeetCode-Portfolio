---
id: "443"
title: "443. String Compression"
category: "leetcode75"
difficulty: "Medium"
link: "https://leetcode.com/problems/string-compression/description/"
---

Given an array of characters `chars`, compress it using the following algorithm: Begin with an empty string `s`. For each group of consecutive repeating characters in `chars`, if the group's length is 1, append the character to `s`. Otherwise, append the character followed by the group's length. The compressed string `s` should not be returned separately, but instead be stored in the input character array `chars`. Return the new length of the array.

```java
public static int compress(char[] chars) {
    if(chars.length==1) return chars.length;
    int writingPointer=0;
    int readingPointer=0;
    char current =' ';
    int counter=1;
    while(readingPointer<chars.length){
        if(chars[readingPointer]==current){
            counter++;
        }else if(current!=' '){
            char temp = chars[readingPointer];
            chars[writingPointer]=current;
            writingPointer++;
            if(counter>1){
                String numbers = String.valueOf(counter);
                for(int i=0;i<numbers.length();i++){
                    chars[writingPointer]=numbers.charAt(i);
                    writingPointer++;
                }
            }
            current = temp;
            counter=1;
            chars[writingPointer]=current;
            if(readingPointer==chars.length-1){
                writingPointer++;
            }
        }else{
            current=chars[readingPointer];
            counter=1;
        }
        readingPointer++;
    }

    if(counter>1){
        chars[writingPointer]=current;
        String numbers = String.valueOf(counter);
        writingPointer++;
        for(int i=0;i<numbers.length();i++){
            chars[writingPointer]=numbers.charAt(i);
            writingPointer++;
        }
    }
    return writingPointer;
}
```
---
- name: chars
  label: Characters
  type: char[]
