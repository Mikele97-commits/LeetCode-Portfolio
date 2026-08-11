---
id: "17"
title: "17. Letter Combinations of a Phone Number"
category: "by-id"
difficulty: "Medium"
link: "https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/"
---

Given a string containing digits from `2-9` inclusive, return all possible letter combinations that the number could represent. Return the answer in any order. A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

```java
public static List<String> letterCombinations(String digits) {
    ArrayList<Integer> numbers = new ArrayList<>();
    for(int i = 0; i<digits.length(); i++){
        numbers.add((int)digits.charAt(i)-'0');
    }
    char[] two={'a','b','c'};
    char[] three={'d','e','f'};
    char[] four={'g','h','i'};
    char[] five={'j','k','l'};
    char[] six={'m','n','o'};
    char[] seven={'p','q','r','s'};
    char[] eight={'t','u','v'};
    char[] nine={'w','x','y','z'};
    List<char[]> digitsList = new ArrayList<>();
    for(int i = 0; i<digits.length(); i++){
        switch(numbers.get(i)){
            case 2: digitsList.add(two); break;
            case 3: digitsList.add(three); break;
            case 4: digitsList.add(four); break;
            case 5: digitsList.add(five); break;
            case 6: digitsList.add(six); break;
            case 7: digitsList.add(seven); break;
            case 8: digitsList.add(eight); break;
            case 9: digitsList.add(nine); break;
        }
    }
    switch(digits.length()){
        case 1:return lCOne(digitsList);
        case 2:return lCTwo(digitsList);
        case 3:return lCThree(digitsList);
        case 4:return lCFour(digitsList);
    }
    return null;
}
public static List<String> lCOne(List<char[]> digits) {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i<digits.get(0).length; i++){
        sb.append(digits.get(0)[i]);
        result.add(sb.toString());
        sb.delete(0, sb.length());
    }
    return result;
}
public static List<String> lCTwo(List<char[]> digits) {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i<digits.get(0).length; i++){
        for(int j = 0; j<digits.get(1).length; j++){
            sb.append(digits.get(0)[i]).append(digits.get(1)[j]);
            result.add(sb.toString());
            sb.delete(0, sb.length());
        }
    }
    return result;
}
public static List<String> lCThree(List<char[]> digits) {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i<digits.get(0).length; i++){
        for(int j = 0; j<digits.get(1).length; j++){
            for(int k = 0; k<digits.get(2).length; k++) {
                sb.append(digits.get(0)[i]).append(digits.get(1)[j]).append(digits.get(2)[k]);
                result.add(sb.toString());
                sb.delete(0, sb.length());
            }
        }
    }
    return result;
}
public static List<String> lCFour(List<char[]> digits) {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i<digits.get(0).length; i++){
        for(int j = 0; j<digits.get(1).length; j++){
            for(int k = 0; k<digits.get(2).length; k++) {
                for(int l = 0; l<digits.get(3).length; l++) {
                    sb.append(digits.get(0)[i]).append(digits.get(1)[j]).append(digits.get(2)[k]).append(digits.get(3)[l]);
                    result.add(sb.toString());
                    sb.delete(0, sb.length());
                }
            }
        }
    }
    return result;
}
```
---
- name: digits
  label: Digits
  type: String
