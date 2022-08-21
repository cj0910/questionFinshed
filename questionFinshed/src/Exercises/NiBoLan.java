package Exercises;

import java.util.Stack;

public class NiBoLan {
    public static void main(String[] args) {
        String[] tokens = {"4","13","5","/","+"};
        int res = evalRPN(tokens);
        System.out.println(res);
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int n = tokens.length;
        for(int i=0;i<n;i++){
            String ch = tokens[i];
            int op1,op2;
            switch (ch){
                case "+":
                    op1 = stack.pop();
                    op2 = stack.pop();
                    stack.push(op2 + op1);
                    break;
                case "-":
                    op1 = stack.pop();
                    op2 = stack.pop();
                    stack.push(op2 - op1);
                    break;
                case "*":
                    op1 = stack.pop();
                    op2 = stack.pop();
                    stack.push(op2 * op1);
                    break;
                case "/":
                    op1 = stack.pop();
                    op2 = stack.pop();
                    stack.push(op2 / op1);
                    break;
                default:
                    stack.push(Integer.parseInt(ch));
                    break;
            }
        }
        return stack.pop();
    }
}