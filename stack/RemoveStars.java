package stack;
// https://leetcode.com/problems/removing-stars-from-a-string/description/?envType=study-plan-v2&envId=leetcode-75
import java.util.Stack;

public class RemoveStars {
    public static void main(String[] args) {
        System.out.println(removeStars("leee**cod*e"));
        System.out.println(removeStars("erase*****"));
    }
    public static String removeStars(String s) {
        StringBuilder str=new StringBuilder();
        Stack<Character>stack=new Stack<>();
        for (char character : s.toCharArray()) {
            if(character!='*'){
                stack.push(character);
            }else{
                // pop it
                stack.pop();
            }
        }
        while(!stack.isEmpty()){
            str.append(stack.peek());
            stack.pop();
        }
        return str.reverse().toString();
    }
}
