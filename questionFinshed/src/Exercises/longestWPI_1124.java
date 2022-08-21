package Exercises;
//给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
//所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。请你返回「表现良好时间段」的最大长度
public class longestWPI_1124 {
    public static void main(String[] args) {
        int[] arr = {9,9,6,0,6,6,9};
        int res = longestWPI(arr);
        System.out.println(res);
    }

    public static int longestWPI(int[] hours) {
        int n = hours.length;
        for(int i=0;i<n;i++){
            hours[i] = hours[i]>8 ? 1:-1;
        }
        int maxLen = 0;
        int[] preSum = new int[n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                preSum[j] += hours[i];
                if(preSum[j]>0){
                    maxLen = Math.max(maxLen,i-j+1);
                }
            }
        }
        return  maxLen;
//        int[] prefixSum = new int[n+1];
//        prefixSum[0] = 0;
//        for(int i=1;i<=n;i++){
//            prefixSum[i] = prefixSum[i-1] + hours[i-1];
//        }

    }
}
//class Solution_1124 {
//    public int longestWPI(int[] hours) {
//
//        return 0;
//    }
//}