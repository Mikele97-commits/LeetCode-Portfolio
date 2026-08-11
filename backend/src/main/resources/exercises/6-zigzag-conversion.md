---
id: "6"
title: "6. Zigzag Conversion"
category: "by-id"
difficulty: "Medium"
link: "https://leetcode.com/problems/zigzag-conversion/description/"
---

The string `"PAYPALISHIRING"` is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility). And then read line by line: `"PAHNAPLSIIGYIR"`. Write the code that will take a string and make this conversion given a number of rows.

```java
public static String zigzag(String s, int numRows) {
    if (numRows == 1) {
        return s;
    }
    if (s.length() == 1|| s.length()==2) {
        return s;
    }
    if(s.length()<=numRows){
        return s;
    }
    Character[][] matrix = new Character[numRows][s.length()];
    int counter = 0;
    int row = 0;
    int col = 0;
    boolean switchDirection=false;
    while(counter<s.length()){
        if(!switchDirection){
            matrix[row][col] = s.charAt(counter);
            counter++;
            if(row+1==numRows){
                switchDirection=true;
            }else {
                row++;
            }
        }
        if (switchDirection) {
            if(counter==s.length()){
                break;
            }
            row--;
            col++;
            matrix[row][col] = s.charAt(counter);
            counter++;
            if (row==0){
                row++;
                switchDirection=false;
            }
        }
    }
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<numRows; i++){
        for(int j=0; j<matrix[i].length; j++){
            if(matrix[i][j]!=null){
                sb.append(matrix[i][j]);
            }
        }
    }
    return sb.toString();
}
```
---
- name: s
  label: Input string
  type: String
- name: numRows
  label: Number of rows
  type: int
