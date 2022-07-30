package Exercises;

import java.util.Stack;

//150——逆波兰表达式求值
public class NiBoLan {
    public static void main(String args){
        String[] tokens ={"2","1","+","3","*"};
        Solution_evalRPN se = new Solution_evalRPN();
        int res = se.evalRPN(tokens);
        System.out.println(res);
    }
}

class Solution_evalRPN {
    public int evalRPN(String[] tokens) {
        int len = tokens.length;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<len;i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") ||tokens[i].equals("*") ||tokens[i].equals("/")){
                int op1 = stack.pop();
                int op2 = stack.pop();
                switch (tokens[i]){
                    case "+":
                        stack.push(op2 + op1);
                        break;
                    case "-":
                        stack.push(op2 - op1);
                        break;
                    case "*":
                        stack.push(op2 * op1);
                        break;
                    case "/":
                        stack.push(op2 / op1);
                        break;
                }
            }
            else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peek();
    }
}