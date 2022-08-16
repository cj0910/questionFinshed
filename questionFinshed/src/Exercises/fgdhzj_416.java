package Exercises;

//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
public class fgdhzj_416 {
    public static void main(String[] args) {
        solution_canPartition aa = new solution_canPartition();
        int[] nums = {1, 5, 11, 5};
        System.out.println(aa.canPartition(nums));
    }
}

class solution_canPartition{
    public boolean canPartition(int[] nums){
        if(nums==null || nums.length==0) return false;
        int n = nums.length;
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        //若总和为奇数，则不能平分
        if(sum%2 == 1) return false;
        int target = sum/2;
        //dp[i][j]表示从标号1-i的商品中挑选，背包容量在j的情况下，背包容量的最大价值
        int[][] dp = new int[n][target+1];
        //初始化，dp[0][j]最大价值为nums[0]，dp[i][0]为0；
        for(int j = nums[0];j<=target;j++){
            dp[0][j] = nums[0];
        }
        //遍历物品，遍历背包
        for(int i=1;i<n;i++){
            for(int j=1;j<=target;j++){
                if(j>=nums[i]){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-nums[i]]+nums[i]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n-1][target] == target;
    }
}