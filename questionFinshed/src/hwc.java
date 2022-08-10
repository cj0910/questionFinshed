import java.util.Scanner;

//回文串
public class hwc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.next();
            char[] arr = s.toCharArray();
            int len = s.length();
            int  start = 0,end = len-1;
            int mid = (start + end)/2;
            while (start<end){
                if (arr[start] != arr[end]){
                    char[] temp = arr;
                    for (int i = (start+1); i<=mid; i++){
                        if(arr[i]==arr[start]){
                            temp[end] = arr[i];
                            temp[i] = arr[end];
                            boolean flag = judgeS(temp);
                            if(flag){
                                System.out.println("Yes");
                                break;
                            }
                        }
                    }
                }
                start++;
                end--;
            }
            if(start>=end)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
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
