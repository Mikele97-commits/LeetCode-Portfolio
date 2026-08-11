---
id: "649"
title: "649. Dota2 Senate"
category: "leetcode75"
difficulty: "Medium"
link: "https://leetcode.com/problems/dota2-senate/description/"
---

In the world of Dota2, there are two parties: the Radiant and the Dire. The Dota2 senate consists of senators from these two parties. Now the senate wants to decide on a change in the Dota2 game. The voting takes place in rounds. In each round, each senator can exercise one of two rights: ban one senator of the opposite party, or announce the victory if all remaining senators are from the same party. Given a string `senate` representing each senator's party, return the party that will finally announce the victory.

```java
public static String predictPartyVictory(String senate) {
    Queue<Character> queue = new LinkedList<>();
    int r=0,d=0;
    for(int i=0;i<senate.length();i++){
        if(senate.charAt(i)=='R'){
            r++;
        }else{
            d++;
        }
        queue.offer(senate.charAt(i));
    }

    int rVotes=0;
    int dVotes=0;
    while(r!=0&&d!=0){
        if(queue.peek()=='R'){
            if(dVotes>0){
                queue.remove();
                r--;
                dVotes--;
            }else{
                rVotes++;
                queue.add(queue.poll());
            }
        }else{
            if(rVotes>0){
                queue.remove();
                d--;
                rVotes--;
            }else{
                dVotes++;
                queue.add(queue.poll());
            }
        }
    }
    if(r>0) return "Radiant"; else return "Dire";
}
```
---
- name: senate
  label: Senate string
  type: String
