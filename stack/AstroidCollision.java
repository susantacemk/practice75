package stack;
import java.util.Arrays;
import java.util.Stack;

public class AstroidCollision {
    public static void main(String[] args){
        System.out.println(Arrays.toString(asteroidCollision(new int[]{5,10,-5})));
    }
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>stack=new Stack<>();
        for (int a : asteroids) {
            if (a > 0) {
                stack.push(a);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -a) {
                    stack.pop();
                }

                if (stack.isEmpty() || stack.peek() < 0)  {
                    stack.push(a);
                }

                if (stack.peek() == -a) {
                    stack.pop();
                }
            }
        }
        int i=stack.size()-1;
        int[] ans=new int[stack.size()];
        while(!stack.isEmpty()){
            ans[i--]=stack.pop();
        }
        return ans;
    }
}
