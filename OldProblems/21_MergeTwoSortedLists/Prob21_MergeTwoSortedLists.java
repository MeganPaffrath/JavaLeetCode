package com.meganpaffrath;

/**
 * "RT: 100% M: 16%"
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
 * Memory Usage: 39.9 MB, less than 16.16% of Java online submissions for Merge Two Sorted Lists.
 */

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


public class Prob21_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // if both empty ret null
        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode currL1 = l1;
        ListNode currL2 = l2;
        ListNode head;
        ListNode lastAppended;

        // Set head node:

        if (currL1 == null) { // append from l2
            head = currL2;
            currL2 = currL2.next;
        } else if  (currL2 == null) { // append from l1
            head = currL1;
            currL1 = currL1.next;
        } else { // both have contents
            if (currL1.val < currL2.val) { // append from l1
                head = currL1;
                currL1 = currL1.next;
            } else { // append from l2
                head = currL2;
                currL2 = currL2.next;
            }
        }

        lastAppended = head;

        // while both have values
        while (currL1 != null && currL2 != null) {
            if (currL1.val < currL2.val) { // append l1 val
                lastAppended.next = currL1;
                lastAppended = lastAppended.next; // shift lastAppended
                currL1 = currL1.next; // shift currL1
            } else { // append l2 val
                lastAppended.next = currL2;
                lastAppended = lastAppended.next;
                currL2 = currL2.next;
            }
        }

        // only l1 has values
        while (currL1 != null) {
            lastAppended.next = currL1;
            lastAppended = lastAppended.next; // shift lastAppended
            currL1 = currL1.next; // shift currL1
        }

        // only l2 has values
        while (currL2 != null) {
            lastAppended.next = currL2;
            lastAppended = lastAppended.next; // shift lastAppended
            currL2 = currL2.next; // shift currL1
        }

        return head;
    }
}
