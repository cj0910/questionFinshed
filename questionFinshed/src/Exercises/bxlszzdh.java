package Exercises;

import java.util.Arrays;
import java.util.Scanner;

//求不相邻的数字最大和
public class bxlszzdh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int res = getMax(arr);
        System.out.println(res);
    }
    public static int getMax(int[] arr){
        int len = arr.length;
        if(len==0) return 0;
        if(len==1) return arr[0];
        int[] dp = new int[len];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0],arr[1]);
        for(int i=2;i<len;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+arr[i]);
        }
        return dp[len-1];
    }
}

//dp[i]为0-i数组中不相邻数据的最大值，对于i个数据可以取也可以不取，若取的话则值为 dp[i-2]+nums[i],若不取的话则dp[i-1]则状态转移方程dp[i]=Max(dp[i-1],dp[i-2]+nums[i])；初始值dp[0]=nums[0],dp[1]=Max(nums[0],nums[1])