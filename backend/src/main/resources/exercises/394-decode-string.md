---
id: "394"
title: "394. Decode String"
category: "leetcode75"
difficulty: "Medium"
link: "https://leetcode.com/problems/decode-string/description/"
---

Given an encoded string, return its decoded string. The encoding rule is: `k[encoded_string]`, where the `encoded_string` inside the square brackets is being repeated exactly `k` times. Note that `k` is guaranteed to be a positive integer. You may assume that the input string is always valid.

```java
public static String decodeString(String s) {
    char[] arr = s.toCharArray();
    StringBuilder answer = new StringBuilder();
    StringBuilder number= new StringBuilder();
    int pointer=0;
    while(pointer<s.length()){
        if(arr[pointer]>='a' && arr[pointer]<='z'){
            answer.append(arr[pointer]);
        }
        if(arr[pointer]>='0' && arr[pointer]<='9'){
            number.append(arr[pointer]);
        }
        if(arr[pointer]=='['){
            pointer++;
            Result res= bracket(Integer.parseInt(number.toString()),pointer,arr);
            answer.append(res.word);
            pointer=res.pointer;
            number.delete(0,number.length());
            continue;
        }
        pointer++;
    }
    return answer.toString();
}
public record Result(String word, int pointer){};
public static Result bracket(int number, int pointer, char[] arr){
    StringBuilder words = new StringBuilder();
    StringBuilder numbers = new StringBuilder();
    while(true){
        if(arr[pointer]-'a'>=0 && arr[pointer]-'a'<26){
            words.append(arr[pointer]);
        }
        if(arr[pointer]-'0'>=0 && arr[pointer]-'0'<10){
            numbers.append(arr[pointer]);
        }
        if(arr[pointer]=='['){
            pointer++;
            Result res= bracket(Integer.parseInt(numbers.toString()),pointer,arr);
            numbers.delete(0,numbers.length());
            words.append(res.word);
            pointer=res.pointer;
            continue;
        }
        if(arr[pointer]==']'){
            pointer++;
            break;
        }
        pointer++;
    }
    String sequence=words.toString();
    words.delete(0,words.length());
    for(int i=0;i<number;i++){
        words.append(sequence);
    }
    return new Result(words.toString(),pointer);
}
```
---
- name: s
  label: Encoded string
  type: String
