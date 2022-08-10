import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        String s="abba";
        char[] ch = s.toCharArray();
        boolean f = judgeS(ch);
        System.out.println(f);
    }
    public static boolean judgeS(char[] arr){
        int len = arr.length;
        int start = 0, end = len-1;
        while (start<len && end>0){
            char ch1 = arr[start];
            char ch2 = arr[end];
            if(ch1 == ch2){
                start++;
                end--;
            }else {
                return false;
            }
        }
        return true;
    }
}
