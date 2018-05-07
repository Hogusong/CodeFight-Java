/*
You have a list of dishes. Each dish is associated with a list of ingredients used to prepare it.
You want to group the dishes by ingredients, so that for each ingredient you'll be able to find
all the dishes that contain it (if there are at least 2 such dishes).

Return an array where each element is a list with the first element equal to the name of the ingredient
and all of the other elements equal to the names of dishes that contain this ingredient.
The dishes inside each list should be sorted lexicographically.
The result array should be sorted lexicographically by the names of the ingredients in its elements.

Example

For
  dishes = [["Salad", "Tomato", "Cucumber", "Salad", "Sauce"],
            ["Pizza", "Tomato", "Sausage", "Sauce", "Dough"],
            ["Quesadilla", "Chicken", "Cheese", "Sauce"],
            ["Sandwich", "Salad", "Bread", "Tomato", "Cheese"]]
the output should be
  groupingDishes(dishes) = [["Cheese", "Quesadilla", "Sandwich"],
                            ["Salad", "Salad", "Sandwich"],
                            ["Sauce", "Pizza", "Quesadilla", "Salad"],
                            ["Tomato", "Pizza", "Salad", "Sandwich"]]
For
  dishes = [["Pasta", "Tomato Sauce", "Onions", "Garlic"],
            ["Chicken Curry", "Chicken", "Curry Sauce"],
            ["Fried Rice", "Rice", "Onions", "Nuts"],
            ["Salad", "Spinach", "Nuts"],
            ["Sandwich", "Cheese", "Bread"],
            ["Quesadilla", "Chicken", "Cheese"]]
the output should be
  groupingDishes(dishes) = [["Cheese", "Quesadilla", "Sandwich"],
                            ["Chicken", "Chicken Curry", "Quesadilla"],
                            ["Nuts", "Fried Rice", "Salad"],
                            ["Onions", "Fried Rice", "Pasta"]]
Input/Output

[execution time limit] 4 seconds (py3)

[input] array.array.string dishes

An array of dishes. dishes[i] for each valid i contains information about the ith dish:
the first element of dishes[i] is the name of the dish and the following elements are the ingredients of that dish.
Both the dish name and the ingredient names consist of English letters and spaces.
It is guaranteed that all dish names are different.
It is also guaranteed that ingredient names for one dish are also pairwise different.

Guaranteed constraints:
1 ≤ dishes.length ≤ 500,
2 ≤ dishes[i].length ≤ 10,
1 ≤ dishes[i][j].length ≤ 50.

[output] array.array.string

The array containing the grouped dishes.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class groupingDishes {

    String[][] groupingDishes(String[][] dishes) {
        Map<String, String> map = new TreeMap<>();

        for(int i=0; i<dishes.length; i++){
            String dish = "";
            for(int j=1; j<dishes[i].length; j++){
                dish = map.get(dishes[i][j]);
                if(dish == null){
                    dish = dishes[i][0];
                } else {
                    dish = dish + "," + dishes[i][0];
                }
                map.put(dishes[i][j], dish);
            }
        }

        ArrayList<String> allList = new ArrayList<>();
        ArrayList<String> dishesList = new ArrayList<>();
        for(String key : map.keySet()) {
            String[] temp = map.get(key).split(",");
            if(temp.length > 1){
                for(int j=0; j<temp.length; j++)     dishesList.add(temp[j]);
                Collections.sort(dishesList);
                String data = key;
                for(int j=0; j<temp.length; j++)     data = data + "," + dishesList.get(j);
                allList.add(data);
            }
            dishesList.clear();
        }
//        Collections.sort(allList);

        String[][] ingredients = new String[allList.size()][];
        for(int i=0; i<allList.size(); i++) {
            String[] temp = allList.get(i).split(",");
            ingredients[i] = new String[temp.length];
            for(int j=0; j<temp.length; j++){
                ingredients[i][j] = temp[j];
            }
        }
        return ingredients;
    }
}
