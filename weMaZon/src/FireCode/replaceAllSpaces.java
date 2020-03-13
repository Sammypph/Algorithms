package FireCode;

/**
 * Created by oakinrele on Jan, 2020
 */
public class replaceAllSpaces {
    public static String replace(String a, String b)
    {
        StringBuilder  sb = new StringBuilder();

        char [] wordToCharArray = a.toCharArray();

        for(int i = 0; i <= wordToCharArray.length -1; i++)
        {
            sb.append(wordToCharArray[i] == ' '? b : wordToCharArray[i]);
        }


        System.out.println(sb.toString());

        return sb.toString();
    }




    public static void main(String [] args)
    {
        replace("This is a test","/");
    }
}
