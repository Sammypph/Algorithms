package playground;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oakinrele on Aug, 2020
 */
public class USSDSerial {
    public static void main(String[] args) {
        //894
        //98137
        //89400000
        //89000000

        //89498137

        //89400000
        //generatedToken

        //Skip by add generated + {value}
        //Skip
        //89500000
        String skipSerialPoint = "400000";
        String skipSerialLimit = "100000";


        //String token = "99998";
        //String token = "399999";
        String token = "000000";
        int maxLength = 6;
        Integer tokenInt = Integer.parseInt(token);
        System.out.println(tokenInt);

        Integer augmentedInt = ++tokenInt;
        //Integer augmentedInt = 598137;

        System.out.println("Before:" +augmentedInt);

        if(augmentedInt >= Integer.parseInt(skipSerialPoint) &&
                augmentedInt < (Integer.parseInt(skipSerialPoint) + (Integer.parseInt(skipSerialLimit))))
        {
            augmentedInt = Integer.parseInt(skipSerialPoint) + Integer.parseInt(skipSerialLimit);
        }

        System.out.println("Here now:" +augmentedInt);

        String generatedToken = String.format("%0" + maxLength + "d", augmentedInt);

        if(generatedToken.length() > maxLength)
        {
            //throw new CosmosServiceException(String.format("Error, exhausted all available USSD serials (required length should be at most %s )", maxLength));
            System.out.println(String.format("Error, exhausted all available USSD serials (required length should be at most %s ) and last generated serial is %s", maxLength , token));
        }



        List<String> names = new ArrayList<>();
        names.add("Sanmi");
        names.add("Bola");

        System.out.println(generatedToken);
        System.out.println(names.toString());
    }
}
