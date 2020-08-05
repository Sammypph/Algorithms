package playground;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by oakinrele on Jul, 2020
 */
public class SandBox {
    public static void main(String [] args)
    {
        Map<Integer,Integer> integerMap = new HashMap<>();
        // What do you mean by a graph without tree ?.
        // BFS - Shortest distance something i.e shortest time.
        // DFS - Cycle in a graph, Deepest child.


        String one = "0";
        String two = "00";


        if(one.length() < 2)
        {
            System.out.print("NEW VALUE: ");
            one = "0" + one;
            System.out.print(one);
            System.out.println();
            System.out.println("END");
        }

        System.out.println(one == two);
        System.out.println(one.equals(two));

        if(one == "0" || one.equals("0"));
        {
            one = one.concat("0");
        }

        System.out.println(one);
    }
}
