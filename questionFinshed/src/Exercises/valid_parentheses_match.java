package Exercises;

import java.util.Scanner;
import java.util.Stack;
//有效的括号匹配
public class valid_parentheses_match {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        validMatch res = new validMatch();
        boolean is_valid = res.isValid(s);
        System.out.println(is_valid);
    }
}
class validMatch{
    public boolean isValid(String s){
        //如果字符串长度为奇数,说明肯定不匹配,所以直接返回false;
        if(s.length()%2!=0){
            return false;
        }
        Stack<Character> stack = new Stack<>();//用来判断的栈
        //通过for循环来遍历字符串
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            //如果字符串为左括号,就往栈中加如相应的右括号,方便下面判断匹配情况
            if(c=='('){
                stack.push(')');
            }
            else if(c=='{'){
                stack.push('}');
            }
            else if(c=='['){
                stack.push(']');
            }
            //如果栈为空或者字符不匹配的话,返回false;
            else if(stack.empty() || stack.peek()!=c){
                return false;
            }
            //如果是右括号判断是否和栈顶元素匹配,则取出
            else {
                stack.pop();
            }
        }
        //最后遍历完字符串后,判断栈是否为空,如果为空的话则说明匹配
        return true;
    }
}

//public class valid_parentheses_match {
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        String s = sc.next();
//        if(s.length()%2!=0){
//            System.out.println("false");
//        }
//        Stack<Character> stack = new Stack<>();//用来判断的栈
//        //通过for循环来遍历字符串
//        for(int i=0;i<s.length();i++){
//            char c = s.charAt(i);
//            //如果字符串为左括号,就往栈中加如相应的右括号,方便下面判断匹配情况
//            if(c=='('){
//                stack.push(')');
//            }
//            else if(c=='{'){
//                stack.push('}');
//            }
//            else if(c=='['){
//                stack.push(']');
//            }
//            //如果栈为空或者字符不匹配的话,返回false;
//            else if(stack.empty() || stack.peek()!=c){
//                System.out.println("false");
//            }
//            //如果是右括号判断是否和栈顶元素匹配,则取出
//            else {
//                stack.pop();
//            }
//        }
//        //最后遍历完字符串后,判断栈是否为空,如果为空的话则说明匹配
//        System.out.println("true");
//    }
//}

