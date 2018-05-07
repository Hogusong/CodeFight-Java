/*
Note: Write a solution with O(n) time complexity and O(1) additional space complexity,
since this is what you would be asked to do during a real interview.

Given an array a that contains only numbers in the range from 1 to a.length,
find the first duplicate number for which the second occurrence has the minimal index.
In other words, if there are more than 1 duplicated numbers, return the number for which
the second occurrence has a smaller index than the second occurrence of the other number does.
If there are no such elements, return -1.

Example

For a = [2, 3, 3, 1, 5, 2], the output should be
firstDuplicate(a) = 3.

There are 2 duplicates: numbers 2 and 3.
The second occurrence of 3 has a smaller index than than second occurrence of 2 does,
so the answer is 3.
*/

import java.util.Map;
import java.util.HashMap;

public class firstDuplicate {

    int firstDuplicate(int[] a) {
        Map<Integer,Integer> dataMap = new HashMap<>();

        for(int i=0; i<a.length; i++){
            if(dataMap.containsKey(a[i])) {
                if(dataMap.get(a[i])<0)    dataMap.put(a[i],i);
            } else {
                dataMap.put(a[i],-1);
            }
        }
        int dupNumber = -1;
        int dupIndex = -1;
        for(Integer i : dataMap.keySet()){
            if(dataMap.get(i) > 0){
                if(dupNumber == -1 || dupIndex > dataMap.get(i)) {
                    dupNumber = i;
                    dupIndex = dataMap.get(i);
                }
            }
        }
        return dupNumber ;
    }
}

