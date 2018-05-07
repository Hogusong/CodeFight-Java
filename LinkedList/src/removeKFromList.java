/*
Note: Try to solve this task in O(n) time using O(1) additional space, where n is the number of elements
in the list, since this is what you'll be asked to do during an interview.

Given a singly linked list of integers l and an integer k, remove all elements from list l
that have a value equal to k.

Example

For l = [3, 1, 2, 3, 4, 5] and k = 3, the output should be
removeKFromList(l, k) = [1, 2, 4, 5];
For l = [1, 2, 3, 4, 5, 6, 7] and k = 10, the output should be
removeKFromList(l, k) = [1, 2, 3, 4, 5, 6, 7].
Input/Output

[execution time limit] 4 seconds (py3)

[input] linkedlist.integer l

A singly linked list of integers.

Guaranteed constraints:
0 ≤ list size ≤ 105,
-1000 ≤ element value ≤ 1000.

[input] integer k

An integer.

Guaranteed constraints:
-1000 ≤ k ≤ 1000.

[output] linkedlist.integer

Return l with all the values equal to k removed.
*/

public class removeKFromList {
    ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
        if(l == null)     return l;
        if(l.value==k && l.next==null) return null;

        ListNode<Integer> head = l;
        ListNode<Integer> current = l;
        while (current != null) {
            if (head.value == k) {
                l = current.next;
                head = current.next;
                current = current.next; // found--unlink cell
            } else if(current.value == k) {
                current = current.next;
                head.next = current;
            } else {
                head = current;
                current = current.next;
            }
        }
        return l;
    }
}

// Definition for singly-linked list:
 class ListNode<T> {
   ListNode(T x) {
     value = x;
   }
   T value;
   ListNode<T> next;
 }

