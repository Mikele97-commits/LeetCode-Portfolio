---
id: "933"
title: "933. Number of Recent Calls"
category: "leetcode75"
difficulty: "Easy"
link: "https://leetcode.com/problems/number-of-recent-calls/description/"
---

You have a `RecentCounter` class which counts the number of recent requests within a certain time frame. Implement the `RecentCounter` class: `RecentCounter()` initializes the counter with zero recent requests. `int ping(int t)` adds a new request at time `t`, where `t` represents some time in milliseconds, and returns the number of requests that have happened in the past 3000 milliseconds (including the new request).

```java
static class RecentCounter {
    Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}
```
---
- name: t
  label: Time (ms)
  type: int
