/*
You're given 2 huge integers represented by linked lists. Each linked list element is a number
from 0 to 9999 that represents a number with exactly 4 digits.
The represented number might have leading zeros.
Your task is to add up these huge integers and return the result in the same format.

Example

For a = [9876, 5432, 1999] and b = [1, 8001], the output should be
addTwoHugeNumbers(a, b) = [9876, 5434, 0].

Explanation: 987654321999 + 18001 = 987654340000.

For a = [123, 4, 5] and b = [100, 100, 100], the output should be
addTwoHugeNumbers(a, b) = [223, 104, 105].

Explanation: 12300040005 + 10001000100 = 22301040105.

Input/Output

[execution time limit] 4 seconds (py3)

[input] linkedlist.integer a

The first number, without its leading zeros.

Guaranteed constraints:
0 ≤ a size ≤ 104,
0 ≤ element value ≤ 9999.

[input] linkedlist.integer b

The second number, without its leading zeros.

Guaranteed constraints:
0 ≤ b size ≤ 104,
0 ≤ element value ≤ 9999.

[output] linkedlist.integer

The result of adding a and b together, returned without leading zeros in the same format.
*/

import java.util.ArrayList;

public class addTwoHugeNumbers {

    // Definition for singly-linked list:
    class ListNode<T> {
        ListNode(T x) {
            value = x;
        }
        T value;
        ListNode<T> next;
    }

    ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
        ArrayList<Integer> listA = getArrayList(a);
        ArrayList<Integer> listB = getArrayList(b);
        ArrayList<Integer> combine = new ArrayList<Integer>();
        if (listA.size() >= listB.size()) {
            combine = makeCombine(listA, listB);
        } else {
            combine = makeCombine(listB, listA);
        }
        return makeListNode(combine);
    }

    ArrayList<Integer> makeCombine(ArrayList<Integer> big, ArrayList<Integer> small) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int sizeBig = big.size();
        int diffSize = sizeBig - small.size();
        int overValue = 0;
        int value = 0;
        for(int i= sizeBig-1; i>=0; i--){
            if(i>=diffSize){
                value = big.get(i) + small.get((i-diffSize)) + overValue;
            } else {
                value = big.get(i) + overValue;
            }
            overValue = 0;
            if(value>9999){
                overValue = 1;
                value = value - 10000;
            }
            list.add(value);
        }
        if(overValue > 0)   list.add(overValue);
        return list;
    }

    ListNode<Integer> makeListNode(ArrayList<Integer> list){
        int size = list.size();
        if(size == 0)   return null;
        if(size == 1)   return new ListNode<Integer>(list.get(0));
        ListNode<Integer> head = new ListNode<Integer>(list.get(size-1));
        ListNode<Integer> current = head;
        for(int i=size-2; i>=0; i--){
            ListNode<Integer> newNode = new ListNode<Integer>(list.get(i));
            current.next = newNode;
            current = newNode;
        }
        return head;
    }

    ArrayList<Integer> getArrayList(ListNode<Integer> x){
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(x != null){
            list.add(x.value);
            x = x.next;
        }
        return list;
    }
}
