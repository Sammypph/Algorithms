package linkedinlearning.DataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by oakinrele on Jul, 2020
 */
public class GroceryList {
    static List<String> gorceryListItem;
    public static void main(String [] args)
    {
        //N.B: This fails because implicitly what is being returned by the Arrays.asList method is immutable
//        List<String> listItems = Arrays.asList("Bola", "Ade", "Tola");
//        System.out.println(listItems);
//        listItems.add("Sanmi");
//        System.out.println(listItems);


        //This works because the array of items in being passed into the constructor of the ArrayList class and
        //created a mutable list.
//        List<String> listItems = new ArrayList<>(Arrays.asList("Bola", "Ade", "Tola"));
//        System.out.println(listItems);
//        listItems.add("Sanmi");
//        System.out.println(listItems);

        gorceryListItem = new ArrayList<>();
        gorceryListItem.add("Vegetable");
        gorceryListItem.add("Onions");
        List<String> gorceryListItem2 = new ArrayList<>();
        gorceryListItem2.add("Beans");
        gorceryListItem2.add("Plantain");

        gorceryListItem.addAll(gorceryListItem2);

        removeItem(gorceryListItem.contains("Beans"), "Beans");

        System.out.println(gorceryListItem);
    }


    public static void removeItem(boolean isItemPresent, String item)
    {
     if(isItemPresent)
     {
         gorceryListItem.remove(item);
     }
    }
}
