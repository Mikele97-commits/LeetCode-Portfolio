---
id: "2352"
title: "2352. Equal Row and Column Pairs"
category: "leetcode75"
difficulty: "Medium"
link: "https://leetcode.com/problems/equal-row-and-column-pairs/description/"
---

Given a 0-indexed `n x n` integer matrix `grid`, return the number of pairs `(r_i, c_j)` such that row `r_i` and column `c_j` are equal. A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).
To create a matrix for each array split values with ",", and then split arrays with ";". For example "3,5,1;2,7,8;1,3,4". Remember to keep number of arrays and number of their arguments the same
```java
public static int equalPairs(int[][] grid) {
    int counter=0;
    HashMap<List<Integer>,Integer> cols=new HashMap<>();
    for (int[] ints : grid) {
        List<Integer> list=new ArrayList<>();
        for (int anInt : ints) {
            list.add(anInt);
        }
        if(cols.containsKey(list)) {
            cols.put(list, cols.get(list)+1);
        }else {
            cols.put(list, 1);
        }
    }
    for(int i=0;i<grid.length;i++){
        List<Integer> list=new ArrayList<>();
        for(int j=0;j<grid[0].length;j++){
            list.add(grid[j][i]);
        }
        if (cols.containsKey(list)) {
            counter+=cols.get(list);
        }
    }
    return counter;
}
```
---
- name: grid
  label: Grid
  type: int[][]
