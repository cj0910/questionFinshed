import java.util.Scanner;

//文本相似度，即leetcode上题目：72.编辑距离——hard等级
public class wbxsd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int len1 = s1.length();
        int len2 = s2.length();
        int maxLen = Math.max(len1, len2);
        int minLen = Math.min(len1,len2);
        String maxS;
        String minS;
        if (len1 < len2){
            minS = s1;
            maxS = s2;
        }
        else{
            minS = s2;
            maxS = s1;
        }
        char[] ch1 = maxS.toCharArray();
        char[] ch2 = minS.toCharArray();
        int cnt = 0;
        int maxCnt = 0;
        for(int x1=0;x1<maxLen;x1++){
            for (int x2=0;x2<minLen;x2++){
                if(ch1[x1]==ch2[x2]){
                    cnt++;
                    maxCnt = Math.max(cnt,maxCnt);
                }
                else{
                    break;
                }
            }
        }
        double res = 1.00 - (double)(maxCnt/maxLen);
        System.out.println(res);
    }
}
