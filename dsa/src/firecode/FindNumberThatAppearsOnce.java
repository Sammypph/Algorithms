package firecode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by oakinrele on Mar, 2021
 */
public class FindNumberThatAppearsOnce {

public static int singleNumber(int[] A) {
    Map<Integer, Integer> valueFreq = new HashMap<>();

    for(int i = 0; i < A.length; i++) {
        if (!valueFreq.containsKey(A[i])) {
            valueFreq.put(A[i], 1);
        }

        else{
            valueFreq.put(A[i], (valueFreq.get(A[i]) + 1));
        }
    }

    for (Map.Entry<Integer, Integer> entry : valueFreq.entrySet()) {
        if(entry.getValue() == 1){
            return entry.getKey();
        }
    }
    return 0;
}


    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1,2,3,4,1,2,4,3,5}));
    }

}
