package firecode;

/**
 * Created by oakinrele on Jul, 2020
 */
public class insertPairStar {

    //Recursive
    public static String insertPairStar(String s) {
        if(s == null || s.length() == 1) { return s; }

        else if(s.substring(0,1).equals(s.substring(1,2)))
        {
            return s.substring(0,1) + "*" + insertPairStar(s.substring(1,s.length()));
        }

            return s.substring(0,1) + insertPairStar(s.substring(1,s.length()));
    }

    //Iterative
    public static String insertPairStarSolution(String s) {
        if(s == null || s.length() == 1)
        {
            return s;
        }
        return insertPairStarHelper(s);
    }


    public static String insertPairStarHelper(String input) {
        int counter = 0;
        StringBuilder sb = new StringBuilder();

            for (int i = 0; i < input.length(); i++) {
                if(counter == input.length() - 1)
                {
                 break;
                }

                if(input.charAt(i) == input.charAt(i+1) && counter < 1)
                {
                    sb.append(input.charAt(i));
                    sb.append('*');
                    sb.append(input.charAt(i+1));
                }

                else if(input.charAt(i) == input.charAt(i+1))
                {
                    sb.append('*');
                    sb.append(input.charAt(i+1));
                }

                else if(counter < 1)
                {
                    sb.append(input.charAt(i));
                    sb.append(input.charAt(i + 1));
                }

                else
                {
                    sb.append(input.charAt(i + 1));
                }

                counter++;

            }

            return sb.toString();
    }


    public static void main(String [] args)
    {
        //insertPairStarSolution("abbba");
        //insertPairStarSolution("cac");
        //insertPairStarSolution("cc");

        System.out.println(insertPairStar("abbba"));
        //ab*b*ba
    }


}
