package Exercises;

import java.util.Scanner;

public class leetcode_1047 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String res = removeDuplicates(s);
        System.out.println(res);
    }
    public static String removeDuplicates(String s){
        int len = s.length();
        char[] arr = s.toCharArray();
        int right = 0;
        int left = -1;//left-1，因为如果前面两个数据相同，left会回退到-1
        while (right < len){
            //当left是-1，说明第一个不重复的数据还没存放，直接存放即可
            if(left == -1 || arr[right]!=arr[left]){
                arr[++left] = arr[right];
            }else {
                //如果出现重复，就删除left索引指向的数据
                left--;
            }
            right++;
        }
        return new String(arr,0,left+1);
    }
}
