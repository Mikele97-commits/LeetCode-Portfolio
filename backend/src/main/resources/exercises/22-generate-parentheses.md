---
id: "22"
title: "22. Generate Parentheses"
category: "by-id"
difficulty: "Medium"
link: "https://leetcode.com/problems/generate-parentheses/description/"
---

Given `n` pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

```java
public static List<String> generateParenthesis(int n) {
    ArrayList<ArrayList<Integer>> combinations = new ArrayList<>();
    ArrayList<Integer> numerical = new ArrayList<>();
    ArrayList<String> result = new ArrayList<>();
    addNumber(numerical,n,combinations);
    for(ArrayList<Integer> combination : combinations){
        StringBuilder stringBuilder = new StringBuilder();
        for(Integer num : combination){
            if(num.equals(0)) stringBuilder.append("(");
            else stringBuilder.append(")");
        }
        result.add(stringBuilder.toString());
    }
    return result;
}
public static void addNumber(ArrayList<Integer> numerical, int num,ArrayList<ArrayList<Integer>> combinations) {
    if (numerical.size() == 2*num) {
        combinations.add(new ArrayList<>(numerical));
        return;
    }
    int zeroes=0;
    int ones=0;
    for (Integer integer : numerical) {
        if (integer == 0) {
            zeroes++;
        }
        if (integer == 1) {
            ones++;
        }
    }
    if (zeroes == num) {
        while(numerical.size()<2*num) {
            numerical.add(1);
        }
        combinations.add(new ArrayList<>(numerical));
        return;
    }
    if(zeroes == ones){
        numerical.add(0);
        addNumber(numerical, num, combinations);
        return;
    }
    if(zeroes > ones){
        ArrayList<Integer> numerical2 = new ArrayList<>(numerical);
        numerical.add(1);
        addNumber(numerical, num, combinations);
        numerical2.add(0);
        addNumber(numerical2, num, combinations);
    }
}
```
---
- name: n
  label: Number of pairs
  type: int
