package HackerRank;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.MultiHashtable;

import java.util.*;

/**
 * Created by oakinrele on Mar, 2020
 */
public class FrequencyQueries {
 //New implementation
 // Complete the freqQuery function below.

//   -  1 : Insert x in your data structure.
//  -  2 : Delete one occurence of y from your data structure, if present.
//-  3 : Check if any integer is present whose frequency is exactly . If yes, print 1 else 0.


 static List<Integer> freqQuery(List<List<Integer>> queries) {
     return performOperation(queries);
 }

//Use Frequecy as Key


 static List<Integer> performOperation(List<List<Integer>> inputs)
 {
          Map<Integer,Integer> listToMap = new HashMap<>();
          List<Integer> output = new ArrayList<>();

          for(List<Integer> value : inputs)
          {
              //int frequency = 0;
              if(value.get(0) == 1)
              {
                  if(!listToMap.containsKey(value.get(1)))
                  {
                      listToMap.put(value.get(1), 1);
                  }

                  else
                      {
                          listToMap.put(value.get(1), listToMap.get(value.get(1)) + 1);
                      }
              }

              else if(value.get(0) == 2)
              {

                 if(listToMap.containsKey(value.get(1)))
                 {
                     if(listToMap.get(value.get(1)) == 0)
                     {
                         listToMap.put(value.get(1), listToMap.get(value.get(1)));
                     }
                     else
                         {
                         listToMap.put(value.get(1), listToMap.get(value.get(1)) - 1);
                     }
                 }
              }

              else if(value.get(0) == 3)
              {

                  if (listToMap.containsValue(value.get(1))) {
                      output.add(1);
                  } else {
                      output.add(0);
                  }
              }
          }

          return output;
 }



 public static void main(String [] args)
 {
     List<List<Integer>> input = new ArrayList<>();
     input.add(Arrays.asList(1,1));
     input.add(Arrays.asList(2,2));
     input.add(Arrays.asList(3,2));
     input.add(Arrays.asList(1,1));
     input.add(Arrays.asList(1,1));
     input.add(Arrays.asList(2,1));
     input.add(Arrays.asList(3,2));

     freqQuery(input);

 }
}
