package Exercises;

public class KMP {
    public static void main(String[] args){
        String s1 = "abacababc";
        String s2 = "abab";
        System.out.println("Hi");
        Solution res = new Solution();
        System.out.println(res.strStr(s1,s2));
        System.out.println("hello");
    }

}
class Solution {
    // KMP 算法
    // ss: 原串(string)  pp: 匹配串(pattern)
    public int strStr(String ss, String pp) {
        if (pp.isEmpty()) return 0;

        // 分别读取原串和匹配串的长度
        int n = ss.length(), m = pp.length();
        // 原串和匹配串前面都加空格，使其下标从 1 开始
        ss = " " + ss;
        pp = " " + pp;

        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();

        // 构建 next 数组，数组长度为匹配串的长度（next 数组是和匹配串相关的）
        int[] next = new int[m + 1];
        // 构造过程 i = 2，j = 0 开始，i 小于等于匹配串长度 【构造 i 从 2 开始】
        for (int i = 2, j = 0; i <= m; i++) {
            // 匹配不成功的话，j = next(j)
            while (j > 0 && p[i] != p[j + 1]) j = next[j];
            // 匹配成功的话，先让 j++
            if (p[i] == p[j + 1]) j++;
            // 更新 next[i]，结束本次循环，i++
            next[i] = j;
        }

        // 匹配过程，i = 1，j = 0 开始，i 小于等于原串长度 【匹配 i 从 1 开始】
        for (int i = 1, j = 0; i <= n; i++) {
            // 匹配不成功 j = next(j)
            while (j > 0 && s[i] != p[j + 1]) j = next[j];
            // 匹配成功的话，先让 j++，结束本次循环后 i++
            if (s[i] == p[j + 1]) j++;
            // 整一段匹配成功，直接返回下标
            if (j == m) return i - m;
        }

        return -1;
    }
}


//public class KMP {
////在本类中调用自己的方法，方法必须为静态的，否则报错;
//    //解决方法1：必须将kmpAlgorithm()方法定义为static方法，才能在main()方法中直接调用
//    //解决方法2：首先实例化本类的对象，然后通过对象调用方法
//    public static void main(String[] args){
//        String s1 = "abacababc";
//        String s2 = "abab";
//        System.out.println("Hi");
//        int res = kmpAlgorithm(s1,s2);
//        System.out.println(res);
////        //首先，实例化本类的对象
////        KMP ob = new KMP();
////        //然后通过对象调用方法
////        System.out.println(ob.kmpAlgorithm(s1,s2));
//        System.out.println("hello");
//    }
//
//    public static int kmpAlgorithm(String mainStr,String targetStr){
//        int i=0,j=0;
//        int lenM=mainStr.length();
//        int lenT=targetStr.length();
//        int[] next = new int[lenT];
//        char[] son = targetStr.toCharArray();
//        char[] father = mainStr.toCharArray();
//        getNext(son,next);
//        while (i<lenM && j<lenT){
//            if(j==-1 || son[j]==father[i]){
//                i++;
//                j++;
//            }else {
//                j=next[j];
//            }
//        }
//        if(j==lenT)
//            return i-j;
//        else
//            return -1;
//    }
//    public static void getNext(char[] son,int[] next){
//        int i = 1,j = 0;
//        next[1] = 0;
//        while(i<son.length){
//            if(j==-1 || son[i]==son[j]){
//                j++;
//                i++;
//                next[i] = j;
//            }
//            else {
//                j = next[j];
//            }
//        }
//    }
//}

