package Exercises;

import java.util.Scanner;
//字符串压缩
public class ziChuChuanYaSuo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入字符串：");
        String s = input.nextLine();
        String s1 = compress(s);
        System.out.println("压缩后为："+s1.toString());
    }

    public static String compress(String s){
        int len=s.length();
        char[] ch=s.toCharArray();
        StringBuffer newStr = new StringBuffer();
        int sum = 1;
        int flag=0;
        int left=0;
        int right=1;
        while(right<len){
            char temp=ch[left];
            if(ch[right]==temp){
                right++;
                sum++;
                flag=1;
            }else {//当出现不一样的字符时候
                newStr.append(temp).append(sum);//添加到新字符中
                sum=1;//重新计数
                left=right;//更新字母
                right++;
            }
        }
        //添加最后一个字母
        newStr.append(s.charAt(left)).append(sum);
        return flag==1 ? newStr.toString() : s;
    }
}

//    public String compressString(String S) {
//        int i = 0, j = 0, ls = S.length();
//        StringBuilder res = new StringBuilder();//创建新的字符串对象
//        while (i < ls) {
//            while (j < ls && S.charAt(i) == S.charAt(j))
//                j++;
//            res.append(S.charAt(i)).append(j - i);//把字符以及出现的次数添加到字符串里
//            i = j;
//        }
//        return res.length() < ls ? res.toString() : S;
//    }


