/*
Given an array strings, determine whether it follows the sequence given in the patterns array.
In other words, there should be no i and j for which strings[i] = strings[j] and
patterns[i] ≠ patterns[j] or for which strings[i] ≠ strings[j] and patterns[i] = patterns[j].

Example

For strings = ["cat", "dog", "dog"] and patterns = ["a", "b", "b"], the output should be
areFollowingPatterns(strings, patterns) = true;
For strings = ["cat", "dog", "doggy"] and patterns = ["a", "b", "b"], the output should be
areFollowingPatterns(strings, patterns) = false.
Input/Output

[execution time limit] 4 seconds (py3)

[input] array.string strings

An array of strings, each containing only lowercase English letters.

Guaranteed constraints:
1 ≤ strings.length ≤ 105,
1 ≤ strings[i].length ≤ 10.

[input] array.string patterns

An array of pattern strings, each containing only lowercase English letters.

Guaranteed constraints:
patterns.length = strings.length,
1 ≤ patterns[i].length ≤ 10.

[output] boolean

Return true if strings follows patterns and false otherwise.
*/

public class areFollowingPatterns {

    boolean areFollowingPatterns(String[] strings, String[] patterns) {
        if(strings==null)  return true;
        if(strings.length < 2) return strings[0].equals(patterns[0]);

        for(int i=0; i<strings.length-1; i++) {
            for(int j=i+1; j<strings.length; j++) {
                if(strings[i].equals(strings[j]) && !patterns[i].equals(patterns[j]))
                    return false;
                if(!strings[i].equals(strings[j]) && patterns[i].equals(patterns[j]))
                    return false;
            }
        }
        return true;
    }
}
