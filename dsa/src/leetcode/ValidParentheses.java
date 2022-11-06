package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParentheses {
        public static boolean isValid(String s) {
                if(s == null || (s.length() % 2 != 0)){
                        return false;
                }
                return isValidParentheses(s);
        }

        private static boolean isValidParentheses(String input){
                Deque<Character> deque = new LinkedList<>();
                for(char ch : input.toCharArray()){
                        if(ch == '{' || ch == '[' || ch == '('){
                                deque.addFirst(ch);
                        }
                        else {
                                if(deque.isEmpty()){
                                        return false;
                                }
                                if((deque.peekFirst() == '{' && ch == '}') ||
                                        (deque.peekFirst() == '[' && ch == ']') ||
                                        (deque.peekFirst() == '(' && ch == ')')){
                                        deque.removeFirst();
                                }
                                else{ return false;}
                        }
                }
                return deque.isEmpty();
        }

        public static void main(String[] args) {
                String sample = "{[]}";
                System.out.println(isValid(sample));
                String sample2 = "{[)]}";
                System.out.println(isValid(sample2));
        }
}
