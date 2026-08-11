---
id: "735"
title: "735. Asteroid Collision"
category: "leetcode75"
difficulty: "Medium"
link: "https://leetcode.com/problems/asteroid-collision/description/"
---

We are given an array `asteroids` of integers representing asteroids in a row. For each asteroid, the absolute value represents its size, and the sign represents its direction (positive = right, negative = left). Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

```java
public static int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> stack=new Stack<>();
    for(int i=0;i<asteroids.length;i++){
        if(asteroids[i]>0){
            stack.push(asteroids[i]);
        }
        if(asteroids[i]<0){
            int absolute=Math.abs(asteroids[i]);
            if(!stack.isEmpty()){
                if(stack.peek()<0){
                    stack.push(asteroids[i]);
                }else{
                    while(!stack.isEmpty()){
                        if(stack.peek()<0){
                            stack.push(asteroids[i]);
                            break;
                        }
                        if(stack.peek()>absolute){
                            break;
                        }else if(stack.peek()==absolute){
                            stack.pop();
                            break;
                        }else{
                            stack.pop();
                        }
                        if(stack.isEmpty()){
                            stack.push(asteroids[i]);
                            break;
                        }
                    }
                }
            }else stack.push(asteroids[i]);
        }
    }

    int[] res=new int[stack.size()];
    for(int i=stack.size()-1;i>=0;i--){
        res[i]=stack.pop();
    }
    return res;
}
```
---
- name: asteroids
  label: Asteroids
  type: int[]
