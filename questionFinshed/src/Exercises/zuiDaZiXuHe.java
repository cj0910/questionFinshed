package Exercises;

public class zuiDaZiXuHe {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        Solution_zuiDaZiXuHe sa = new Solution_zuiDaZiXuHe();
        int res = sa.maxSubArray(nums);
        System.out.println(res);
    }
}

class Solution_zuiDaZiXuHe {
    //方法一：贪心算法
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if(len==1)
            return nums[0];
        int maxSum = Integer.MIN_VALUE;//统计最大的连续子序列和
        int cnt = 0;//统计连续元素的和
        for(int i=0;i<len;i++){
            cnt += nums[i];
            maxSum = Math.max(maxSum, cnt);
            if(cnt<0){
                cnt = 0;
            }
        }
        return maxSum;
    }
    //方法一：动态规划
    public int maxSubArray2(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int maxValue = dp[0];
        for(int i=0;i<len;i++){
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            maxValue = Math.max(dp[i], maxValue);
        }
        return maxValue;
    }
}