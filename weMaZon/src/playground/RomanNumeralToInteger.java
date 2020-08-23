package playground;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by oakinrele on Aug, 2020
 */
public class RomanNumeralToInteger {

/*
    Split the Roman Numeral string into Roman Symbols (character).
    Convert each symbol of Roman Numerals into the value it represents.
    Take symbol one by one from starting from index 0:
    1) If current value of symbol is greater than or equal to the value of next symbol, then add this value to the running total.

    2) else subtract this value by adding the value of next symbol to the running total.

 SYMBOL       VALUE
  I            1
  IV           4
  V            5
  IX           9
  X            10
  XL           40
  L            50
  XC           90
  C            100
  CD           400
  D            500
  CM           900
  M            1000
*/

//CMI

    static Map<Character,Integer> romanRepresentation = new HashMap<>();

    public static int convertRomanNumeralToNumber(String romanNumeral)
    {
       initializeValues();
       int integerValue = generateIntegerValue(romanNumeral);

       return integerValue;
    }


    public static int romanNumeralToNumber(String romanNumeral)
    {
        initializeValues();
        int integerValue = romanToDecimal(romanNumeral);
        return integerValue;
    }


    public static int romanToInteger(String roman)
    {
        int number = 0;
        for (int i = 0; i < roman.length(); i++)
        {
            if(i + 1 < roman.length() && romanRepresentation.get(roman.charAt(i)) < romanRepresentation.get(roman.charAt(i+1)))
            {
                number -= romanRepresentation.get(roman.charAt(i));
            }
            else
            {
                number += romanRepresentation.get(roman.charAt(i));
            }
        }
        return number;
    }


    public static int generateIntegerValue(String romanNumeral)
    {
        int currentValue = 0;
        int romanNumeralLength = romanNumeral.length();

        for(int i = 0; i < romanNumeralLength; i++)
        {
            if(i + 1 < romanNumeral.length()) {

                if (romanRepresentation.getOrDefault(romanNumeral.charAt(i),0) >= romanRepresentation.getOrDefault(romanNumeral.charAt(i+1),0)) {
                    currentValue += romanRepresentation.getOrDefault(romanNumeral.charAt(i), 0);

                } else {
                    int value =
                            romanRepresentation.getOrDefault(romanNumeral.charAt(i + 1), 0) - romanRepresentation.getOrDefault(romanNumeral.charAt(i), 0);
                    currentValue += value;
                    i++;
                }
            }

            else
            {
                currentValue += romanRepresentation.getOrDefault(romanNumeral.charAt(i), 0);
                i++;
            }

        }

        return  currentValue;
    }


     int romanToDecimal2(String str)
     {
         // Initialize result
         int res = 0;

         for (int i = 0; i < str.length(); i++) {
             // Getting value of symbol s[i]
             int s1 = value(str.charAt(i));

             // Getting value of symbol s[i+1]
             if (i + 1 < str.length()) {
                 int s2 = value(str.charAt(i + 1));

                 // Comparing both values
                 if (s1 >= s2) {
                     // Value of current symbol
                     // is greater or equalto
                     // the next symbol
                     res = res + s1;
                 }
                 else {
                     // Value of current symbol is
                     // less than the next symbol
                     res = res + s2 - s1;
                     i++;
                 }
             }
             else {
                 res = res + s1;
                 i++;
             }
         }

         return res;
     }


   public static int romanToDecimal(String str)
    {
        // Initialize result
        int res = 0;

        for (int i = 0; i < str.length(); i++) {
            // Getting value of symbol s[i]
            int s1 = romanRepresentation.get(str.charAt(i));

            // Getting value of symbol s[i+1]
            if (i + 1 < str.length()) {
                int s2 = romanRepresentation.get(str.charAt(i + 1));

                // Comparing both values
                if (s1 >= s2) {
                    // Value of current symbol
                    // is greater or equalto
                    // the next symbol
                    res = res + s1;
                }
                else {
                    // Value of current symbol is
                    // less than the next symbol
                    res = res + s2 - s1;
                    i++;
                }
            }
            else {
                res = res + s1;
                i++;
            }
        }

        return res;
    }



     int value(char r)
     {
         if (r == 'I')
             return 1;
         if (r == 'V')
             return 5;
         if (r == 'X')
             return 10;
         if (r == 'L')
             return 50;
         if (r == 'C')
             return 100;
         if (r == 'D')
             return 500;
         if (r == 'M')
             return 1000;
         return -1;
     }


    public static void initializeValues()
    {
        romanRepresentation.put('I',1);
        romanRepresentation.put('V', 5);
        romanRepresentation.put('X', 10);
        romanRepresentation.put('L', 50);
        romanRepresentation.put('C',100);
        romanRepresentation.put('D', 500);
        romanRepresentation.put('M', 1000);
    }

    public static void main(String[] args) {
        int output = convertRomanNumeralToNumber("CMI");
        int output2 = convertRomanNumeralToNumber("MCMIV");

        int output3 = romanNumeralToNumber("CMI");
        int output4 =  romanNumeralToNumber("MCMIV")   ;

        System.out.println(output);
        System.out.println(output2);

        System.out.println(output3);
        System.out.println(output4);
    }
}
