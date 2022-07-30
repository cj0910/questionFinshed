package Exercises;

import java.util.Scanner;
//字符串压缩
public class ziChuChuanYaSuo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入字符串：");
        String s = input.nextLine();
//        String s1 = compress(s);
//        System.out.println("压缩后为："+s1.toString());
        solution_compress sc = new solution_compress();
        String res = sc.compressString(s);
        System.out.println(res);
    }

    public static String compress(String s){
        int len=s.length();
        char[] ch=s.toCharArray();
        StringBuilder newStr = new StringBuilder();
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

class solution_compress{
    public String compressString(String s){
        char[] res = s.toCharArray();
        int start = 0;
        int end = 0;
        int len = s.length();
        int cnt = 0;
        StringBuilder ss= new StringBuilder();
        //下面的循环条件若为：end < len，则会出现问题：最后一个字符不能统计进去
        while(start < len){
            if(end < len && res[start]==res[end]){
                end++;
                cnt++;
            }else {
                ss.append(res[start]).append(cnt);
                cnt = 0;
                start = end;
            }
        }
        return ss.toString();
    }

    //写法二
    public String compressString2(String S) {
        int i = 0, j = 0, ls = S.length();
        StringBuilder res = new StringBuilder();//创建新的字符串对象
        while (i < ls) {
            while (j < ls && S.charAt(i) == S.charAt(j))
                j++;
            res.append(S.charAt(i)).append(j - i);//把字符以及出现的次数添加到字符串里
            i = j;
        }
        return res.length() < ls ? res.toString() : S;
    }
}



