package playground;

import java.util.Arrays;

/**
 * Created by oakinrele on Aug, 2020
 */
public class MergeTwoArray {


    public static void main(String[] args) {

        String[] places = {"Lagos", "Abuja" , "Ibadan"};
        String[] places2 = {"Akure", "PortHarcourt" , "Wuse", "Plateau"};


        int mergedListLength = (places.length + places2.length);
        String [] mergedList = new String[mergedListLength];

        int initialPosition = 0;
        int currentPosition = 0;

        for(int i = 0; i < mergedListLength; i++)
        {
            mergedList[i] = places[i];
            currentPosition++;
            if(currentPosition == places.length)
            {
                break;
            }

        }


        for(int j = currentPosition; j < mergedListLength; j++)
        {
            mergedList[j] = places2[initialPosition];
            initialPosition++;
        }

        System.out.println(Arrays.toString(mergedList));


        // Merging Integer Arrays
        int firstArray[] = { 11,22,33,44,55,98,76,54,60};
        int secondArray[] = {66,77,88,99,22,67,21,90,80,70};
        int mergedListInt = (firstArray.length + secondArray.length);
        int [] mergedIntList = new int[mergedListInt];

        int init = 0;
        int curr = 0;

        for(int i = 0; i < mergedListInt; i++)
        {
            mergedIntList[i] = firstArray[i];
            curr++;
            if(curr == firstArray.length)
            {
                break;
            }
        }


        for(int j = curr; j < mergedListInt; j++)
        {
            mergedIntList[j] = secondArray[init];
            init++;
        }


        System.out.println(Arrays.toString(mergedIntList));

    }

}
