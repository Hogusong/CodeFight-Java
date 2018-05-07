/*
Note: Your solution should have O(n) time complexity, where n is the number of element in l,
and O(1) additional space complexity, since this is what you would be asked to accomplish in an interview.

Given a linked list l, reverse its nodes k at a time and return the modified list.
k is a positive integer that is less than or equal to the length of l. If the number of nodes
in the linked list is not a multiple of k, then the nodes that are left out at the end should remain as-is.

You may not alter the values in the nodes - only the nodes themselves can be changed.

Example

For l = [1, 2, 3, 4, 5] and k = 2, the output should be
reverseNodesInKGroups(l, k) = [2, 1, 4, 3, 5];
For l = [1, 2, 3, 4, 5] and k = 1, the output should be
reverseNodesInKGroups(l, k) = [1, 2, 3, 4, 5];
For l = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11] and k = 3, the output should be
reverseNodesInKGroups(l, k) = [3, 2, 1, 6, 5, 4, 9, 8, 7, 10, 11].
Input/Output

[execution time limit] 4 seconds (py3)

[input] linkedlist.integer l

A singly linked list of integers.

Guaranteed constraints:
1 ≤ list size ≤ 104,
-109 ≤ element value ≤ 109.

[input] integer k

The size of the groups of nodes that need to be reversed.

Guaranteed constraints:
1 ≤ k ≤ l size.

[output] linkedlist.integer

The initial list, with reversed groups of k elements.
*/

import java.util.ArrayList;

public class reverseNodesInKGroups {

    // Definition for singly-linked list:
    class ListNode<T> {
        ListNode(T x) {
            value = x;
        }
        T value;
        ListNode<T> next;
    }

    ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> l, int k) {
        if(l==null || k==1)  return l;
        ListNode<Integer> head = l;
        ListNode<Integer> ending = null;
        ArrayList<ListNode<Integer>> list = new ArrayList<>();
        boolean isBeinging = true;
        boolean skipReversing = false;
        while (l != null) {
            for(int i=0; i<k; i++){
                if(l == null){
                    skipReversing = true;
                    break;
                }
                list.add(l);
                l = l.next;
            }

            if(!skipReversing) {     //  more Nodes are remained
                skipReversing = false;
                if (isBeinging) {
                    head = list.get(k-1);
                    isBeinging = false;
                } else {
                    ending.next = list.get(k-1);
                }
                for (int i=k-1; i > 0; i--) {
                    list.get(i).next = list.get(i-1);
                }
                ending = list.get(0);
                ending.next = null;
            } else {
                ending.next = list.get(0);
            }
            list.clear();
        }
        return head;
    }
}
