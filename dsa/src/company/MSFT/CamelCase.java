package company.MSFT;

/**
 * Created by oakinrele on Jul, 2021
 */
public class CamelCase {
    public static void main(String[] args){
        String testCase1 = "my#name&is-Somi";
        String testCase2 = "My#name&&&&is-Somi";
        String testCase3 = "m&&&&y#name&&&&is-Somi";
        String testCase4 = "m&&&&y#name&&&&is-Somi&&&";

        System.out.println(toCamelCase(testCase1));
        System.out.println(toCamelCase(testCase2));
        System.out.println(toCamelCase(testCase3));
        System.out.println(toCamelCase(testCase4));
        System.out.println(toCamelCase(null));
    }

    private static String toCamelCase(String input) {
        if(input == null || input.isEmpty()){ return "Input is null or empty."; }
        StringBuilder sb = new StringBuilder();
        boolean isSpecialCharacter = false;
        for(int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i)) && !isSpecialCharacter) {
                String currentCharacter = input.charAt(i) + "";
                sb.append(currentCharacter.toLowerCase());
            }
            else if(isSpecialCharacter && Character.isLetter(input.charAt(i))){
                String currentCharacter = input.charAt(i) + "";
                sb.append(currentCharacter.toUpperCase());
                isSpecialCharacter = false;
            }
            else{
                isSpecialCharacter = true;
            }
        }
        return sb.toString();
    }
}
