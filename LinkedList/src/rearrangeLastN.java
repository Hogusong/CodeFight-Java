/*
Note: Try to solve this task in O(list size) time using O(1) additional space,
since this is what you'll be asked during an interview.

Given a singly linked list of integers l and a non-negative integer n,
move the last n list nodes to the beginning of the linked list.

Example

For l = [1, 2, 3, 4, 5] and n = 3, the output should be
rearrangeLastN(l, n) = [3, 4, 5, 1, 2];
For l = [1, 2, 3, 4, 5, 6, 7] and n = 1, the output should be
rearrangeLastN(l, n) = [7, 1, 2, 3, 4, 5, 6].
Input/Output

[execution time limit] 4 seconds (py3)

[input] linkedlist.integer l

A singly linked list of integers.

Guaranteed constraints:
0 ≤ list size ≤ 105,
-1000 ≤ element value ≤ 1000.

[input] integer n

A non-negative integer.

Guaranteed constraints:
0 ≤ n ≤ list size.

[output] linkedlist.integer

Return l with the n last elements moved to the beginning.
*/


import java.util.ArrayList;

public class rearrangeLastN {

    // Definition for singly-linked list:
    class ListNode<T> {
        ListNode(T x) {
            value = x;
        }
        T value;
        ListNode<T> next;
    }

    ListNode<Integer> rearrangeLastN(ListNode<Integer> l, int n) {
        if(n==0)  return l;
        ListNode<Integer> head = l;
        ArrayList<ListNode<Integer>> list = new ArrayList<>();
        while (l != null) {
            list.add(l);
            l = l.next;
        }
        if(list.size() > n) {
            list.get(list.size()-1).next = head;
            list.get(list.size()-n-1).next = null;
            head = list.get(list.size()-n);
        }
        return head;
    }

}
