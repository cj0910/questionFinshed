package Exercises;

public class kmpMatch {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        System.out.println(kmpMatch(str1, str2));
    }

    //KMP匹配表
    public static int[] kmpNext(char[] T) {
        int[] next = new int[T.length];
        for (int i = 1, j = 0; i < T.length; i++) {
            //然后再考虑不相等的情况2
            while (j > 0 && T[i] != T[j]) {
                j = next[j - 1];
            }
            //写代码先考虑相等的情况1
            if (T[i] == T[j]) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    //KMP匹配法
    public static int kmpMatch(String str1, String str2) {
        int[] next = kmpNext(str2.toCharArray());
        for (int i = 0, j = 0; i < str1.length(); i++) {
            //然后再考虑不相等的情况2
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
            //写代码先考虑相等的情况1
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }
}




//public class kmpMatch {
//    public static void main(String[] args) {
//        String str1 = "BBC ABCDAB ABCDABCDABDE";
//        String str2 = "ABCDABD";
//        System.out.println(kmpMatch(str1, str2));
//    }
//
//    //KMP匹配表
//    public static int[] kmpNext(String str2) {
//        int[] next = new int[str2.length()];
//        for (int i = 1, j = 0; i < str2.length(); i++) {
//            //然后再考虑不相等的情况2
//            while (j > 0 && str2.charAt(i) != str2.charAt(j)) {
//                j = next[j - 1];
//            }
//            //写代码先考虑相等的情况1
//            if (str2.charAt(i) == str2.charAt(j)) {
//                j++;
//            }
//            next[i] = j;
//        }
//        return next;
//    }
//
//    //KMP匹配法
//    public static int kmpMatch(String str1, String str2) {
//        int[] next = kmpNext(str2);
//        for (int i = 0, j = 0; i < str1.length(); i++) {
//            //然后再考虑不相等的情况2
//            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
//                j = next[j - 1];
//            }
//            //写代码先考虑相等的情况1
//            if (str1.charAt(i) == str2.charAt(j)) {
//                j++;
//            }
//            if (j == str2.length()) {
//                return i - j + 1;
//            }
//        }
//        return -1;
//    }
//}
//

