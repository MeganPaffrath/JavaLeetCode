package com.meganpaffrath;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Write a class RecentCounter to count recent requests.
 *
 * It has only one method: ping(int t), where t represents some time in milliseconds.
 *
 * Return the number of pings that have been made from 3000 milliseconds ago until now.
 *
 * Any ping with time in [t - 3000, t] will count, including the current ping.
 *
 * It is guaranteed that every call to ping uses a strictly larger value of t than before.
 *
 *
 *
 * Example 1:
 *
 * Input: inputs = ["RecentCounter","ping","ping","ping","ping"],
 *  inputs = [[],[1],[100],[3001],[3002]]
 *
 * Output: [null,1,2,3,3]
 *
 *
 * Note:
 *
 * 1. Each test case will have at most 10000 calls to ping.
 * 2. Each test case will call ping with strictly increasing values of t.
 * 3. Each call to ping will have 1 <= t <= 10^9.
 */

public class Prob933_NumberOfRecentCalls {
    int pingCount;
    Queue<Integer> myTimeQueue = new LinkedList<Integer>();

    public Prob933_NumberOfRecentCalls() {
        pingCount = 0;
    }

    public int ping(int t) { // t = time in ms
        myTimeQueue.add(t);

        while (true) { // make sure array contains values within 3000ms
            if (myTimeQueue.size() > 1 && myTimeQueue.peek() < t - 3000) {
//                System.out.println(myTimeQueue.peek() + " is > " + (t - 3000) + " for " + t);
                myTimeQueue.remove();
            } else {
                break;
            }
        }

        return myTimeQueue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */


/**
 * Runtime: 30 ms, faster than 96.29% of Java online submissions for Number of Recent Calls.
 * Memory Usage: 64.3 MB, less than 87.50% of Java online submissions for Number of Recent Calls.
 *
 * public static void main(String[] args) {
 *         Prob933_NumberOfRecentCalls obj = new Prob933_NumberOfRecentCalls();
 *
 *         int param_1 = obj.ping(1);
 *         System.out.println("Ping: t = 1, ping count: " + param_1);
 *         param_1 = obj.ping(101);
 *         System.out.println("Ping: t = 101, ping count: " + param_1);
 *         param_1 = obj.ping(2000);
 *         System.out.println("Ping: t = 2000, ping count: " + param_1);
 *         param_1 = obj.ping(3000);
 *         System.out.println("Ping: t = 3000, ping count: " + param_1);
 *         param_1 = obj.ping(3001);
 *         System.out.println("Ping: t = 3001, ping count: " + param_1);
 *         param_1 = obj.ping(3002);
 *         System.out.println("Ping: t = 3002, ping count: " + param_1);
 *     }
 */
